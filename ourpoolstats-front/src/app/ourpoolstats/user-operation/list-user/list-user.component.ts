import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RoutesRecognized, NavigationEnd } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserList, UserListResponse, getName } from '../../../model/model';
import { ChangeDetectionStrategy, ViewChild } from '@angular/core';
import { Observable  } from 'rxjs/Observable';
import { of  } from 'rxjs/observable/of';
import { map } from 'rxjs/operators';
import { MatSort, Sort } from '@angular/material';
import { MatPaginator, PageEvent } from '@angular/material';
import { fromMatSort, sortRows } from './datasource-utils';
import { fromMatPaginator, paginateRows } from './datasource-utils';


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {


  userList : UserList[];
  username : string = sessionStorage.getItem('username')
  view : boolean;

  public constructor(private route: ActivatedRoute,private http: HttpClient,private router: Router) {
    this.route.params.subscribe((params) => this.view = params.activeAlert);
  
  }


  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedRows$: Observable<UserList[]>;
  totalRows$: Observable<number>;

  ngOnInit() {
    this.http.get<UserListResponse>(`http://localhost:8080/newourpoolstats/getUserList/${this.username}`)
    .subscribe(data =>{
        this.userList = data.userList;
        const sortEvents$: Observable<Sort> = fromMatSort(this.sort);
        const pageEvents$: Observable<PageEvent> = fromMatPaginator(this.paginator);

        const rows$ = of(this.userList);

        this.totalRows$ = rows$.pipe(map(rows => rows.length));
        this.displayedRows$ = rows$.pipe(sortRows(sortEvents$), paginateRows(pageEvents$));
      });
}


goToDeleteUser(id: number){
  var name = this.userList[id].username;
  this.router.navigate(['deleteUser',{name : name}]);

};

goToChangeTypeUser = function(id: number){
  var name = this.userList[id].username;
  this.router.navigate(['changeTypeUser',{name : name}]);
};

goToLogUser(id : number){
  var name = this.userList[id].username;
  this.router.navigate(['logUser',{type : 'single',username : name}])
};

}

