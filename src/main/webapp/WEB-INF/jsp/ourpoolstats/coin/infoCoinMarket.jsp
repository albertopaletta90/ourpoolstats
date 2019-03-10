<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@page import="ourpoolstats.client.coinmarket.Coin"%>
<%
	Coin coin = (Coin) request.getSession().getAttribute("infoCoin");
%>
<html>
	<body>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getNameCoin()%> : <%=coin.getName()%></p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getPriceBtc()%> : <%=coin.getPrice_btc()%></p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getPriceUsd()%> : <%=coin.getPrice_usd()%> $</p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getMarketcap()%> : <%=coin.getMarket_cap_usd()%> $</p>
		<%
			if(coin.getPercent_change_1h() >= 0) {
		%>
			<p class="green"><%=ManagerMultiLilingualDashboard.getInstance().getPerc1H()%> : <%=coin.getPercent_change_1h()%>% </p>
		<%
			}else {
		%>
				<p class="red"><%=ManagerMultiLilingualDashboard.getInstance().getPerc1H()%> : <%=coin.getPercent_change_1h()%>% </p>
		<%
			}
		%>
		<%
			if(coin.getPercent_change_24h() >= 0) {
		%>
			<p class="green"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%> : <%=coin.getPercent_change_24h()%>%</p>
		<%
			}else{
		%>
				<p class="red"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%> : <%=coin.getPercent_change_24h()%>%</p>
		<%
			}
		%>
		<%
			if(coin.getPercent_change_7d() >= 0) {
		%>
			<p class="green"><%=ManagerMultiLilingualDashboard.getInstance().getPerc7D()%> : <%=coin.getPercent_change_7d()%>%</p>
		<%
			}else{
		%>
			<p class="red"><%=ManagerMultiLilingualDashboard.getInstance().getPerc7D()%> : <%=coin.getPercent_change_7d() %>%</p>
		<%}%>
	</body>
</html>