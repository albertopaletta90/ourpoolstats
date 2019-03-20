import { Component, OnInit,Input } from '@angular/core';
import { LoginResponse, CoinGeko } from '../model/model';
import { LoginComponent } from '../login/login.component';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-ourpoolstats',
  templateUrl: './ourpoolstats.component.html',
  styleUrls: ['./ourpoolstats.component.css'],

})
export class OurpoolstatsComponent implements OnInit {
  viewAllert : string = sessionStorage.getItem('setPassword');
  view : boolean = (this.viewAllert=='setPassword')? true : false;

  constructor(private route: ActivatedRoute) {}
  ngOnInit() {}


}
