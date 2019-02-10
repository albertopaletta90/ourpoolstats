<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ourpoolstats.manager.ManagerLoginSignin"%>
<%@page import="ourpoolstats.manager.Lenguage.MangerMultilingualHome"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
		if(ManagerLoginSignin.getInstance().isErrorLogin()){
	%>
		<div class ="errorLogin">
			<nav class="p-3 mb-2 bg-danger text-white">
				<p><%=MangerMultilingualHome.getInstance().getErrorLogin()%></p>
			</nav>
		</div>
		<%}%>

</html>