import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../../model/model';
import { Router } from '@angular/router';
import {FormControl, Validators} from '@angular/forms';
import {getRequiredError, getEMailsError} from '../../../messages/messages'

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  error: boolean = false;
  name = new FormControl('', [Validators.required]);
  surname = new FormControl('', [Validators.required]);
  email = new FormControl('', [Validators.required, Validators.email]);
  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required]);
  U: User;
  typeAlert : string;
  message : string ;
  constructor(private http: HttpClient, private router: Router) {}

createUser(){
  let u = new User(this.name.value,this.surname.value,this.username.value,this.password.value,this.email.value);
  this.http.post<User>(`http://localhost:8080/newourpoolstats/createUser/${this.name.value}/surname/${this.surname.value}/username/${this.username.value}/password/${this.password.value}/email/${this.email.value}`,{}).
      subscribe(data => {
        this.typeAlert = 'success';
        this.message = 'Utente inserito correttamente';
        this.router.navigate(['listUser',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
    }, error => {
      this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Utente già presente';
      this.router.navigate(['createUser',{typeAlert: this.typeAlert,message : this.message}]);   
    });
} 

back(){
  this.router.navigate(['listUser']);
}

ngOnInit() {}

getErrorMessage() {
  
  return this.name.hasError('required') ? getRequiredError() :
         this.surname.hasError('required') ? getRequiredError() :
         this.username.hasError('required') ? getRequiredError() :
         this.password.hasError('required') ? getRequiredError() :
         this.email.hasError('email') ? getEMailsError() :
        '';
  }

}

