<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	int money = 1230000000;

	//날짜객체
	Date today = new Date();

	pageContext.setAttribute("money", money);
	pageContext.setAttribute("today", today);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	내가 갖고 싶은 돈 :
	<fmt:formatNumber value="${money}"></fmt:formatNumber>
	<br> 현재 날짜 :
	<fmt:formatDate value="${ today }" pattern="YYYY년 MM월 dd일"></fmt:formatDate>



	<hr>
	for문 + if문 이용
	<hr>

	<c:forEach var="i" begin="1" end="5">

		<c:if test="${i%2==1 }">
			<font color=red> 안녕(${i})<br>
			</font>
		</c:if>

		<c:if test="${i%2==0 }">
			<font color=green> 안녕(${i})<br>
			</font>
		</c:if>
	</c:forEach>


	<hr>
	choose문 이용
	<hr>

	<c:forEach var="i" begin="1" end="5">
		<c:choose>
			<c:when test="${i mod 2 eq 0 }">
				<font color=red>안녕(${i}))<br></font>
			</c:when>
			<c:when test="${i mod 2 eq 1 }">
				<font color=green>안녕(${i}))<br></font>
			</c:when>
		</c:choose>
	</c:forEach>


</body>
</html>