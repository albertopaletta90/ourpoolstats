import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../../../model/model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  error: boolean = false;
  name : string;
  surname : string;
  email : string;
  username : string;
  password : string;
  U: User;
  typeAlert : string;
  message : string ;
  constructor(private http: HttpClient, private router: Router) {}

createUser(){
  let u = new User(this.name,this.surname,this.username,this.password,this.email);
  this.http.post<User>(`http://localhost:8080/newourpoolstats/createUser/${this.name}/surname/${this.surname}/username/${this.username}/password/${this.password}/email/${this.email}`,{}).
      subscribe(data => {
        this.typeAlert = 'success';
        this.message = 'Utente inserito correttamente';
        this.router.navigate(['dashboard',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
    }, error => {
      this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Utente già presente';
      this.router.navigate(['createUser',{typeAlert: this.typeAlert,message : this.message}]);   
    });
} 

back(){
  this.router.navigate(['dashboard']);
}

  ngOnInit() {
  }


}
