import { Component, OnInit } from '@angular/core';
import { BalanceResponse, Balance, GenericResponse, CurrentyCoinResponse } from '../../model/model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { ViewChild } from '@angular/core';
import { of } from 'rxjs/observable/of';
import { map } from 'rxjs/operators';
import { MatSort, Sort } from '@angular/material';
import { MatPaginator, PageEvent } from '@angular/material';
import { fromMatSort, sortRows } from './datasource-utils';
import { fromMatPaginator, paginateRows } from './datasource-utils';

@Component({
  selector: 'app-list-sell',
  templateUrl: './list-sell.component.html',
  styleUrls: ['./list-sell.component.scss']
})
export class ListSellComponent implements OnInit {
  quantity: string;
  coinMarketList: Balance[];
  coinIndex: string;
  username: string = sessionStorage.getItem('username');
  a: string;
  constructor(private http: HttpClient, private router: Router) { }
  // Pie
  coinsLabelsChart: string[] = [];
  coinsDataChart: number[] = [];
  CoinsTypeChart: string = 'doughnut';
  balanceLabelsChat: string[] = ['Prezzo Initiale', 'Prezzo Corrente'];
  balanceDataChat: number[] = [100, 400];
  balanceTypeChart: string = 'doughnut';
  // events
  public chartClicked(e: any): void {
    console.log(e);
  }
  public chartHovered(e: any): void {
    console.log(e);
  }
  @ViewChild(MatSort)
  sort: MatSort;
  @ViewChild(MatPaginator)
  paginator: MatPaginator;
  displayedRows$: Observable<Balance[]>;
  totalRows$: Observable<number>;
  ngOnInit() {
    this.http.get<BalanceResponse>(`http://localhost:8080/newourpoolstats/getListMarket/${this.username}`).
      subscribe(data => {
        this.coinMarketList = data.balance;
        this.setChartPie();
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);
        const rows$ = of(this.coinMarketList);
        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
        this.setCurrentCoin();
      });
  }
  sell(index: number) {
    this.http.post<BalanceResponse>(`http://localhost:8080/newourpoolstats/sell/${this.quantity}/coin/${index}/username/${this.username}`, {}).
      subscribe(data => {
        this.ngOnInit();
        this.setChartPie();
        this.router.navigate(['market', { typeAlert: 'success', message: 'Vendita Avvenuta Correttamente', activeAlert: true }]);
      }, error => {
        this.router.navigate(['market', { typeAlert: 'danger', message: 'Errore Nella Vendita della moneta', activeAlert: true }]);
      });
  }
  setChartPie() {
    this.coinsLabelsChart = [];
    this.coinsDataChart = [];
    this.coinMarketList.forEach(element => {
      this.coinsLabelsChart.push(element.nameCoin);
      this.coinsDataChart.push(element.quantity);
    });
  }
  setCurrentCoin() {
    this.coinMarketList.forEach(element => {
      this.http.post<CurrentyCoinResponse>(`http://localhost:8080/newourpoolstats/getCurrentCurrency/${element.nameCoin}`, {}).
        subscribe(data => {
          element.currentCurrency = data.value;
          element.util = data.value - element.initialCurrency;
          element.util = parseFloat(element.util.toFixed(7));
          this.http.get<GenericResponse>(`http://localhost:8080/newourpoolstats/imageCoin/${element.nameCoin}`).
            subscribe(image => {
              element.image = image.data[0];
            });
        });
    });
  }
  public chartColors: any[] = [
    {
      backgroundColor: ["#FF7360", "#6FC8CE", "#FAFFF2", "#FFFCC4", "#B9E8E0"]
    }
  ];
}
