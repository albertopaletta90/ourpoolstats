import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, MatPaginator, Sort, PageEvent } from '@angular/material';
import { Observable, of } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { StringResponse } from 'src/app/model/model';
import { fromMatSort, fromMatPaginator, sortRows, paginateRows } from './datasource-utils';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-user-online',
  templateUrl: './user-online.component.html',
  styleUrls: ['./user-online.component.scss']
})
export class UserOnlineComponent implements OnInit {

  userOnline :string[];
  username : string = sessionStorage.getItem('username');
  sender : string;
  reciver : string = this.username;
  public constructor(private route: ActivatedRoute,private http: HttpClient,private router: Router) {}

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedRows$: Observable<string[]>;
  totalRows$: Observable<number>;

  ngOnInit() {
    this.http.get<StringResponse>(`http://localhost:8080/newourpoolstats/userOnline/${this.username}`)
    .subscribe(data =>{
        this.userOnline = data.data;
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);

        const rows$ = of(this.userOnline);

        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
      });

}

goToChat(index:number){
  this.reciver = this.userOnline[index];
  

}
goToSendMail(index:number){
  this.reciver = this.userOnline[index];

}

}
