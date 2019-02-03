<%@page import="ourpoolstats.multilingual.MultiLilingualDashboardController"%>
<%@page import="oupoolstats.api.coinmarket.Coin"%>
<%Coin coin = (Coin) request.getSession().getAttribute("infoCoin");%>
<html>
	<body>
		<p><%=MultiLilingualDashboardController.getInstance().getNameCoin()%> : <%= coin.getName() %></p>
		<p><%=MultiLilingualDashboardController.getInstance().getPriceBtc() %> : <%= coin.getPrice_btc() %></p>
		<p><%=MultiLilingualDashboardController.getInstance().getPriceUsd() %> : <%= coin.getPrice_usd() %> $</p>
		<p><%=MultiLilingualDashboardController.getInstance().getMarketcap() %> : <%= coin.getMarket_cap_usd() %> $</p>
		<%if(coin.getPercent_change_1h() >= 0) {%>
			<p class="green"><%=MultiLilingualDashboardController.getInstance().getPerc1H() %> : <%= coin.getPercent_change_1h() %>% </p>
		<%}else {%>
				<p class="red"><%=MultiLilingualDashboardController.getInstance().getPerc1H() %> : <%= coin.getPercent_change_1h() %>% </p>
		<%}%>
		<%if(coin.getPercent_change_24h() >= 0) {%>
			<p class="green"><%=MultiLilingualDashboardController.getInstance().getPerc24H() %> : <%= coin.getPercent_change_24h() %>%</p>
		<%}else{%>
				<p class="red"><%=MultiLilingualDashboardController.getInstance().getPerc24H() %> : <%= coin.getPercent_change_24h() %>%</p>
		<%}%>
		<%if(coin.getPercent_change_7d() >= 0) {%>
			<p class="green"><%=MultiLilingualDashboardController.getInstance().getPerc7D() %> : <%=coin.getPercent_change_7d() %>%</p>
		<%}else{%>
			<p class="red"><%=MultiLilingualDashboardController.getInstance().getPerc7D() %> : <%=coin.getPercent_change_7d() %>%</p>
		<%}%>
	</body>
</html>