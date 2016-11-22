<%@page import="com.ibm.jp.blmx.sample.ejb.entity.Employee"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.blmx.sample.bean.EmpDetailBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細情報</title>
</head>
<body>
<font size="+1" color="red"><b><%= bean.getMessage()!=null ? bean.getMessage()+"<br>" : ""  %></b></font><br>
<%
	Employee entity = bean.getEntiry();
	if(entity!=null) {
%>
<font size="+1" color="green">詳細情報</font><br><br>
<table border="1" cellpadding="5" cellspacing="0">
<tr><th bgcolor="aquamarine">従業員番号</th><td><%= entity.getEmpno() %></td></tr>
<tr><th bgcolor="aquamarine">姓</th><td><%= entity.getLastname() %></td></tr>
<tr><th bgcolor="aquamarine">ミドル</th><td><%= entity.getMidinit() %></td></tr>
<tr><th bgcolor="aquamarine">名</th><td><%= entity.getFirstnme() %></td></tr>
<tr><th bgcolor="aquamarine">部署</th><td><%= entity.getWorkdept() %></td></tr>
<tr><th bgcolor="aquamarine">電話</th><td><%= entity.getPhoneno() %></td></tr>
<tr><th bgcolor="aquamarine">入社日</th><td><%= entity.getHiredate() %></td></tr>
<tr><th bgcolor="aquamarine">職種</th><td><%= entity.getJob() %></td></tr>
<tr><th bgcolor="aquamarine">スキルレベル</th><td><%= entity.getEdlevel() %></td></tr>
<tr><th bgcolor="aquamarine">性別</th><td><%= entity.getSex() %></td></tr>
<tr><th bgcolor="aquamarine">生年月日</th><td><%= entity.getBirthdate() %></td></tr>
<tr><th bgcolor="aquamarine">給与</th><td><%= entity.getSalary() %></td></tr>
<tr><th bgcolor="aquamarine">賞与</th><td><%= entity.getBonus() %></td></tr>
<tr><th bgcolor="aquamarine">COMM</th><td><%= entity.getComm() %></td></tr>
<tr><th bgcolor="aquamarine">イメージ</th><td><img alt="<%= entity.getFirstnme() %>" src="empPhoto?empNo=<%= entity.getEmpno() %>"></td></tr>
</table>
<%	} %>
<br><br>
<a href="empList?condition=<%= bean.getCondition() %>">検索画面に戻る</a>
&nbsp;&nbsp;&nbsp;
<a href=".">メニューに戻る</a>
</body>
</html>