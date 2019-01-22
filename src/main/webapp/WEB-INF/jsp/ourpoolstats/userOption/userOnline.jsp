<%@page import="java.util.List"%>
<%@page import="ourpoolstats.manager.ManagerDashboard"%>
<%@page import="ourpoolstats.multilingual.MultiLilingualDashboardController"%>
<%@page import="ourpoolstats.multilingual.MultilingualHomeController"%>
<%@page import="ourpoolstats.manager.ManagerHome"%>
<%@page import="ourpoolstats.model.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="<c:url value="/resources/css/ourpoolstats.css"/>"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/buttonHome.css"/>"	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/buttonOurpoolstats.css"/>"	rel="stylesheet" type="text/css" />
	<title>OurpoolStats</title>
</head>
<body>
	<div class="divMenu">
		<jsp:include page="../../menu/ourpoolstats/menuOurpoolstats.jsp"></jsp:include>		
	</div>
	
	<div class="divDashboard">
		<div class="lenguage">
			<jsp:include page="../../menu/lenguages/lenguagesDashboard.jsp"></jsp:include>
		</div>	
	<div class="buttonOption">
		<jsp:include page="../../menu/ourpoolstats/menuOption.jsp"></jsp:include>
	</div>
	<div class="userOnline">
		
	<nav class="navbar-light bg-light">
		<p><%=MultiLilingualDashboardController.getInstance().getUserOnline() %></p>
	
	<table class="tableBorder table-active">
		<tr class="tableBorder" >
			<td class="tableBorder" >Image</td>
			<td class="tableBorder" >Username</td>
			<td class="tableBorder"><%=MultiLilingualDashboardController.getInstance().getAction() %></td>
		</tr>
		<%List<User>list = (List<User>) request.getAttribute("userOnline");
		for(int i = 0; i< list.size(); i++){%>
		<tr class="tableBorder table-success">
			<td class="tableBorder">
   				<img src="http://bigbang.lefigaro.fr/wp-content/uploads/sites/18/2016/05/avatar.png" width="30" />
 			</td>
			<td class="tableBorder"><%=list.get(i).getUsername()%></td>
			<td><jsp:include page="../../menu/ourpoolstats/menuAction.jsp"></jsp:include></td> 
		</tr>	
		<%}%>
		</table>
	</nav>
	</div>
	
	
	</div>
	


</body>
</html>