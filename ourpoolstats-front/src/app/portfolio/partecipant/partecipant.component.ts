import { Component, OnInit } from '@angular/core';
import { Portfolio, PortfolioResponse, CurrentyCoinResponse} from '../../model/model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { ActivatedRoute,  } from '@angular/router';

@Component({
  selector: 'app-partecipant',
  templateUrl: './partecipant.component.html',
  styleUrls: ['./partecipant.component.css']
})
export class PartecipantComponent implements OnInit {

  constructor(private http: HttpClient,private router: Router,private route: ActivatedRoute) {}
  username : string = sessionStorage.getItem('username');
  masterList : Portfolio[];

 
  ngOnInit() {
      this.http.post<PortfolioResponse>(`http://localhost:8080/newourpoolstats/getCoinToPortfolio/${this.username}`,{}).
      subscribe(data => {
        this.masterList = data.partecipant;
        this.setCurrentCoin();
      });
  }

  setCurrentCoin() {
    this.masterList.forEach(element =>{
      this.http.post<CurrentyCoinResponse>(`http://localhost:8080/newourpoolstats/getCurrentCurrency/${element.nameCoin}`,{}).
      subscribe(data => {
       element.priceCurrent = data.value;
        });
      });
    }

}
