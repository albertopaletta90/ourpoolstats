import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { getLink } from 'src/app/app.module';

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
  constructor(private http: HttpClient, private router: Router,private spinner: NgxSpinnerService) {}

  ngOnInit() {
  }

  addCoin(){
    this.spinner.show();
    this.http.post(getLink()+`/addCoin/${this.nameCoin}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Moneta inserita correttamente';
      this.spinner.hide();
      this.router.navigate(['dashboard',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Moneta non corretta o non esistente';
      this.spinner.hide();
      this.router.navigate(['addCoin',{typeAlert: this.typeAlert,message : this.message}]);  
  });

  }

  back(){
    this.router.navigate(['dashboard']);
  }
  

}
