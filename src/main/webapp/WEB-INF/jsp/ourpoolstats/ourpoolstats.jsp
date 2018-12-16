<%@page import="ourpoolstats.myenum.CryptoCurrency"%>
<%@page import="ourpoolstats.manager.ManagerCoin"%>
<%@page import="oupoolstats.api.coinmarket.GetCoin"%>
<%@page import="ourpoolstats.manager.ManagerDashboard"%>
<%@page
	import="ourpoolstats.multilingual.MultiLilingualDashboardController"%>
<%@page import="ourpoolstats.multilingual.MultilingualHomeController"%>
<%@page import="ourpoolstats.manager.ManagerHome"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
	integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
	integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/ourpoolstats.css"/>"
	rel="stylesheet" type="text/css" />
<title>OurpoolStats</title>
</head>
<body>
	<div class="divMenu">
		<jsp:include page="../menu/ourpoolstats/menuOurpoolstats.jsp"></jsp:include>
	</div>

	<div class="divDashboard">
		<div class="lenguage">
			<jsp:include page="../menu/lenguages/lenguagesDashboard.jsp"></jsp:include>
		</div>
		<div class="buttonOption">
			<jsp:include page="../menu/ourpoolstats/menuOption.jsp"></jsp:include>
		</div>

		<div class="buttonCoin">
			<jsp:include page="../menu/ourpoolstats/menuCoin.jsp"></jsp:include>
		</div>

		<div class="viewDashboard">

			<%if(ManagerCoin.getInstance().getCryptoCurrency()==CryptoCurrency.COINMARKET){%>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getSymbol() %></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getNameCoin()%></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getPriceUsd()%></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getPriceBtc()%></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getMarketcap()%></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getPerc1H()%></th>
						<th scope="col"><%=MultiLilingualDashboardController.getInstance().getPerc24H()%></th>
					</tr>
				</thead>
				<tbody>

					<% for(int i = 0; i < ManagerDashboard.getInstance().getListCoin().size(); i++){%>
					<tr>
						<th scope="row"><img
							src="<%=GetCoin.getIcon(ManagerDashboard.getInstance().getListCoin().get(i).getName())%>"
							width="30"></img></th>
						</input>
						<td><%=ManagerDashboard.getInstance().getListCoin().get(i).getName()%></td>
						<td><%=ManagerDashboard.getInstance().getListCoin().get(i).getPrice_usd()%></td>
						<td><%=ManagerDashboard.getInstance().getListCoin().get(i).getPrice_btc()%></td>
						<td><%=ManagerDashboard.getInstance().getListCoin().get(i).getMarket_cap_usd()%></td>
						<%if(ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_1h()>=0){%>
						<td class="green"><%=ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_1h()%></td>
						<%}%>
						<%if(ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_1h()<0){%>
						<td class="red"><%=ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_1h()%></td>
						<%}%>
						<%if(ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_24h()>=0){%>
						<td class="green"><%=ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_24h()%></td>
						<%}%>
						<%if(ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_24h()<0){%>
						<td class="red"><%=ManagerDashboard.getInstance().getListCoin().get(i).getPercent_change_24h()%></td>
						<%}%>
					</tr>
					<%}%>
				</tbody>
			</table>


			<%} if(ManagerCoin.getInstance().getCryptoCurrency()==CryptoCurrency.CRYPTOPIA){%>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Label</th>
						<th scope="col">Currency</th>
						<th scope="col">Symbol</th>
						<th scope="col">Base Currency</th>
						<th scope="col">Base Symbol</th>
						<th scope="col">Status</th>
					<!-- 	<th scope="col">Status Message</th> -->
						<th scope="col">Trade Fee</th>
						<th scope="col">Minimim Trade</th>
						<th scope="col">Maxinum Trade</th>
						<th scope="col">Minimum Base Trade</th>
						<th scope="col">Maximum Base Trade</th>
						<th scope="col">Minimum Price</th>
						<th scope="col">Maximum Price</th>

					</tr>
				</thead>
				<tbody>

					<% for(int i = 0; i <=1000; i++){%>
					<tr>
						<th scope="row"><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getLabel()%></th>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getCurrency()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getSymbol()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getBaseCurrency()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getBaseSymbol()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getStatus()%></td>
		<%-- 				<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getStatusMessage()%></td> --%>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getTradeFee()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMinimumTrade()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMaximumTrade()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMinimumBaseTrade()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMaximumBaseTrade()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMinimumPrice()%></td>
						<td><%=ManagerCoin.getInstance().getCryptopiaCoin().get(i).getMaximumTrade()%></td>

					</tr>
					<%}%>
				</tbody>
			</table>
			<%}%>
		</div>
	</div>







</body>
</html>