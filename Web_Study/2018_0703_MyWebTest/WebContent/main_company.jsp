<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/menu.css">
</head>
<body>

	${param.m}
	<br>

	<div id="main_box">
		<div id="header">
			<%@ include file="header/header.jsp"%>
		</div>
		<div id="aside"><%@ include file="menu/submenu_company.jsp"%></div>
		<div id="content">
			<c:if test="${empty param.m or param.m eq 'intro'}">
				<%@include file="content/company/intro.jsp"%>
			</c:if>
			<c:if test="${param.m eq 'history'}">
				<%@include file="content/company/history.jsp"%>
			</c:if>
			<c:if test="${param.m eq 'comeon_myhome'}">
				<%@include file="content/company/location.jsp"%>
			</c:if>


		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>