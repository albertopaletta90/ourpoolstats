
<%@page import="ourpoolstats.manager.Lenguage.ManagerMultiLilingualDashboard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div>
  <button type="button" class="btn btn-outline-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   <img src="https://findicons.com/files/icons/88/mac/128/setting.png" width="20" />
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#"><%=ManagerMultiLilingualDashboard.getInstance().getSendEmail()%></a>
    <a class="dropdown-item" href="./goToChat"><%=ManagerMultiLilingualDashboard.getInstance().getChat()%></a>
  </div>
</div>
</html>