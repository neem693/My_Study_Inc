<%@page import="javafx.beans.property.SetProperty"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//JSP 내장(숨겨져 있는 )객체
	//_jspService(request,response)
	//pageContext, request, session, application
	//out

	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String str_age = request.getParameter("age");
	int age = Integer.parseInt(str_age);
	String tel = request.getParameter("tel");

	//vo 포장
	PersonVo vo = new PersonVo(name, age, tel);
	
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<caption>::::입력된 정보::::</caption>
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=str_age%></td>
		</tr>
		<tr>
			<th>전화</th>
			<td><%=tel%></td>
		</tr>
	</table>

</body>
</html>