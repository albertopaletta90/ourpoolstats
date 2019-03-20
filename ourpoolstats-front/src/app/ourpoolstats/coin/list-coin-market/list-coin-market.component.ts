import { Component, OnInit } from '@angular/core';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko, CoinMarketInfoResponse } from '../../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
@Component({
  selector: 'app-list-coin-market',
  templateUrl: './list-coin-market.component.html',
  styleUrls: ['./list-coin-market.component.css']
})
export class ListCoinMarketComponent implements OnInit {
  coinMarketList: CoinMarket[];
  coinName : string;
  coinLabels : any;

  constructor(private http: HttpClient,private router: Router) {
    this.getJSON().subscribe(data => {
      this.coinLabels = data;
  });
   }

  ngOnInit() {
    this.getCoin();
  }

  getCoin(){
      this.http.get<CoinMarketResponse>('http://localhost:8080/newourpoolstats/getCoinMarketList').
      subscribe(data => {
        this.coinMarketList = data.coinMarketList;
      });
 }

 public getJSON(): Observable<any> {
  return this.http.get("./assets/json/coin.json")
}

 goToInfo(name){
   this.coinName = name;
   sessionStorage.setItem('coin',name);
   this.router.navigate(['infoCoinMarket']);    
}

}
