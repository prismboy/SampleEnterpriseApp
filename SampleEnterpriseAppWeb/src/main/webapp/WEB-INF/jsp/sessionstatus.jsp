<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.sample.bean.SessionStatusBean" scope="session"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session status</title>
</head>
<body>
<br>
<table border="1" cellpadding="0" cellspacing="0">
<tr><th>Instance Id</th><td><%= bean.getInstanceIndex() %></td></tr>
<tr><th>New created</th><td><%= bean.isCreated() ? "true" : "false" %></td></tr>
<tr><th>SessionId</th><td><%= session.getId() %></td></tr>
<tr><th>Created time</th><td><%= bean.getCreateTime() %></td></tr>
<tr><th>Access count</th><td><%= bean.getAccessCount() %></td></tr>
</table>
<br>
<a href="sessionStatus">再読み込み</a>&nbsp;&nbsp;&nbsp;
<a href="index.jsp">メニューに戻る</a>
</body>
</html>