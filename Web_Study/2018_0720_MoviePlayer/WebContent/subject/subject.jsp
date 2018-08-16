<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="subject">
		<ul>
			<li class = "movie"><a href="${pageContext.request.contextPath}/movie/list.do">무비</a></li>
			<li class = "audio"><a href="${pageContext.request.contextPath}/audio/list.do">오디오</a></li>
		</ul>
	</div>
</body>
</html>