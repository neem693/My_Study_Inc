<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: center;
	padding: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>최저가</th>
			<th>최고가</th>
			<th>판매몰</th>

		</tr>

		<c:forEach var="vo" items="${list}" varStatus="i">

			<tr>
				<td>${i.index }</td>
				<td><img width="120" height="80" src='${vo.image }'></td>
				<td><a href="${vo.link}">${vo.title}</a></td>
				<td><fmt:formatNumber type="number" maxFractionDigits="3"
						value="${vo.lprice }"></fmt:formatNumber></td>
				<td><fmt:formatNumber type="number" maxFractionDigits="3"
						value="${vo.hprice }"></fmt:formatNumber></td>
				<td>${vo.mallName }</td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>