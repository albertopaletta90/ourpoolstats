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

  oldPassword : string;
  password : string ;
  repeatPassword : string;
  alert : boolean = false;

  setPasswordLabels: any;
  constructor(private http: HttpClient, private router: Router) { 
    this.getJSON().subscribe(data => {
      this.setPasswordLabels = data;
  });
  
}

changePassword(){

  if(this.password == this.repeatPassword){
    
    this.http.post(`http://localhost:8080/newourpoolstats/changePassword/${sessionStorage.getItem("username")}/password${this.oldPassword}/newPassword${this.password}`,{}).
        subscribe(data => {
          this.alert = true;
          this.router.navigate(['dashboard']);
      }, error => {
        
      });

  }

} 


  public getJSON(): Observable<any> {
    return this.http.get("./assets/json/changePassword.json")
}
  ngOnInit() {
  }

}
