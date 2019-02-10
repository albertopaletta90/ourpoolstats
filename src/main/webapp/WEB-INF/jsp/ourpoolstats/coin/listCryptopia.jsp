<%@page import="ourpoolstats.manager.ManagerCoin"%>
<html>
	<body>
		<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Label</th>
							<th scope="col">Currency</th>
							<th scope="col">Symbol</th>
						</tr>
					</thead>
					<tbody>
	
						<% for(int i = 0; i <=1000; i++){%>
						<tr>
							<th scope="row"><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getLabel()%></th>
							<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getCurrency()%></td>
							<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getSymbol()%></td>
						</tr>
						<%}%>
					</tbody>
				</table>
	</body>
</html>