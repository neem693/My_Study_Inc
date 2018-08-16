<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src=></script>
<script type="text/javascript">
function del(c_idx){
	if(confirm("정말 삭제하시겠습니까?")==false)return;
	// CartDeleteAction
	location.href = "delete.do?c_idx="+ c_idx;
	
}

	function modify(f) {
		var reg_number=/^[0,9]{1,4}$/;
		var c_cnt = f.c_cnt.value;
		var c_idx = f.c_idx.value;
		
		
		if(reg_number.test(c_cnt)){
			alert("수량을 제대로 입력해주세요");
			return;
		}
		
		location.href = "cart_update.do?c_idx=" + c_idx + "&c_cnt=" + c_cnt;

	}
</script>
</head>
<jsp:include page="index.jsp" />
<body>
	<table align="center" width="600" border="1"
		style="border-collapse: collapse; font-size: 8pt" bordercolor="navy"
		cellpadding="4" cellspacing="0">
		<tr>
			<td colspan="6">:: 장바구니 내용</td>
		</tr>
		<tr bgcolor="#dedede">
			<th>제품번호</th>
			<th width="25%">제품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr align="center">
				<td>${vo.p_num}</td>
				<td>${vo.p_name }</td>
				<td>단가:<fmt:formatNumber value="${vo.p_price }" /> <br> <font
					color="red"> 세일가격:<b><fmt:formatNumber
								value="${vo.p_saleprice}" /></b>
				</font>
				</td>
				<td>
					<!-- 수량 조정 폼 -->
					<form action="editCart.do" method="post">
						<input type="hidden" name="c_idx" value="${vo.c_idx}"> <input
							name="c_cnt" type="number" size="4" style="width: 100px;"
							align="center" value="${vo.c_cnt}"> <input type="button"
							onclick="modify(this.form)" value="수정">
					</form>
				</td>
				<td>${vo.amount }</td>
				<td><input type="button" value="삭제"
					style="border: 1 solid black; cursor: hand"
					onclick="del(${vo.c_idx})"></td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6" align="center"><b>장바구니가 비었습니다.</b></td>
			</tr>
		</c:if>


		<tr>
			<td colspan="5" align="right">총 결재액 :</td>
			<td><fmt:formatNumber value="${all}" /></td>
		</tr>
	</table>
</body>
</html>






