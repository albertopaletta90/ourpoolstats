<%@page import="ourpoolstats.api.coingeko.data.Market"%>
<%@page import="ourpoolstats.api.coinmarket.Coin"%>
<html>
	<%Market coin = (Market) request.getSession().getAttribute("infoCoinGeko"); %>
	<body>
		<div class="tradingview-widget-container">
		  <div id="tradingview_9f4a3"></div>
			  <div class="tradingview-widget-copyright">
			  		<a href="https://it.tradingview.com/symbols/BTC/" rel="noopener" target="_blank">
			  			<span class="blue-text">Grafico <%=coin.getName() %></span></a></div>
				  <script type="text/javascript" src="https://s3.tradingview.com/tv.js"></script>
				  <script type="text/javascript">
					  new TradingView.widget(
					  {
					  "width": "100%",
					  "height": 500,
					  "symbol": "<%=coin.getSymbol()%>",
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
				  </script>
		</div>

	
	</body>

</html>
