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

  constructor(private route: ActivatedRoute) {}
  ngOnInit() {}


}
