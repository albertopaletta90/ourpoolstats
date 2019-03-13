import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CoinGekoResponse, CoinMarketResponse, CoinMarket, CoinGeko } from '../../../model/model';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-list-coin-geko',
  templateUrl: './list-coin-geko.component.html',
  styleUrls: ['./list-coin-geko.component.css']
})
export class ListCoinGekoComponent implements OnInit {
  coinLabels : any;
  coingekoList: CoinGeko[];

  constructor(private http: HttpClient) {
    this.getJSON().subscribe(data => {
        this.coinLabels = data;
    });
}

  ngOnInit() {
    this.getCoin();
  }

  getCoin(){
    this.http.get<CoinGekoResponse>('http://localhost:8080/newourpoolstats/getCoinGekoList').
      subscribe(data => {
        this.coingekoList = data.coingekoList;
      }); 
  }

  public getJSON(): Observable<any> {
    return this.http.get("./assets/json/coin.json")
}

}


