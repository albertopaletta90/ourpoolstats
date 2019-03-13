import { AfterViewInit } from '@angular/core';

declare const TradingView: any;

export class ChartComponent implements AfterViewInit {
ngAfterViewInit() {
    new TradingView.widget(
        {
        "width": "100%",
        "height": 500,
        "symbol": "BTC",
        "interval": "D",
        "timezone": "Etc/UTC",
        "theme": "Light",
        "style": "1",
        "locale": "it",
        "toolbar_bg": "#f1f3f6",
        "enable_publishing": false,
        "hide_top_toolbar": true,
        "allow_symbol_change": true,
        "container_id": "tradingview_9f4a3"
      }
    );
  }
}