<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 50%;
	border: 2px solid black;
	margin: 0 auto;
}

th {
	background-color: #ccaacc;
	padding: 5px;
	height: 50px;
}

td {
	text-align: center;
	padding: 5px;
}
</style>
<script type="text/javascript">
	
	function del(idx){
		
		location.href = "check_pwd.do?type=del&idx=" + idx;
		
	}
function modify(idx){
		
		location.href = "check_pwd.do?type=modi&idx=" + idx;
		
	}
	
</script>
</head>
<body>


	<div id="main_box">
		<h1>::::회원목록</h1>
		<div>
			<input type="button" value="회원가입"
				onclick="location.href = 'insert_form.do'"> <input
				type="button" value="회원가입2"
				onclick="location.href = 'insert_form2.do'">
		</div>
		<div>
			<form>
				<table border="1">
					<tr>
						<th width="5%">번호</th>
						<th width="10%">이름</th>
						<th>아이디</th>
						<th>비번</th>
						<th>주소</th>
						<th>아이피</th>
						<th width="15%">가입일자</th>
						<th>비고</th>
					</tr>
					<!--  회원목록이 없을 경우 -->
					<c:if test="${empty list }">
						<tr>
							<td colspan="8" align="center">가입된 회원정보가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.idx}</td>
							<td>${vo.name}</td>
							<td>${vo.id}</td>
							<td>${vo.pwd}</td>
							<td>${vo.addr }</td>
							<td>${vo.ip}</td>
							<td>${vo.regdate}</td>

							<td><input type="button" value="수정"
								onclick="modify(${vo.idx})"><input type="button"
								value="삭제" onclick="del(${vo.idx})"></td>
						</tr>
					</c:forEach>

				</table>
			</form>
		</div>
	</div>

</body>
</html>