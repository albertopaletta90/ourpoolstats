import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {

  view : boolean = false;
  constructor(private route : ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe((params) => this.view = params.activeAlert);
  }

}
