<%@page import="ourpoolstats.multilingual.MultilingualHomeController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<jsp:include page="successErrorLogin.jsp"></jsp:include>	
	<div class="login">
		<form action="./login" method="post">
		<div class="textLogin">
			<h3><%=MultilingualHomeController.getInstance().getLogin()%></h3>
		</div>	
			<p class="imputBox"><%=MultilingualHomeController.getInstance().getUsername()%></p>
			<input type="text" name="username" class="imputBox" >
			<p class="imputBox"><%=MultilingualHomeController.getInstance().getPassword()%></p>
			<input type="password" name ="password" class="imputBox"><br />
			<input type="submit" value="<%=MultilingualHomeController.getInstance().getLogin()%>"  class="btn btn-outline-secondary buttonLogin">
		</form>
	</div>
</body>
</html>