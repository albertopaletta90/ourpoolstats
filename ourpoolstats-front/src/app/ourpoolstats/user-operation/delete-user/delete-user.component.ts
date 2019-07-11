import { Component, OnInit } from '@angular/core';
import { User } from '../../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {

  message: string;
  typeAlert: string;
  error: boolean;
  username  : string;
  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.params.subscribe((params) => this.username = params.name);
  }

  deleteUser(){
    this.http.delete(`http://localhost:8080/newourpoolstats/deleteUser/${this.username}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Utente cancellato correttamente';
      this.router.navigate(['listUser',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Utente non corretto o non esistente';
      this.router.navigate(['deleteUser',{typeAlert: this.typeAlert,message : this.message}]);  
  });
  
  }

  back(){
    this.router.navigate(['listUser']);
  }
  
}
