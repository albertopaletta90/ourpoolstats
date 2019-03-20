import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CoinMarket, CoinMarketInfoResponse,CoinInfo } from '../../../model/model';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-coin-market-info',
  templateUrl: './coin-market-info.component.html',
  styleUrls: ['./coin-market-info.component.css']
})
export class CoinMarketInfoComponent implements OnInit {
  coin : CoinMarket;
  nameCoin : string = sessionStorage.getItem('coin');
  
  constructor(private route: ActivatedRoute,private http: HttpClient) { }

  ngOnInit() {
    this.http.post<CoinMarketInfoResponse>(`http://localhost:8080/newourpoolstats/coinMarketInfo/${this.nameCoin}`,{}).
      subscribe(data => {
        this.coin = data.coinInfo;
    });
  }
  
}

