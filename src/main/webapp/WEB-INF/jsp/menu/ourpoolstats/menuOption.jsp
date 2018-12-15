<%@page import="ourpoolstats.multilingual.MultiLilingualDashboardController"%>
<%@page import="ourpoolstats.manager.ManagerImage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   		<img src="https://findicons.com/files/icons/88/mac/128/setting.png" width="30" />
  	</button>	 
  	<div class="dropdown-menu colorLeguage">
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>
    		<a class="dropdown-item colorLeguage" href="./goToCreateUser"><%=MultiLilingualDashboardController.getInstance().getInsertUser()%></a><%}%>
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>	
    		<a class="dropdown-item colorLeguage" href="./goToDeleteUser"><%=MultiLilingualDashboardController.getInstance().getDeleteUser()%></a><%}%>
    	
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>
    		<a class="dropdown-item colorLeguage" href="#"><%=MultiLilingualDashboardController.getInstance().getAddCoin()%></a><%}%>
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>
    		<a class="dropdown-item colorLeguage" href="#"><%=MultiLilingualDashboardController.getInstance().getDeleteCoin()%></a><%}%>
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>
    		<a class="dropdown-item colorLeguage" href="#"><%=MultiLilingualDashboardController.getInstance().getViewLogSigleUser()%></a><%}%>
    	<%if(request.getSession().getAttribute("userType").equals("ADMIN")){%>
    		<a class="dropdown-item colorLeguage" href="./logUser"><%=MultiLilingualDashboardController.getInstance().getViewLogUsers()%></a><%}%>
    	<a class="dropdown-item colorLeguage" href="./userOnline"><%=MultiLilingualDashboardController.getInstance().getViewUserOnline()%></a>
   	</div>
</html>