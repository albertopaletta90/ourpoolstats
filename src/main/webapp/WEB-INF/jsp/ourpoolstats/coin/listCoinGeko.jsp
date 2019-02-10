<%@page import="ourpoolstats.manager.ManagerDashboard"%>
<%@page import="ourpoolstats.manager.ManagerCoin"%>
<%@page import="ourpoolstats.type.CurrencyType"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<html>
	<body>
		<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getSymbol()%></th>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getNameCoin()%></th>
							<%
								if(ManagerCoin.getInstance().getCurrencyType() == CurrencyType.USD) {
							%>
								<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceUsd()%></th>							
							<%
															} else{
														%>
								<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPriceEuro()%></th>
							<%
								}
							%>
							<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getPerc24H()%></th>
						</tr>
					</thead>
					<tbody>
	
						<%
							for(int i = 0; i < ManagerCoin.getInstance().getListCoin().size(); i++){
						%>
						<tr>
							<th scope="row"><img
								src="<%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getImage()%>"
								width="30"></img></th>
							<td><a href="./coinGekoInfo?idCoin=<%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getName()%>"><%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getName()%></a></td>
							<td><%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getCurrent_price()%></td>
							<%if(ManagerCoin.getInstance().getCoingekoCoin().get(i).getMarket_cap_change_percentage_24h()>=0){%>
							<td class="green"><%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getMarket_cap_change_percentage_24h()%></td>
							<%}%>
							<%if(ManagerCoin.getInstance().getCoingekoCoin().get(i).getMarket_cap_change_percentage_24h()<0){%>
							<td class="red"><%=ManagerCoin.getInstance().getCoingekoCoin().get(i).getMarket_cap_change_percentage_24h()%></td>
							<%}%>
							
						</tr>
						<%}%>
					</tbody>
				</table>
	</body>
</html>