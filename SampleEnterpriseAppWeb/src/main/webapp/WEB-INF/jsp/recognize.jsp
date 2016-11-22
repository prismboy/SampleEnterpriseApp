<%-- @page import="com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.blmx.sample.bean.ClassifyResults" scope="request"></jsp:useBean>
<%
	String classify = "";
	String detectFace = "";
	if (bean != null && bean.getApiKind() != null) {
		if("".equals(bean.getApiKind()) || "classify".equals(bean.getApiKind())) {
			classify = "selected";
		} else {
			detectFace = "selected";
		}
	} else {
		classify = "selected";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Image URL</title>
</head>
<body>
<form action="recognize" method="post">
<table border="0">
<tr><th>APIの種類</th><td>
<select name="apiKind">
	<option value="classify" <%= classify %>>画像を分類します</option>
	<option value="detectFaces" <%= detectFace %>>顔を識別します</option>
</select>
</td></tr>
<tr><th>画像のURL</th><td>
<input type="text" name="url" size="100">
</td></tr>
<tr><td colspan="2"><input type="submit"></td></tr>
</table>
</form>
<br>
<a href=".">Go to index page.</a>
</body>
</html>