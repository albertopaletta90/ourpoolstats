<%@page import="ourpoolstats.manager.Lenguage.ManagerMultilingualMarket"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@page import="ourpoolstats.manager.ManagerImage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   		<img src="https://findicons.com/files/icons/88/mac/128/setting.png" width="30" />
  	</button>	 
  	<div class="dropdown-menu colorLeguage">
    	<a class="dropdown-item colorLeguage" href="./goToSell"><%=ManagerMultilingualMarket.getInstance().getSell()%></a>
    	<a class="dropdown-item colorLeguage" href="./goToBuy"><%=ManagerMultilingualMarket.getInstance().getBuy()%></a>
   	</div>
</html>