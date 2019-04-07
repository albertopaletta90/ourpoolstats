import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-set-password',
  templateUrl: './set-password.component.html',
  styleUrls: ['./set-password.component.css']
})
export class SetPasswordComponent implements OnInit {

  typeAlert: string;
  message: string;
  error: boolean;
  oldPassword : string;
  password : string ;
  repeatPassword : string;

  constructor(private http: HttpClient, private router: Router) {}

changePassword(){

  if(this.password == this.repeatPassword){
    
    this.http.post(`http://localhost:8080/newourpoolstats/changePassword/${sessionStorage.getItem("username")}/password${this.oldPassword}/newPassword${this.password}`,{}).
      subscribe(data => {
          this.typeAlert = 'success';
          this.message = 'Password cambiata correttamente';
          this.router.navigate(['account',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
        }, error => {
          this.error = true;
          this.typeAlert = 'danger';
          this.message = 'Password non corretta';
          this.router.navigate(['setPassword',{typeAlert: this.typeAlert,message : this.message}]);  
      });

  }

} 
  ngOnInit() {
  }

}
