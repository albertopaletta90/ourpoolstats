import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserLog, LogUserResponse } from '../../../model/model';

@Component({
  selector: 'app-user-log',
  templateUrl: './user-log.component.html',
  styleUrls: ['./user-log.component.css']
})
export class UserLogComponent implements OnInit {
  error: boolean;
  typeAlert: string;
  type: string;
  single : boolean;
  username : string;
  userLog : UserLog[];
  constructor(private route: ActivatedRoute,private http: HttpClient,private router: Router) {
    this.route.params.subscribe((params) => this.type = params.type);
    this.route.params.subscribe((params) => this.username = params.username);
    this.single = this.type == 'single' ? true : false
    this.single ? this.logUser() :  this.router.navigate(['listUserLog',{type : this.type}]);
  }

  ngOnInit() {
  }

  logUser(){
    this.router.navigate(['listUserLog',{type : this.type, username : this.username}]);
  }

}