<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 50%;
	margin: 0 auto;
}

td, th {
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>사원 출력</h1>
	${ list.size() }

	<ol>
		<c:forEach var="ylist" items="${list}">
			<li>${ylist.hire_year}</li>
			<ul>
				<c:forEach var="slist" items="${ylist.sa_season_list}">
					<li>${ slist.season}</li>
					<ul>
						<c:forEach var="nlist" items="${slist.sa_list}">
							<c:if test="${ylist.hire_year eq nlist.year}">
								<li>${ nlist.saname}</li>
							</c:if>

						</c:forEach>
					</ul>
				</c:forEach>
			</ul>

		</c:forEach>
	</ol>



</body>
</html>