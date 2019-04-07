import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-coin',
  templateUrl: './delete-coin.component.html',
  styleUrls: ['./delete-coin.component.css']
})
export class DeleteCoinComponent implements OnInit {


  message: string;
  nameCoin : string;
  typeAlert: string;
  error: boolean;
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {
  }

  deleteCoin(){
    this.http.post(`http://localhost:8080/newourpoolstats/deleteCoin/${this.nameCoin}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Moneta eliminata correttamente';
      this.router.navigate(['dashboard',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Moneta non corretta o non esistente';
      this.router.navigate(['deleteCoin',{typeAlert: this.typeAlert,message : this.message}]);  
  });

  }

  back(){
    this.router.navigate(['dashboard']);
  }
}
