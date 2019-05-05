import { Component, OnInit,ViewChild } from '@angular/core';
import { CoinMarket, CoinMarketResponse, BalanceResponse } from '../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { of  } from 'rxjs/observable/of';
import { map } from 'rxjs/operators';
import { MatSort, Sort,MatPaginator, PageEvent } from '@angular/material';
import { fromMatSort, sortRows,fromMatPaginator, paginateRows} from './datasource-utils';
@Component({
  selector: 'app-list-buy',
  templateUrl: './list-buy.component.html',
  styleUrls: ['./list-buy.component.scss']
})
export class ListBuyComponent implements OnInit {

  quantity: string;
  coinMarketList: CoinMarket[];
  coinIndex : string;
  username : string = sessionStorage.getItem('username')
  constructor(private http: HttpClient,private router: Router) {}

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedRows$: Observable<CoinMarket[]>;
  totalRows$: Observable<number>;

  ngOnInit() {
      this.http.get<CoinMarketResponse>('http://localhost:8080/newourpoolstats/getCoinMarketList').
      subscribe(data => {
        this.coinMarketList = data.coinMarketList;
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);

        const rows$ = of(this.coinMarketList);

        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
      });
}

buy(index : number){
  this.http.post<BalanceResponse>(`http://localhost:8080/newourpoolstats/buy/${this.quantity}/coin/${index}/username/${this.username}`,{}).
      subscribe(data => {
        this.router.navigate(['market',{typeAlert : 'success' ,message: 'Acquisto Avvenuto Correttamente',activeAlert : true}]);  
      }, error => {
     
      this.router.navigate(['market',{typeAlert : 'danger' ,message: 'Errore Nel Acquisto della moneta',activeAlert : true}]);        
    });

}

}
