import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgModel } from '@angular/forms';
import { LoginResponse, User, CoinGeko, CoinMarket, CoinGekoResponse} from '../model/model';
import {HttpClientModule} from '@angular/common/http';
import { Router } from '@angular/router';
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
    u : User;
    status : string;
    coingeko : CoinGeko[];
    coinMarket :  Array<CoinMarket>;
    typeError : string;
  constructor(private http: HttpClient, private router: Router){}

  login() {
    let u = new User(this.user,this.pass);
    this.http.post<LoginResponse>('http://localhost:8080/newourpoolstats/login/?login=' + this.user+','+this.pass,this.u).
      subscribe(data => {
        this.router.navigate(['dashboard']);
        sessionStorage.setItem('typeUser',data.typeUser);        
        sessionStorage.setItem('current','coinMarket')
      }, error => {
      this.typeError = 'Login';
      this.router.navigate(['errorLogin',{typeEroor: this.typeError}]);        
    });
  }
  
  ngOnInit() {
  }

 

  

}
