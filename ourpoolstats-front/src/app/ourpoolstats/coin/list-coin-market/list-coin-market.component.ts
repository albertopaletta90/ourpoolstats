import { Component, OnInit } from '@angular/core';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko, CoinMarketInfoResponse } from '../../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { TranslateService } from '@ngx-translate/core';
import { ActivatedRoute, RoutesRecognized, NavigationEnd } from '@angular/router';
import { UserList, UserListResponse, getName } from '../../../model/model';
import { ChangeDetectionStrategy, ViewChild } from '@angular/core';
import { of  } from 'rxjs/observable/of';
import { map } from 'rxjs/operators';
import { MatSort, Sort } from '@angular/material';
import { MatPaginator, PageEvent } from '@angular/material';
import { fromMatSort, sortRows } from './datasource-utils';
import { fromMatPaginator, paginateRows } from './datasource-utils';

@Component({
  selector: 'app-list-coin-market',
  templateUrl: './list-coin-market.component.html',
  styleUrls: ['./list-coin-market.component.scss']
})

export class ListCoinMarketComponent implements OnInit {
  coinMarketList: CoinMarket[];
  coinName : string;

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



 goToInfo(name){
   this.coinName = name;
   sessionStorage.setItem('coin',name);
   this.router.navigate(['infoCoinMarket']);    
}

}
