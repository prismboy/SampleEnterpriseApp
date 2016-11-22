<%@page import="com.ibm.watson.developer_cloud.visual_recognition.v3.model.Face.Identity"%>
<%@page import="com.ibm.watson.developer_cloud.visual_recognition.v3.model.Face"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" scope="request" type="com.ibm.jp.blmx.sample.bean.FaceResults"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recognize results</title>
</head>
<body>
<h2>画像解析結果</h2>
<% if(bean != null && bean.getFaces().size()>0){
%>
<b>解析元画像</b><br>
<img src="<%= bean.getSourceUrl() %>" height="30%" width="30%" border="1"/>
<br>
<table border="1" cellpadding="1" cellspacing="0">
<tr><th>年齢(min-max)</th><th>性別</th><th>名前</th></tr>
<%
	for(Face face : bean.getFaces()) {
		Integer iAgeMin = face.getAge().getMin();
		String ageMin = iAgeMin!=null ? iAgeMin.toString() : "n/a";
		Integer iAgeMax = face.getAge().getMax();
		String ageMax = iAgeMax!=null ? iAgeMax.toString() : "n/a";
		Double ageScore = face.getAge().getScore();
		String gender = face.getGender().getGender();
		Double genderScore = face.getGender().getScore();
		Identity identity = face.getIdentity();
%>
<tr><td><%= ageMin %> - <%= ageMax %> (<%= ageScore %>)</td><td><%= gender %> (<%= genderScore %>)</td><td>
<%		if(identity!=null) { %>
<%= face.getIdentity().getName() %> (<%= face.getIdentity().getScore() %>)
<%		} else { %>
&nbsp;
<%		} %>
</td></tr>
<%
	}
%>
</table>
<% } %>
<br>
<a href="recognize?apiKind=<%= bean.getApiKind() %>">解析に戻る</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=".">Go to index page.</a>
</body>
</html>