import { Component, OnInit } from '@angular/core';
import { CoinMarket } from '../../model/model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu-coin',
  templateUrl: './menu-coin.component.html',
  styleUrls: ['./menu-coin.component.css']
})
export class MenuCoinComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

    change = function(value){
      this.router.navigate([value]);
    }
}
