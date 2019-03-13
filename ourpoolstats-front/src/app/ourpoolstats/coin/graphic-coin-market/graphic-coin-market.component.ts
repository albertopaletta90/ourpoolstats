import { Component, OnInit, AfterViewInit } from '@angular/core';

declare const TradingView: any;

@Component({
  selector: 'app-graphic-coin-market',
  templateUrl: './graphic-coin-market.component.html',
  styleUrls: ['./graphic-coin-market.component.css']
})
export class GraphicCoinMarketComponent implements OnInit , AfterViewInit {

  ngAfterViewInit() {
    const tradingView = new TradingView.widget(
      {
      "width": "100%",
      "height": 500,
      "symbol": "Bitcoin",
      "interval": "D",
      "timezone": "Etc/UTC",
      "theme": "Light",
      "style": "1",
      "locale": "it",
      "toolbar_bg": "#f1f3f6",
      "enable_publishing": false,
      "hide_top_toolbar": true,
      "allow_symbol_change": true,
      "container_id": "technical-analysis"
    }
  );
  }

  constructor() { }

  ngOnInit() {
  }

}
