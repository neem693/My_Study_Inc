<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String url = request.getRequestURL().toString();
	System.out.println(url);
	System.out.println(request.getRequestURI());
	Cookie cookie = new Cookie("C", url);
	response.addCookie(cookie);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/recent_page.css">
<title>Insert title here</title>
</head>
<body>
	<div id="recent_page">
		<jsp:include page="cookie_list.jsp" />
	</div>
	C Page 입니다.
	<br>
	<a href="A.jsp">A</a>


</body>
</html>