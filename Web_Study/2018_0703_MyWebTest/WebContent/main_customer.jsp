<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
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
		<div id="aside"><%@include file="menu/submenu_customer.jsp"%></div>
		<div id="content">

			<c:if test="${param.m eq 'notice' or empty param.m}">
				<%@ include file="content/customer/notice.jsp"%></c:if>

			<c:if test="${param.m eq 'faq'}">
				<%@ include file="content/customer/faq.jsp"%></c:if>

			<c:if test="${param.m eq 'board'}">
				<%@ include file="content/customer/board.jsp"%></c:if>




		</div>
		<div id="footer">
			<%@include file="footer/footer.jsp"%>
		</div>
	</div>
</body>
</html>