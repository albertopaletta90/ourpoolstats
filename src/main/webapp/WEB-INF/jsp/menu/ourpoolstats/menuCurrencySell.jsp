<%@page import="ourpoolstats.manager.ManagerImage"%>
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class = "lenguace">
  <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <img src="<%=ManagerImage.getInstance().getLinkMarketCurrencyDeflaut()%>" width="30" />
  </button>
  <div class="dropdown-menu colorLeguage">
    <a class="dropdown-item colorLeguage" href="./convertToEuro">
    	<img src="<%=ManagerImage.getInstance().getLinkMarketCurrencyEur()%>" width="30" />
    </a> 
    <a class="dropdown-item colorLeguage" href="./convertToUsd">
     	<img src="<%=ManagerImage.getInstance().getLinkMarketCurrencyUsd()%>" width="30" />
    </a>   
  </div>
</div>
</html>



