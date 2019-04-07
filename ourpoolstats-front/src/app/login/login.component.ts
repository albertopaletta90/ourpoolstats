import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgModel } from '@angular/forms';
import { LoginResponse, User, CoinGeko, CoinMarket, CoinGekoResponse, Login, UserListResponse, UserList} from '../model/model';
import {HttpClientModule} from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import {Observable,of, from } from 'rxjs';
import { map } from 'rxjs/operators';
import 'rxjs/add/operator/map'
@Injectable()
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    user: string;
    pass: string;
    u : Login;
    status : string;
    typeError : string;
    alert : boolean = false;
    message : string;


  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute){}

  login() {
    let u = new Login(this.user,this.pass);
    this.http.post<LoginResponse>('http://localhost:8080/newourpoolstats/login/?login=' + this.user+','+this.pass,this.u).
      subscribe(data => {
        var go = (data.status == "200")? 'dashboard' : 'setPassword';
        var setPassword = (go == "dashboard") ? 'noSetAlert' : 'setAlert';
        sessionStorage.setItem('setAlert',setPassword);
        this.router.navigate([go]);
        sessionStorage.setItem('typeUser',data.typeUser);        
        sessionStorage.setItem('current','coinMarket')
        sessionStorage.setItem('username',this.user)

      }, error => {
     
      this.router.navigate(['logout',{typeAlert : 'danger' ,message: 'Password/Username errati',activeAlert : true}]);        
    });
 

  }
  
  ngOnInit() {
    this.route.params.subscribe((params) => this.alert = params.activeAlert);
  }

 

  

}
