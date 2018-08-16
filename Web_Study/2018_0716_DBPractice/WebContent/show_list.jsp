<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

td, th {
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>사원 출력</h1>
	${ sawon_list.size() }
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>성별</th>
			<th>부서번호</th>
			<th>직위</th>
			<th>고용날짜</th>
			<th>상사사번</th>
			<th>연봉</th>
		</tr>
		<c:forEach var="slist" items="${ sawon_list }">

			<tr>
				<td>${ slist.sabun}</td>
				<td>${ slist.saname }</td>
				<td>${ slist.sasex }</td>
				<td>${slist.deptno }</td>
				<td>${slist.sajob }</td>
				<td>${slist.getSahire() }</td>
				<td><c:choose>
						<c:when test="${slist.samgr ==0}">없음</c:when>
						<c:otherwise>${slist.samgr }</c:otherwise>
					</c:choose></td>
				<td>${slist.sapay }</td>
			</tr>
		</c:forEach>

	</table>

	<h1>고객출력</h1>

	<table>
		<tr>
			<th>고객번호</th>
			<th>고객이름</th>
			<th>고객주소</th>
			<th>고객주민번호</th>
			<th>고객담당사원번호</th>
		</tr>
		<c:forEach var="glist" items="${gogek_list}">
			<tr>
				<td>${glist.gobun}</td>
				<td>${glist.goname }</td>
				<td>${glist.goaddr }</td>
				<td>${glist.gojumin }</td>
				<td>${glist.godam }</td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>