<%@page import="ourpoolstats.api.coingeko.data.Market"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@page import="ourpoolstats.api.coinmarket.Coin"%>
<%
	Market coin = (Market) request.getSession().getAttribute("infoCoinGeko");
%>
<html>
	<body>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getNameCoin()%> : <%=coin.getName()%></p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getCurrentPrice()%> : <%=coin.getCurrent_price()%></p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getMarketcap()%> : <%=coin.getMarket_cap()%> $</p>
		<p><%=ManagerMultiLilingualDashboard.getInstance().getMarketcap24()%> : <%=coin.getMarket_cap_change_24h()%> $</p>
		<%
			if(coin.getPrice_change_24h() >= 0) {
		%>
			<p class="green"><%=ManagerMultiLilingualDashboard.getInstance().getPrice24H()%> : <%=coin.getPrice_change_24h()%> </p>
		<%
			}else {
		%>
				<p class="red"><%=ManagerMultiLilingualDashboard.getInstance().getPrice24H()%> : <%=coin.getPrice_change_24h()%></p>
		<%
			}
		%>
		<%
			if(coin.getPrice_change_percentage_24h() >= 0) {
		%>
			<p class="green"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%> : <%=coin.getPrice_change_percentage_24h()%>%</p>
		<%
			}else{
		%>
				<p class="red"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%> : <%= coin.getPrice_change_percentage_24h() %>%</p>
		<%}%>
	</body>
</html>