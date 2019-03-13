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

  setPasswordLabels: any;
  constructor(private http: HttpClient, private router: Router) { 
    this.getJSON().subscribe(data => {
      this.setPasswordLabels = data;
  });
  
}


  public getJSON(): Observable<any> {
    return this.http.get("./assets/json/changePassword.json")
}
  ngOnInit() {
  }

}
