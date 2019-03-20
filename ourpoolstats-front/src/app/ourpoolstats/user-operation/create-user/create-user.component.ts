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

  name : string;
  surname : string;
  email : string;
  username : string;
  password : string;
  U: User;
 

  createUserLabels : any;
  constructor(private http: HttpClient, private router: Router) {
    this.getJSON().subscribe(data => {
        this.createUserLabels = data;
    });
}

createUser(){
  let u = new User(this.name,this.surname,this.username,this.password,this.email);
  this.http.post<User>(`http://localhost:8080/newourpoolstats/createUser/${this.name}/surname/${this.surname}/username/${this.username}/password/${this.password}/email/${this.email}`,{}).
      subscribe(data => {
        
    }, error => {
      
    });
} 

back(){
  this.router.navigate(['dashboard']);
}

public getJSON(): Observable<any> {
    return this.http.get("./assets/json/createUser.json")
}

  ngOnInit() {
  }


}
