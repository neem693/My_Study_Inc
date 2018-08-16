<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/visit.css">
<script>
	function modify(f) {
		var idx = f.idx.value;
		var pwd = f.pwd.value;//원래비번
		var c_pwd = f.c_pwd.value;//confirm password

		if (c_pwd == '') {
			alert("수정할 게시물의 비번을 입력하세요");
			f.c_pwd.focus();
			return;
		}

		if (confirm('아저씨 정말 수정할꺼에요?') == false)
			return;
		//비번확인
		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		location.href = 'pickone.do?idx=' + idx;
	}
	function del(f) {

		var pwd = f.pwd.value;//원래비번
		var c_pwd = f.c_pwd.value;//confirm password

		if (c_pwd == '') {
			alert("삭제할 게시물의 비번을 입력하세요");
			f.c_pwd.focus();
			return;
		}

		if (confirm('아저씨 정말 삭제할꺼에요?') == false)
			return;
		//비번확인
		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		f.action = 'delete.do';
		f.method = 'POST';
		f.submit();
	}
</script>
</head>
<body>
	<div id="main_box">
		<h1>::::방명록::::</h1>
		<div style="text-align: center;">
			<input type="button" value="글쓰기"
				onclick="location.href = 'insert_form.do'">

		</div>
		<hr>
		<!-- 데이터가 없을 경우 -->
		<c:if test="${empty list}">
			<div class="empty_style">등록된 게시물이 읎다.</div>
		</c:if>



		<c:forEach var="visit" items="${list}">
			<form>
				<input type="hidden" name="idx" value="${visit.idx }"> <input
					type="hidden" name="pwd" value="${visit.pwd }">
				<div class="box_style">
					<div class="user">
						<span class="id">${visit.name}</span><br> <span class="ip">${visit.ip}</span><br>
						<span class="date">${visit.regdate}</span>
					</div>
					<div class="content_style">${visit.content}</div>
					<div class="pwd">
						비밀번호:${visit.pwd}<input name="c_pwd" type="password"><input
							type="button" value="삭제" onclick="del(this.form)"><input
							type="button" value="수정" onclick="modify(this.form)">
					</div>
				</div>
			</form>
		</c:forEach>

	</div>

</body>
</html>