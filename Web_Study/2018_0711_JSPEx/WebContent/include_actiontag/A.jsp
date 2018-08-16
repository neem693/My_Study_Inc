<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg = "안녕하세요";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {
	color: red;
}
</style>
</head>
<body>
##############################<br>
<p>여기는 A 영역입니다.</p><br>
##############################<br>

<jsp:include page="B.jsp"></jsp:include>

</body>
</html>