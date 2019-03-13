import { Component, OnInit } from '@angular/core';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko, CoinMarketInfoResponse } from '../../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-list-coin-market',
  templateUrl: './list-coin-market.component.html',
  styleUrls: ['./list-coin-market.component.css']
})
export class ListCoinMarketComponent implements OnInit {
  coinMarketList: CoinMarket[];
  coinName : string;
  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit() {
    this.getCoin();
  }

  getCoin(){
      this.http.get<CoinMarketResponse>('http://localhost:8080/newourpoolstats/getCoinMarketList').
      subscribe(data => {
        this.coinMarketList = data.coinMarketList;
      });
 }

 goToInfo(name){
   this.coinName = name;
    this.router.navigate(['infoCoinMarket']);    
}

}
