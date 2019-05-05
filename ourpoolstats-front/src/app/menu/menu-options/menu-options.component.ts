import { Component, OnInit } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserList, UserListResponse } from '../../model/model';

@Component({
  selector: 'app-menu-options',
  templateUrl: './menu-options.component.html',
  styleUrls: ['./menu-options.component.css']
})
export class MenuOptionsComponent implements OnInit {

  userList : UserList[];
  typeUser : String = sessionStorage.getItem('typeUser');
  constructor(private router: Router,private http: HttpClient) {}

  ngOnInit() {}

  goToCreateUser = function() {
    this.router.navigate(['createUser']);
  };

  goToAddCoin = function(){
    this.router.navigate(['addCoin']);
  }

  goToDeleteCoin = function(){
    this.router.navigate(['deleteCoin']);

  }

  goToLogUser= function(type : string){
    this.router.navigate(['logUser',{type : type}]);
  }

  goToListUser(){
      this.router.navigate(['listUser']);
  }

  goToUserOnline(){
    this.router.navigate(['userOnline']);
  }
}
