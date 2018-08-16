<%@page import="java.util.List"%>
<%@page import="util.PersonXmlParser"%>
<%@page import="vo.PersonVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<PersonVo> list = PersonXmlParser.getPersonList();
	pageContext.setAttribute("list", list);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

 td,th {
	padding: 10px;
	text-align: center;
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>

		<tr>
			<th>이름</th>
			<th>닉네임</th>
			<th>나이</th>
			<th>번호</th>
			<th>집번호</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.name }</td>
				<td>${list.nickname }</td>
				<td>${list.age }</td>
				<td>${list.tel }</td>
				<td>${list.hometel }</td>
			</tr>

		</c:forEach>


	</table>

</body>
</html>