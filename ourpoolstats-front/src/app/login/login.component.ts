import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgModel } from '@angular/forms';
import { LoginResponse, User, CoinGeko, CoinMarket} from '../model/model';
import {HttpClientModule} from '@angular/common/http';
import { Router } from '@angular/router';

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
    coinMarket :  CoinMarket[];
    loginResponse : LoginResponse; 
  constructor(private http: HttpClient, private router: Router){}

  login() {
    let u = new User(this.user,this.pass);
    this.http.post<LoginResponse>('http://localhost:8080/newourpoolstats/login/?login=' + this.user+','+this.pass,this.u).
      subscribe(data => {
      if(data.status == "200"){
        this.loginResponse = data;
        this.router.navigate(['succesLogin']);        
      }    
        
    }, error => {
      alert('Username/Password Errati');
    });
  }



  ngOnInit() {
  }

}
