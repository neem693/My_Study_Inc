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
	<div id="main_box">
		<div id="header">
			<%@ include file="header/header.jsp"%>
		</div>
		<div id="aside"><%@include file="menu/submenu_product.jsp"%></div>
		<div id="content">
			<c:if test="${param.m eq 'top_sale' or empty param.m}">
				<%@ include file="content/product/top_sale.jsp"%></c:if>

			<c:if test="${param.m eq 'eating'}">
				<%@ include file="content/product/eating.jsp"%></c:if>

			<c:if test="${param.m eq 'not_eating'}">
				<%@ include file="content/product/not_eating.jsp"%></c:if>
		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>