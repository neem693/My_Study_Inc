<%@page import="java.util.List"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%


	List<PersonVo> p_list = new ArrayList<PersonVo>();
	p_list.add(new PersonVo("일길동", 22, "010-111-1111"));
	p_list.add(new PersonVo("이길동", 32, "010-111-1111"));
	p_list.add(new PersonVo("삼길동", 48, "010-111-1111"));
	p_list.add(new PersonVo("사길동", 50, "010-111-1111"));
	p_list.add(new PersonVo("오길동", 27, "010-111-1111"));
	p_list.add(new PersonVo("육길동", 29, "010-111-1111"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border="1" align="center" width="400">
		<caption>::::개인정보 목록::::</caption>
		<!-- 타이틀 -->
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화번호</th>
		</tr>
		<%
			for (int i = 0; i < p_list.size(); i++) {

				PersonVo p = p_list.get(i);
		%>
		<tr>
			<td><% out.print(i+1); %></td>
			<td><%= p.getName() %></td>
			<td><%= p.getAge() %></td>
			<td><%= p.getTel() %></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>