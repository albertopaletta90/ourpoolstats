<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div>
  <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   <img src="https://res.cloudinary.com/coinmarketcap/image/upload/cryptocurrency/128x128/dragon-coins.png" width="30" />
  </button>
  <div class="dropdown-menu">
    <!-- <a class="dropdown-item" href="./goToApiCryptopia"><%=ManagerMultiLilingualDashboard.getInstance().getCryptopia()%></a>-->
    <a class="dropdown-item" href="./goToApiCoinMarket"><%=ManagerMultiLilingualDashboard.getInstance().getCoinMarket()%></a>
    <a class="dropdown-item" href="./goToApiCoinGekoEuro"><%=ManagerMultiLilingualDashboard.getInstance().getCoinGeko()%></a>
  </div>
</div>
</html>