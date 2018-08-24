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

	제목: ${vo.title}
	<br>

	<c:forEach var="name" items="${ vo.filename}">
	파일명: ${name }<br>
		<img
			src="${pageContext.request.contextPath}/resources/upload/${name}"
			width="200" height="200">
		<br>
	</c:forEach>
	<a href="insert_form2.do">다시 해보기</a>

</body>
</html>