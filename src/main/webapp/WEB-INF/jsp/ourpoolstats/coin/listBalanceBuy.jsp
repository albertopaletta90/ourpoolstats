<%@page import="java.math.BigDecimal"%>
<%@page import="ourpoolstats.manager.ManagerCoin"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultilingualMarket"%>
<%@page import="ourpoolstats.api.coinmarket.CoinMarketClient"%>
<%@page import="ourpoolstats.manager.ManagerDashboard"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<html>
	<body>
	<form action="./buy" method="post">
	<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getSymbol()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getNameCoin()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceUsd()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceBtc()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getMarketcap()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPerc1H()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%></th>
						</tr>
					</thead>
					<tbody>
	
						<%
								for(int i = 0; i < ManagerCoin.getInstance().getListCoin().size(); i++){
							%>
						<tr>
							<td><input type="checkbox" name="coin" value="<%=i%>">
							<th scope="row"><img
								src="<%=CoinMarketClient.getIcon(ManagerCoin.getInstance().getListCoin().get(i).getName())%>"
								width="30"></img></th>
							</input>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getName()%></td>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getPriceUsd()%></td>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getPriceBtc()%></td>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getMarketCap()%></td>
							<%
								if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_1().compareTo(new BigDecimal("0"))>=0){
							%>
							<td class="green"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_1()%></td>
							<%
								}
							%>
							<%
								if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_1().compareTo(new BigDecimal("0"))<0){
							%>
							<td class="red"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_1()%></td>
							<%
								}
							%>
							<%
								if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_24().compareTo(new BigDecimal("0"))>=0){
							%>
							<td class="green"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_24()%></td>
							<%
								}
							%>
							<%
								if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_24().compareTo(new BigDecimal("0"))<0){
							%>
							<td class="red"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_24()%></td>
							<%
								}
							%>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					if(!ManagerCoin.getInstance().getListCoin().isEmpty()) {
				%>
					<input type="submit" class="buttonHome btn btn-outline-secondary buttonBuy" value="<%=ManagerMultilingualMarket.getInstance().getBuy()%>">
					<input type="text" class="imputBoxBuy" name="quantity">
				<%}%>
		</form>
	
	</body>
</html>