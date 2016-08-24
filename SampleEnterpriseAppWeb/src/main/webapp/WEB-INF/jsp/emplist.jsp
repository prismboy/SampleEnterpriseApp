<%@page import="com.ibm.jp.sample.ejb.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean"
	type="com.ibm.jp.sample.bean.EmpListBean"
	scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員検索</title>
</head>
<body>
<font color="red"><b><%= bean.getMessage() != null ? bean.getMessage() : "" %></b></font>
<br>
<font size="+1">従業員検索</font><br><br>
<form action="empList" method="post">
	従業員番号：<input type="text" name="condition" value="<%= bean.getCondition()!=null ? bean.getCondition() : "" %>" size="10"> (ワイルドカード'*'が使えます。)
	<br><br>
	<input type="submit">
</form>
<br>
	<%
		if (bean.getList()!=null && bean.getList().size() > 0) {
	%>
	<font size="+1">検索結果</font>
	<table border="1" cellpadding="2" cellspacing="0">
		<tr bgcolor="lightskyblue">
			<th>従業員番号</th>
			<th>姓</th>
			<th>名</th>
			<th>部署</th>
			<th>*</th>
		</tr>
		<%
			for (Employee employee : bean.getList()) {
		%>
		<tr>
			<td><a href="empDetail?empNo=<%=employee.getEmpno()%>&condition=<%= bean.getCondition() %>"><%=employee.getEmpno()%></a></td>
			<td><%= employee.getLastname() %></td>
			<td><%= employee.getFirstnme() %></td>
			<td><%= employee.getWorkdept() %></td>
			<td><%= bean.getContainsPhoto().get(employee.getEmpno()) ? "*" : "" %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
<br><br>
<a href=".">メニューに戻る</a>
</body>
</html>