<%@page import="java.math.BigDecimal"%>
<%@page import="ourpoolstats.client.coinmarket.CoinMarketClient"%>
<%@page import="ourpoolstats.manager.ManagerCoin"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<html>
	<body>
		<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getSymbol()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getNameCoin()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceUsd()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceBtc()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPerc1H()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%></th>
						</tr>
					</thead>
					<tbody>
	
						<%
							for(int i = 0; i < ManagerCoin.getInstance().getListCoin().size(); i++){
						%>
						<tr>
							<th scope="row"><img
								src="<%=CoinMarketClient.getIcon(ManagerCoin.getInstance().getListCoin().get(i).getName())%>"
								width="30"></img></th>
							</input>
							<td><a href="./coinMarketInfo?idCoin=<%=ManagerCoin.getInstance().getListCoin().get(i).getName()%>"><%=ManagerCoin.getInstance().getListCoin().get(i).getName()%></a> </td>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getPriceUsd()%></td>
							<td><%=ManagerCoin.getInstance().getListCoin().get(i).getPriceBtc()%></td>
							<%if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_1().compareTo(new BigDecimal("0"))>=0){%>
							<td class="green"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_1()%></td>
							<%}%>
							<%if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_1().compareTo(new BigDecimal("0"))<0){%>
							<td class="red"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_1()%></td>
							<%}%>
							<%if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_24().compareTo(new BigDecimal("0"))>=0){%>
							<td class="green"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_24()%></td>
							<%}%>
							<%if(ManagerCoin.getInstance().getListCoin().get(i).getPerc_24().compareTo(new BigDecimal("0"))<0){%>
							<td class="red"><%=ManagerCoin.getInstance().getListCoin().get(i).getPerc_24()%></td>
							<%}%>
						</tr>
						<%}%>
					</tbody>
				</table>
	</body>
</html>