<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">

		<tr>
			<%
				for (int dan = 2; dan <= 9; dan++) {
			%>
			<th width="100"><%=dan%> 단</th>
			<%
				}
			%>
		</tr>

		<%
			for (int count = 1; count <= 9; count++) {
				out.println("<tr>");
				for (int dan = 2; dan <= 9; dan++) {
		%>
			<td>
				<%
					out.print(String.format("%d x %d = %d", count, dan, count * dan));
				%>
			</td>

			<%
				}
				out.println("</tr>");
			}
			%>
	</table>





</body>
</html>