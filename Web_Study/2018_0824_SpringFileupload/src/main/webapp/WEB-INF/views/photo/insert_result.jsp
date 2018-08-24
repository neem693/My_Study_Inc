<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	제목: ${vo.title}<br>
	파일명: ${vo.filename }<br>
	<img
		src="${pageContext.request.contextPath}/resources/upload/${vo.filename}"
		width="200" height="200">
	<br>
	<a href="insert_form.do">다시 해보기</a>

</body>
</html>