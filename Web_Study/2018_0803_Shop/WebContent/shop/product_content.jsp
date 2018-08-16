<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var p_idx = ${vo.idx};
var m_idx = ${user.idx};
function check_login(){
	//alert(${empty user});
	if(${empty user}){
		return false;
	}
	//로그인된 정보가 없으면 false
	//session에 user로 로그인한 정보저장
}


function add_cart(){
	
	
	if(check_login()==false){
		alert("로그인 한 후에 이용하세요");
		location.href = "${pageContext.request.contextPath}/member/login_form.do";
		return;
	}

	var op = {
			url:'cart_insert.do',
			data:{
				'p_idx':p_idx,
				'm_idx':m_idx
			},
			async:false,
			success:function(result){
				//alert(result);
				var res= result;
				res = eval(res);
				if(res[0].anwser=="add"){
					alert("장바구니에 추가되었습니다.");
				}
				else if(res[0].anwser=="exist"){
					alert("해당 상품은 이미 존재합니다.");
				}
				else if(res[0].anwser=="fail"){
					alert("잘못된 접근");
				}
			}
			
	};
	$.ajax(op);
	
	if(confirm("장바구니 화면으로 이동하시겠습니까?")==false) return;
	
	location.href = "${pageContext.request.contextPath}/shop/cart_list.do";
	
}

function show_cart(){
	
	if(check_login()==false){
		alert("로그인 한 후에 이용하세요");
		location.href = "${pageContext.request.contextPath}/member/login_form.do";
		return;
	}
	location.href = "${pageContext.request.contextPath}/shop/cart_list.do"
	
	
}

</script>
<style type="text/css">
.danga {
	text-decoration: line-through;
}
</style>
</head>
<body>

	<jsp:include page="index.jsp" />

	<table align="center" width="600" border="1"
		style="border-collapse: collapse; font-size: 8pt" bordercolor="navy"
		cellpadding="4" cellspacing="0">
		<tr>
			<td width="40%">제품분류</td>
			<td width="60%">${vo.category }</td>
		</tr>
		<tr>
			<td width="40%">제품번호</td>
			<td width="60%">${vo.p_num }</td>
		</tr>
		<tr>
			<td width="40%">제품명</td>
			<td width="60%">${vo.p_name }</td>
		</tr>
		<tr>
			<td width="40%">제조사</td>
			<td width="60%">${vo.p_company }</td>
		</tr>
		<tr>
			<td width="40%">제품가격</td>
			<td width="60%"><fmt:formatNumber value="${vo.p_saleprice}" />원
				<br> <span class="danga"><fmt:formatNumber
						value="${vo.p_price }" /></span></td>
		</tr>
		<tr>
			<td colspan="2">제품설명</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img
				src="images/${vo.p_image_l }"></td>
		</tr>
		<tr>
			<td colspan="2">${vo.p_content }</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button"
				value="장바구니에 담기" onclick="add_cart();" /> <input type="button"
				value="장바구니 보기" onclick="show_cart();" /></td>
		</tr>
	</table>
</body>
</html>