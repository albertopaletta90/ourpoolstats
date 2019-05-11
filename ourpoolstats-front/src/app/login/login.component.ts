import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse,Login} from '../model/model';
import { Router, ActivatedRoute } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

import 'rxjs/add/operator/map'
import { getLink } from '../app.module';
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


  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute,private spinner: NgxSpinnerService){}

  login() {
    this.spinner.show();
    let u = new Login(this.user,this.pass);
    this.http.post<LoginResponse>(getLink()+'/login/?login=' + this.user+','+this.pass,this.u).
      subscribe(data => {
        var go = (data.status == "200")? 'dashboard' : 'setPassword';
        var setPassword = (go == "dashboard") ? 'noSetAlert' : 'setAlert';
        sessionStorage.setItem('setAlert',setPassword);
        sessionStorage.setItem('typeUser',data.typeUser);        
        sessionStorage.setItem('current','coinMarket')
        sessionStorage.setItem('username',this.user)
        this.spinner.hide();
        this.router.navigate([go]);
      }, error => {
        this.spinner.hide();
      this.router.navigate(['logout',{typeAlert : 'danger' ,message: 'Password/Username errati',activeAlert : true}]);        
    });
 

  }
  
  ngOnInit() {
    this.route.params.subscribe((params) => this.alert = params.activeAlert);
  }

 

  

}
