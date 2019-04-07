import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-market',
  templateUrl: './menu-market.component.html',
  styleUrls: ['./menu-market.component.css']
})
export class MenuMarketComponent implements OnInit {

  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit() {}

  goToSell(){
    this.router.navigate(['market']);
  }
  goToBuy(){
    this.router.navigate(['buy']);
  }
}
