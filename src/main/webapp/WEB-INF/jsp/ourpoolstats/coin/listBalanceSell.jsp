<%@page import="java.math.BigDecimal"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@page import="ourpoolstats.manager.ManagerDashboard"%>
<%@page import="ourpoolstats.api.coinmarket.CoinMarketClient"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultilingualMarket"%>
<%@page import="ourpoolstats.manager.ManagerCoin"%>
<html>
	<body>
		<form action="./sell" method="post">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col"><%=ManagerMultiLilingualDashboard.getInstance().getSymbol()%></th>
					<th scope="col"><%=ManagerMultilingualMarket.getInstance().getNomeCoin()%></th>
					<th scope="col"><%=ManagerMultilingualMarket.getInstance().getQuantity()%></th>
					<th scope="col"><%=ManagerMultilingualMarket.getInstance().getChangeBtc()%></th>
					<th scope="col"><%=ManagerMultilingualMarket.getInstance().getCurrencyTotal()%></th>
						<th scope="col"><%=ManagerMultilingualMarket.getInstance().getCurrencyCurrent()%></th>
				</tr>
			</thead>
			<tbody>
			<%
				for(int i = 0; i < ManagerCoin.getInstance().getListUserBalance().size(); i++){
			%>
				<tr>
					<%
						BigDecimal current = ManagerCoin.getInstance().getMarketService().getCurrentCurrencyCoin(ManagerCoin.getInstance().getListUserBalance().get(i).getNameCoin());
								   BigDecimal initial = ManagerCoin.getInstance().getListUserBalance().get(i).getInitialCurrency();
					%>
					<td><input type="checkbox" name="coin" value="<%=i%>">
					<td><img src="<%=CoinMarketClient.getIcon(ManagerCoin.getInstance().getListUserBalance().get(i).getNameCoin())%>" width="30"></img></td>
					<td><%=ManagerCoin.getInstance().getListUserBalance().get(i).getNameCoin()%></td>
					<td><%=ManagerCoin.getInstance().getListUserBalance().get(i).getQuantity()%></td>
					<td><%=ManagerCoin.getInstance().getListUserBalance().get(i).getInitialCurrency()%></td>
					<td><%=ManagerCoin.getInstance().getListUserBalance().get(i).getTotalCurrency()%></td>
					<%
						if(current.compareTo(initial)>=0){
					%>
						<td class="green"><%=current%></td>
 					<%
 						}else
 					%>
 					<%
 						if(current.compareTo(initial)<0){
 					%>
						<td class="red"><%=current%></td>
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
			if(!ManagerCoin.getInstance().getListUserBalance().isEmpty()) {
		%>
			<input type="submit" class="buttonHome btn btn-outline-secondary buttonBuy" value="<%=ManagerMultilingualMarket.getInstance().getSell()%>">
			<input type="text" class="imputBoxBuy" name="quantity">
		<%}%>
		</form>
	</body>
</html>