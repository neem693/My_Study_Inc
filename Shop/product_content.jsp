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
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%"></td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%">
				1000원
				(할인가:800원)
			</td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
		<img src="images/">
			</td>
		</tr>
		<tr>
			<td colspan="2">sdfdskljflskdjf</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" 
				value="장바구니에 담기"
onclick="location.href='addProduct.jsp?p_num='"/>
				<input type="button" 	value="장바구니 보기"
onclick="location.href='cartList.jsp'"/>
			</td>
		</tr>
	</table>
</body>
</html>