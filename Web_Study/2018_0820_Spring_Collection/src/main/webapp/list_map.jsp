<%@page import="java.util.Map"%>
<%@page import="myutill.MyMap"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);
MyMap mymap = wc.getBean("myMapBean",MyMap.class);
Map map = mymap.getMap();

request.setAttribute("map", map);

	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
<p>맵 출력</p>
<hr>
${map.driver }
<br>
${map.url }
<br>
${map.user }
<br>
${map.pwd }
<br>



</body>
</html>