<%@page import="java.util.List"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//배열
	String[] sido_array = { "서울", "경기", "인천", "강원", "대전" };

	List<PersonVo> p_list = new ArrayList<PersonVo>();
	p_list.add(new PersonVo("일길동", 22, "010-111-1111"));
	p_list.add(new PersonVo("이길동", 22, "010-222-1111"));
	p_list.add(new PersonVo("삼길동", 22, "010-333-1111"));
	p_list.get(1).getName();

	pageContext.setAttribute("sido_array", sido_array);
	pageContext.setAttribute("p_list", p_list);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hr>
	배열 출력하기
	<hr>
	<!--  items <= 배열 컬렉션(Set.ArrayList) -->
	<!--  for(String sido: sido_array) 동일하다 -->
	<ul>
		<c:forEach var="sido" items="${pageScope.sido_array }">
			<li>${sido}</li>
		</c:forEach>
	</ul>

	<hr>
	ArrayList 출력하기
	<hr>
	<table border="1">
		<caption>::::개인정보::::</caption>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>전화</th>

		</tr>
		<c:forEach var = "p" items="${p_list}" varStatus="i">
			<tr>

				<td>${ i.index +1 }</td>
				<td>${p.getName()}</td>
				<td>${p.getAge()}</td>
				<td>${p.getTel() }</td>

			</tr>
		</c:forEach>
	</table>




</body>
</html>