<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--request.setAttribute("year", jumin_cal.getYear());
		request.setAttribute("age", jumin_cal.getAge());
		request.setAttribute("tti", jumin_cal.getTti());
		request.setAttribute("zzi", jumin_cal.getZi());
		request.setAttribute("season", jumin_cal.getSeason());
		request.setAttribute("sex", jumin_cal.getSex());
		request.setAttribute("local", jumin_cal.getLocal());
     -->

<%
	int year = (int) request.getAttribute("year");
	int age = (int) request.getAttribute("age");
	String tti = (String) request.getAttribute("tti");
	String zzi = (String) request.getAttribute("zzi");
	String season = (String) request.getAttribute("season");
	String sex = (String) request.getAttribute("sex");
	String local = (String) request.getAttribute("local");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
	border: 2px solid black;
}

td {
	border: 1px solid black;
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td colspan="2">이분의 상세정보에 대해서 까발리겠습니다. 허허허허</td>
		</tr>
		<tr>

			<td>출생년도</td>
			<td><%=year%>
		</tr>

		<tr>

			<td>나이</td>
			<td><%=age%>
		</tr>
		<tr>

			<td>띠</td>
			<td><%=tti%>
		</tr>
		<tr>

			<td>천간</td>
			<td><%=zzi%>
		</tr>
		<tr>

			<td>태어난 계절</td>
			<td><%=season%>
		</tr>
		<tr>

			<td>성별</td>
			<td><%=sex%>
		</tr>
		<tr>

			<td>태어난 지역</td>
			<td><%=local%>
		</tr>




	</table>




</body>
</html>