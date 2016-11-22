<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.blmx.sample.bean.EnvValsBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ランタイムの環境変数</title>
</head>
<body>
<font size="+1" color="red">環境変数</font><br><br>
<table border="1" cellpadding="5" cellspacing="0">
<%
	Map<String, String> map = bean.getEnvMap();
	Iterator<Entry<String, String>> ite = map.entrySet().iterator();
	while(ite.hasNext()) {
		Entry<String, String> entry = ite.next();
%>
<tr><th><%= entry.getKey() %></th><td><%= entry.getValue() %></td></tr>
<%	} %>
</table>
<br><br>
<a href="env">再読み込み</a>&nbsp;&nbsp;&nbsp;
<a href=".">メニューに戻る</a>
</body>
</html>