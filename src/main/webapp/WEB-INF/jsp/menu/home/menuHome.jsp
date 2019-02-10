<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ourpoolstats.manager.Lenguage.MangerMultilingualHome"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form action="./"><input type="submit" class="buttonHome btn btn-outline-secondary" value="<%=MangerMultilingualHome.getInstance().getHome()%>"></form>
<form action="./goToForum"><input type="submit" class="buttonForum btn btn-outline-secondary" value="<%=MangerMultilingualHome.getInstance().getForum()%>"></form>
<form action="./goToMarket"><input type="submit" class="buttonMarket btn btn-outline-secondary" value="<%=MangerMultilingualHome.getInstance().getMarket()%>"></form>
<form action="./goToLoginSignin"><input type="submit" class="buttonLoginSignin btn btn-outline-secondary" value="<%=MangerMultilingualHome.getInstance().getLs()%>"></form>
</html>