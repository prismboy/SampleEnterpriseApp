<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" type="com.ibm.jp.sample.bean.SysTimeBean" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>システム日時</title>
</head>
<body>
<font size="+1" color="red">実行結果</font><br><br>
<table border="1" cellpadding="5" cellspacing="0">
<tr><th>現在日時</th><td><%= bean.getCurrentDateTime() %></td></tr>
<tr><th>現在日時(ミリ秒)</th><td><%= bean.getCurrentTimeMillis() %></td></tr>
</table>
<br><br>
<a href=".">メニューに戻る</a>
</body>
</html>