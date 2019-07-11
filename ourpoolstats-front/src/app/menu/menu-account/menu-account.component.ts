import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { getLink } from 'src/app/app.module';

@Component({
  selector: 'app-menu-account',
  templateUrl: './menu-account.component.html',
  styleUrls: ['./menu-account.component.css']
})
export class MenuAccountComponent implements OnInit {

  username : string = sessionStorage.getItem('username');
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit() {}

  goToAddImage(){
    this.router.navigate(['addImage']);
  }

  goToChangePassword(){
    this.router.navigate(['setPassword']);
  }

  goTochangeEmail(){
    this.router.navigate(['changeEmail']);
  }

  logout(){
    this.http.get(getLink()+`/logout/${this.username}`).
      subscribe(data => {
        this.router.navigate(['logout',{typeAlert : 'success' ,message: 'Arrivederci',activeAlert : true}]);              
      }, error => {    
    });
  }
}
