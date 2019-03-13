import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko } from '../../../model/model';

@Component({
  selector: 'app-list-coin-geko',
  templateUrl: './list-coin-geko.component.html',
  styleUrls: ['./list-coin-geko.component.css']
})
export class ListCoinGekoComponent implements OnInit {

  constructor(private http: HttpClient) { }
  coingekoList: CoinGeko[];
  ngOnInit() {
    this.getCoin();
  }

  getCoin(){
    this.http.get<CoinGekoResponse>('http://localhost:8080/newourpoolstats/getCoinGekoList').
      subscribe(data => {
        this.coingekoList = data.coingekoList;
      }); 
  }

}
