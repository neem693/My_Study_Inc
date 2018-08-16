<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<jsp:useBean id="p" class="vo.PersonVo"></jsp:useBean>

<%-- PersonVo p = new PersonVo();--%>

<jsp:setProperty property="name" name="p" value="일길동"></jsp:setProperty>
<jsp:setProperty property="age" name="p" value="20"></jsp:setProperty>
<jsp:setProperty property="tel" name="p" value="010-1111-1111"></jsp:setProperty>



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
			<td><jsp:getProperty property="name" name="p"/></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%=p.getAge()%></td>
		</tr>
		<tr>
			<th>전화</th>
			<td><%=p.getTel()%></td>
		</tr>
	</table>


</body>
</html>