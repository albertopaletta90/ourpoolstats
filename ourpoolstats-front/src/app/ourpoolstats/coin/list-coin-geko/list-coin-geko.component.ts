import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko } from '../../../model/model';
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
import { getLink } from 'src/app/app.module';

@Component({
  selector: 'app-list-coin-geko',
  templateUrl: './list-coin-geko.component.html',
  styleUrls: ['./list-coin-geko.component.scss']
})
export class ListCoinGekoComponent implements OnInit {
  coingekoList: CoinGeko[];

  constructor(private http: HttpClient) {}

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedRows$: Observable<CoinGeko[]>;
  totalRows$: Observable<number>;

  ngOnInit() {
    this.http.get<CoinGekoResponse>(getLink()+'/getCoinGekoList').
      subscribe(data => {
        this.coingekoList = data.coingekoList;
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);
        const rows$ = of(this.coingekoList);
        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
      }); 
  }
}


