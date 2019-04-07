import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-coin',
  templateUrl: './add-coin.component.html',
  styleUrls: ['./add-coin.component.css']
})
export class AddCoinComponent implements OnInit {

  message: any;
  nameCoin : string;
  typeAlert: string;
  error: boolean;
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {
  }

  addCoin(){
    this.http.post(`http://localhost:8080/newourpoolstats/addCoin/${this.nameCoin}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Moneta inserita correttamente';
      this.router.navigate(['dashboard',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Moneta non corretta o non esistente';
      this.router.navigate(['addCoin',{typeAlert: this.typeAlert,message : this.message}]);  
  });

  }

  back(){
    this.router.navigate(['dashboard']);
  }
  

}
