<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//서블릿으로부터 전달받은 데이터 수신
	String result_message = (String) request.getAttribute("result_message");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
p {
	font-size: 25pt;
	color: blue;
	text-shadow: 2px 2px 2px black;
}
</style>
</head>
<body>

	<p>${ result_message }</p>
	이건 el <br>이걸 안쓸려면 다음과 같이 해야 한다.

	<p><%=result_message%></p>
ㅎㅎ 어차피 결과는 똑같으니까
</body>
</html>