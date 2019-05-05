import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
export interface TypeUser {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-chenge-user-type',
  templateUrl: './chenge-user-type.component.html',
  styleUrls: ['./chenge-user-type.component.css']
})
export class ChengeUserTypeComponent implements OnInit {

  type: TypeUser[] = [
    {value: 'ADMIN', viewValue: 'Admin'},
    {value: 'MANGER', viewValue: 'Manager'},
    {value: 'USER', viewValue: 'User'}
  ];
  

  message: string;
  typeAlert: string;
  error: boolean = false;
  username : string;
  userType : string;
  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params) => this.username = params.name);
  }

  changeUserType(){  
      this.http.post(`http://localhost:8080/newourpoolstats/changeTypeUser/${this.userType}/user/${this.username}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Tipo utente cambiato correttamente';
      this.router.navigate(['listUser',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Utente non presente';
      this.router.navigate(['changeTypeUser',{typeAlert: this.typeAlert,message : this.message}]);  
  });
  } 
  
  back(){
    this.router.navigate(['listUser']);
  }

  setParams($event, types){
    this.userType=types.value;
  }
}
