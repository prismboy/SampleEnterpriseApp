<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request" type="com.ibm.jp.blmx.sample.bean.ClassifyResults"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recognize results</title>
</head>
<body>
<h2>画像解析結果</h2>
<%
if(bean != null && bean.getClassMap().size()>0){
%>
<b>解析元画像</b><br>
<img src="<%= bean.getSourceUrl() %>" height="30%" width="30%" border="1"/>
<br>
<table border="1" cellpadding="1" cellspacing="0">
<tr><th>分類</th><th>スコア</th><th>分類器ID</th></tr>
<%
	Iterator<String> ite = bean.getClassMap().keySet().iterator();
	while(ite.hasNext()){
		String classifierName = ite.next();
		if("url".equals(classifierName)) {
			continue;
		}
		Map<String, Double> classMap = (Map<String, Double>)bean.getClassMap().get(classifierName);
		Iterator<String> iteClass = classMap.keySet().iterator();
		while(iteClass.hasNext()){
			String className = iteClass.next();
%>
<tr><td><%= className %></td><td><%= classMap.get(className) %></td><td><%= classifierName %></td></tr>
<%
		}
	}
%>
</table>
<% } %>
<br>
<a href="recognize?apiKind=<%= bean.getApiKind() %>">解析に戻る</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=".">Go to index page.</a>
</body>
</html>