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
    	<a class="dropdown-item colorLeguage" href="./goToAddImage"><%=ManagerMultiLilingualDashboard.getInstance().getChangeImage()%></a>
    	<a class="dropdown-item colorLeguage" href="./goToChangePassword"><%=ManagerMultiLilingualDashboard.getInstance().getChangePassword()%></a>
    	<a class="dropdown-item colorLeguage" href="./goToChangeEmail"><%=ManagerMultiLilingualDashboard.getInstance().getChangeEmail()%></a>
    	<a class="dropdown-item colorLeguage" href="./goToDeleteUserAction"><%=ManagerMultiLilingualDashboard.getInstance().getDeleteUser()%></a>
    	<a class="dropdown-item colorLeguage" href=./logout><%=ManagerMultiLilingualDashboard.getInstance().getLogout()%></a>
    	
   	</div>
</html>