<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="myutill.MyProp"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);
MyProp myprop = wc.getBean("myPropBean",MyProp.class);
Properties prop = myprop.getProp();
TreeSet set = new TreeSet(prop.keySet());


pageContext.setAttribute("set", set);
pageContext.setAttribute("prop", prop);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
프로퍼티 변수
<hr>
<c:forEach var="key" items="${set}" >

<p>${key} : ${prop[key]}</p>



</c:forEach>


</body>
</html>