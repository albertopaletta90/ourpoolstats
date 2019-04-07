import { Component, OnInit } from '@angular/core';
import { CoinMarket, BalanceResponse, Balance } from '../../model/model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute, RoutesRecognized, NavigationEnd, Router } from '@angular/router';
import { ChangeDetectionStrategy, ViewChild } from '@angular/core';
import { of  } from 'rxjs/observable/of';
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
  coinIndex : string;
  username : string = sessionStorage.getItem('username');

  constructor(private http: HttpClient,private router: Router) {}

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedRows$: Observable<Balance[]>;
  totalRows$: Observable<number>;

  ngOnInit() {
      this.http.get<BalanceResponse>(`http://localhost:8080/newourpoolstats/getListMarket/${this.username}`).
      subscribe(data => {
        this.coinMarketList = data.balance;
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);
        const rows$ = of(this.coinMarketList);
        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
      });
}

sell(index : number){
  this.http.post<BalanceResponse>(`http://localhost:8080/newourpoolstats/sell/${this.quantity}/coin/${index}/username/${this.username}`,{}).
      subscribe(data => {
        this.router.navigate(['market',{typeAlert : 'success' ,message: 'Vendita Avvenuta Correttamente',activeAlert : true}]);  
      }, error => {   
      this.router.navigate(['market',{typeAlert : 'danger' ,message: 'Errore Nella Vendita della moneta',activeAlert : true}]);        
    });

}
}
