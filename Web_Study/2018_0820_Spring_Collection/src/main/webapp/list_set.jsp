<%@page import="java.util.Set"%>
<%@page import="myutill.MySet"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//스프링 컨테이너(Spring이 생성한 객체 저장소정보)
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);
	//MySet 객체 정보 얻어오기
	MySet mySetBean = wc.getBean("mySetBean", MySet.class);
	Set set = mySetBean.getSet(); //MySet내의 set정보를 읽어오기
	System.out.println("출력하기");
	
	System.out.println(set);

	pageContext.setAttribute("set", set);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:forEach var="d" items="${set}">
			<li>어디냐고? 여기다. : ${d}</li>
		</c:forEach>
	</ul>

</body>
</html>