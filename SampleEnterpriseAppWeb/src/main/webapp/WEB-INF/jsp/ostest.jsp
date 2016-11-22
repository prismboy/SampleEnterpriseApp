<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ObjectStrage Test</title>
</head>
<body>
<br><% if (bean!=null && !"".equals(bean)) { %>
<font color="red"><b><%= bean %></b></font><br><br>
<% } %>
<form action="/osTest" method="post">
<table border="0">
<tr><th nowrap>Container Name</th><td><input type="text" name="container" size="50">(Optional)</td></tr>
<tr><th nowrap>File Name</th><td><input type="text" name="path" size="100">(Required)</td></tr>
<tr><th nowrap>Data</th><td><textarea rows="5" cols="80" name="data"></textarea>(Required)</td></tr>
<tr><td colspan="2"><input type="submit"></td></tr>
</table>
</form>
<a href="/">Go to index page.</a>
</body>
</html>