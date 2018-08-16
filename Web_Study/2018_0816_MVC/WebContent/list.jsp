<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

도서목록
<input type = "button" value = "글쓰기" onclick="location.href = 'insert_form.do'">
	<h1>도서목록</h1>
	<hr>
	<ul>
		<c:forEach var="b" items="${list }">
			<li><a href="view.do?book=${b}">${b}</a></li>
		</c:forEach>
	</ul>
	
	

</body>
</html>