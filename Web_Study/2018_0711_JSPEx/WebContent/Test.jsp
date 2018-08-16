<%@page import="java.util.Random"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="UTF-8"%>
	<%!
	int count =0;
	
	
	void add_count(){
		count++;
	}
	
	%>
	<% 
	//script let=>여기에 자바코드 작성할 수 있다.
	String ip = request.getRemoteAddr();
	out.println("요청자 IP : " + ip);
	
	Calendar c = Calendar.getInstance();
	Random rand = new Random();
	
	add_count();
	
	out.println(String.format("[%d]째 방문자입니다.",count));
	
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr {
	background-color: black;
	color: white;
}

td {
	background-color: #aaaacc;
	color: blue;
}
</style>
</head>
<body>

	<table border="1">
		<tr>
			<th width="10%">번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td width="10%">1</td>
			<td>JSP란?</td>
			<td>홍길동</td>
			<td>1</td>
		</tr>
		<tr>
			<td width="10%">2</td>
			<td>JSP가 서블릿이라며?</td>
			<td>이길동</td>
			<td>10</td>
		</tr>
	</table>



</body>
</html>