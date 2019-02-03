<%@page import="oupoolstats.api.coingeko.data.Market"%>
<%@page import="ourpoolstats.multilingual.MultiLilingualDashboardController"%>
<%@page import="oupoolstats.api.coinmarket.Coin"%>
<%Market coin = (Market) request.getSession().getAttribute("infoCoinGeko");%>
<html>
	<body>
		<p><%=MultiLilingualDashboardController.getInstance().getNameCoin()%> : <%= coin.getName() %></p>
		<p><%=MultiLilingualDashboardController.getInstance().getCurrentPrice() %> : <%= coin.getCurrent_price()%></p>
		<p><%=MultiLilingualDashboardController.getInstance().getMarketcap() %> : <%= coin.getMarket_cap()%> $</p>
		<p><%=MultiLilingualDashboardController.getInstance().getMarketcap24() %> : <%= coin.getMarket_cap_change_24h()%> $</p>
		<%if(coin.getPrice_change_24h() >= 0) {%>
			<p class="green"><%=MultiLilingualDashboardController.getInstance().getPrice24H() %> : <%= coin.getPrice_change_24h() %> </p>
		<%}else {%>
				<p class="red"><%=MultiLilingualDashboardController.getInstance().getPrice24H() %> : <%= coin.getPrice_change_24h() %></p>
		<%}%>
		<%if(coin.getPrice_change_percentage_24h() >= 0) {%>
			<p class="green"><%=MultiLilingualDashboardController.getInstance().getPerc24H() %> : <%= coin.getPrice_change_percentage_24h() %>%</p>
		<%}else{%>
				<p class="red"><%=MultiLilingualDashboardController.getInstance().getPerc24H() %> : <%= coin.getPrice_change_percentage_24h() %>%</p>
		<%}%>
	</body>
</html>