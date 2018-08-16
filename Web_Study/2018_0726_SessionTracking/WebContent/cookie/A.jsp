<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String url = request.getRequestURL().toString();
	System.out.println(url);
	Cookie cookie = new Cookie("A", url);

	cookie.setMaxAge(3600 * 24);//1일

	response.addCookie(cookie);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/recent_page.css">
</head>

<body>
	<div id="recent_page">
		<jsp:include page="cookie_list.jsp" />
	</div>

	A Page 입니다..
	<br>
	<a href="B.jsp">B</a>
</body>
</html>