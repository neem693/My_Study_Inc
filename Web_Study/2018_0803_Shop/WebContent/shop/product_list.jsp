<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function del(f){
	var ready = confirm("정말 삭제할겁니까?");
	if(ready==false){
		console.log('리턴');
		return;
	}
	var idx = f.idx.value;
	
	f.action = "product_delete.do";
	//f.method = "post";
	f.submit();
	
	
}


</script>
<style>
img {
	max-width: 100px;
	max-height: 90px;
}
</style>
</head>
<body>

	<jsp:include page="index.jsp" />
	<table align="center" width="600" border="1"
		style="border-collapse: collapse; font-size: 8pt" bordercolor="navy"
		cellpadding="4" cellspacing="0">
		<tr bgcolor="#dedede">
			<th width="10%">제품번호</th>
			<th width="">이미지</th>
			<th width="35%">제품명</th>
			<th width="20%">제품가격</th>
			<th width="25%">비고</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<th class="" colspan="5">등록된 상품이 읎습니다!!!!!!!!!!!</th>
			</tr>
		</c:if>



		<c:forEach var="p" items="${list}">
			<tr align="center">
				<td>${p.p_num }</td>
				<td><img src="images/${p.p_image_s}"></td>
				<td><a href="view.do?idx=${p.idx}">${p.p_name}</a></td>
				<td>할인가:<fmt:formatNumber value="${p.p_saleprice }" /><br>
					<font color="red"> ${p.discount_rate}% DC</font>
				</td>
				<td>단가:<fmt:formatNumber value="${p.p_price }" />
				<c:if
						test="${not empty user and user.id eq 'admin' }">
						<form>
						<input type="hidden" name = "category" value="${param.category}">
						<input type="hidden" name = "idx" value="${p.idx}">
						<input type="button" onclick="del(this.form)" value="삭제">
						<input type="button" onclick="modify(this.form)" value="수정">
						</form>
				</c:if></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>









