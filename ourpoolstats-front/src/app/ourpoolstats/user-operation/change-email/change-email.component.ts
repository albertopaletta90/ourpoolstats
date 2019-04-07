import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-change-email',
  templateUrl: './change-email.component.html',
  styleUrls: ['./change-email.component.css']
})
export class ChangeEmailComponent implements OnInit {

  message: string;
  error: boolean;
  typeAlert: string;
  email : string;
  username : string = sessionStorage.getItem('username');
  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
  }

  changeEmail(){debugger
    this.http.post(`http://localhost:8080/newourpoolstats/changeEmail/${this.username}/email/${this.email}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Email profilo cambiata correttamente';
      this.router.navigate(['account',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Email profilo non cambiata';
      this.router.navigate(['account',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);  
  });
  }

  back(){

  }
}
