<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ourpoolstats.multilingual.MultilingualHomeController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form action="./"><input type="submit" class="buttonHome btn btn-outline-secondary" value="<%=MultilingualHomeController.getInstance().getHome()%>"></form>
<form action="./goToForum"><input type="submit" class="buttonForum btn btn-outline-secondary" value="<%=MultilingualHomeController.getInstance().getForum()%>"></form>
<form action="./goToMarket"><input type="submit" class="buttonMarket btn btn-outline-secondary" value="<%=MultilingualHomeController.getInstance().getMarket()%>"></form>
<form action="./goToLoginSignin"><input type="submit" class="buttonLoginSignin btn btn-outline-secondary" value="<%=MultilingualHomeController.getInstance().getLs()%>"></form>
</html>