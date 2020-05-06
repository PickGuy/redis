<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
</head>
<body>
	<center>
	<h1>新增页面</h1>
	</center>
	<hr>
	<center>
	<form action="addStu" method="post">
		<input type="text" name="name" ><br>
		<input type="date" name="birthday" ><br>
		<input type="text" name="description" ><br>
		<input type="number" name="avgScore" ><br>
		<input type="submit" value="新增">
	</form>
	</center>
</body>
</html>