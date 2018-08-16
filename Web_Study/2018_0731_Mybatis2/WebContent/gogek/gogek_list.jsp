<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

td, th {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>고객출력</h1>
<table>
    <tr>
        <th>고객번호</th>
        <th>고객이름</th>
        <th>고객주소</th>
        <th>고객주민번호</th>
        <th>고객담당사원번호</th>
    </tr>
    <c:forEach var="glist" items="${list}">
        <tr>
            <td>${glist.gobun}</td>
            <td>${glist.goname }</td>
            <td>${glist.goaddr }</td>
            <td>${glist.gojumin }</td>
            <td>${glist.godam }</td>
        </tr>
    </c:forEach>
</table>




</body>
</html>