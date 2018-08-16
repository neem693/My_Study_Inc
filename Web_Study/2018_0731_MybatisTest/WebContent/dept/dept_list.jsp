<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>

	<ul>
		<c:forEach var="dept" items="${ list }">
			<li>${dept.deptno }:${dept.dname }</li>
			<ul>
				<c:forEach var="sa_list" items="${ dept.sa_list }">
					<li>${sa_list.saname }</li>
					<ul>
						<c:forEach var="go_list" items="${ sa_list.gogek_list }">
							<li>담당고객: ${go_list.goname }</li>
						</c:forEach>
					</ul>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>


</body>
</html>