<%@page import="java.net.URLDecoder"%>
<%@page import="javax.activation.URLDataSource"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie"%>
<%
	//쿠키 생성 및 저장
	String msg = "안녕하세요";
	msg = URLEncoder.encode(msg, "utf-8");
	Cookie cookie = new Cookie("session_cookie", msg);
	response.addCookie(cookie);

	System.out.printf("인코딩 메시지: %s\n", msg);
	String msg1 = URLDecoder.decode(msg, "utf-8");
	System.out.printf("디코더 메시지: %s\n", msg1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="cookie_test2.jsp">test2</a>

</body>
</html>