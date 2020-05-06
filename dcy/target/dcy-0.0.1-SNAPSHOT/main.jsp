<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>首页</title>
</head>

<body>
	<center>
	<h1>首页</h1>
	</center>
	<hr>
	<center>
	<a href="toAddStu">新增</a>
	<table  border="1px">
	<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>生日</td>
			<td>备注</td>
			<td>平均分</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${stuMap.list }" var="stu">
		<tr>
			<td>${stu.id}</td>
			<td>${stu.name}</td>
			<td>
			<fmt:formatDate value="${stu.birthday }" type="date" dateStyle="default"/> 
			</td>
			<td>${stu.description}</td>
			<td>${stu.avgScore}</td>
			<td><a href="toUpdateStu?id=${stu.id }">修改</a>
			<a href="deleteStu?id=${stu.id }">删除</a></td>
		</tr>
	
	</c:forEach>
	</table>
		<a href="selectAll?currentPage=1">首页</a>
		<a href="selectAll?currentPage=${stuMap.currentPage-1}">上一页</a>
			<!-- <span class="current">1</span><a href="">2</a> -->
						<c:forEach var="i" begin = "1" end="${stuMap.totalPage }">
						<c:if test="${i !=stuMap.currentPage }">
						<a href="selectAll?currentPage=${i }">${i }</a>
						</c:if>
						<c:if test="${i==stuMap.currentPage }">
						<span class="current">${i }</span>
						</c:if>
						</c:forEach>
		<a href="selectAll?currentPage=${stuMap.currentPage+1 }">下一页</a>
		<a href="selectAll?currentPage=${stuMap.totalPage }">尾页</a>
	</center>
</body>