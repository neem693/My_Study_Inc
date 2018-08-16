<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="index.jsp"/>
<table align="center" width="600" border="1"
 style="border-collapse:collapse;font-size:8pt"
 bordercolor="navy" cellpadding="4" cellspacing="0">
	<tr bgcolor="#dedede">
		<th width="10%">제품번호</th>
		<th width="10%">이미지</th>
		<th width="35%">제품명</th>
		<th width="20%">제품가격</th>
		<th width="25%">비고</th>
	</tr>


	<tr align="center">
		<td>p11</td>
		<td><img src="images/" 
			width="100" height="90"></td>
		<td>
		  <a href="product_content.jsp?p_num="></a>
		</td>
		<td>
			할인가:2000원<br>
			<font color="red">
				(70%)
			</font>
		</td>
		<td>
			단가:3000원
		</td>
	</tr>

</table>
</body>
</html>









