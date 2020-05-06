<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<center>
	<h1>修改页面</h1>
	</center>
	<center>
		<form action="updateStu" method="post" >
		<input type="hidden" name="id" value="${s.id }">
		<input type="text" name="name" value="${s.name }"><br>
		<input type="text" name="birthday"  value="<fmt:formatDate value='${s.birthday}' pattern='yyyy-MM-dd '/>">
		<br>
		<input type="text" name="description"  value="${s.description }"><br>
		<input type="number" name="avgScore"  value="${s.avgScore }"><br>
		<input type="submit" value="修改">
	</form>
	</center>
</body>
</html>