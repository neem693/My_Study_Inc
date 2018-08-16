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
<script src="${pageContext.request.contextPath}/js/httpRequest.js"></script>
<script>
	var g_idx;
	function modify(f) {
		g_idx = f.idx.value;
		idx = g_idx;
		var c_pwd = f.c_pwd.value;//confirm password

		if (c_pwd == '') {
			alert("수정할 게시물의 비번을 입력하세요");
			f.c_pwd.focus();
			return;
		}

		var url = "check_pwd.do";
		var param = 'idx=' + g_idx + '&c_pwd=' + c_pwd;

		sendRequest(url, param, resultFn_modify, 'GET');

		location.href = 'pickone.do?idx=' + idx;
	}
	function del(f) {

		var c_pwd = f.c_pwd.value;//confirm password
		g_idx = f.idx.value;

		if (c_pwd == '') {
			alert("삭제할 게시물의 비번을 입력하세요");
			f.c_pwd.focus();
			return;
		}

		//비번확인

		var url = 'check_pwd.do';
		var param = 'idx=' + g_idx + '&c_pwd=' + c_pwd;
		sendRequest(url, param, resultFn_delete, 'GET');

	}
	function resultFn_delete() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;

			if (data.indexOf("c") == -1) {
				alert('비밀번호가 틀립니다');
				return;
			}
			if (confirm('아저씨 정말 삭제할꺼에요?') == false)
				return;

			location.href = "delete.do?idx=" + g_idx;

		}

	}

	function resultFn_modify() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			if (data.indexOf("c") == -1) {
				alert('비밀번호가 틀립니다');
				return;
			}
			if (confirm('아저씨 수정 갑니까?') == false)
				return;

			location.href = "pickone.do?idx=" + g_idx;

		}
	}
	function find() {
		var search = document.getElementById("search").value;
		var search_text = document.getElementById("search_text").value;
		search_text = encodeURIComponent(search_text);
		//alert(search_text);
		var url, param;
		if (search_text == '') {
			alert("검색 내용을 입력하세요");
			return;
		}
		if (search == "name") {

		} else if (search == "content") {

		}

		location.href = "?search=" + search + "&search_text=" + search_text;

	}

	window.onload = function() {

		var search = '${param.search}';
		var search_text = '${param.search_text}';
		console.log(search_text);
		var element = document.getElementById("search");
		var names = document.getElementsByClassName("id");
		var contents = document.getElementsByClassName("content_style");
		
		switch (search) {
		case 'name':
			element[0].selected = true;
			break;
		case 'content':
			element[1].selected = true;
			break;
		case 'name_content':
			element[2].selected = true;
			break;

		}
		
		if(search == ""){
			return;
		}else 
			console.log(search);
		
		for(var i =0;i<names.length;i++){
			var temp = names[i].innerHTML;
			var regex = eval("".concat("/",search_text,"/gi"));
			var rep = "".concat("<span class = 'searched'>",search_text.toUpperCase(),"</span>");
			temp = temp.replace(regex,rep);
			
			//console.log(regex);
			//console.log(rep);
			//console.log(temp);
			names[i].innerHTML = temp;
			
			temp = contents[i].innerHTML;
			regex = eval("".concat("/",search_text,"/gi"));
			rep = "".concat("<span class = 'searched'>",search_text.toUpperCase(),"</span>");
			temp = temp.replace(regex,rep);
			
			//console.log(regex);
			//console.log(rep);
			//console.log(temp);
			contents[i].innerHTML = temp;
			
		}

	};
</script>
</head>
<body>
	<div align="center">
		<a href="list.do">방명록으로</a> <br> <br>
		<select id="search">

			<option selected="selected" value="name">이름</option>
			<option value="content">내용</option>
			<option value="name_content">이름+내용</option>
		</select> <input id="search_text" value="${param.search_text}"> <input
			type="button" value="검색" onclick="find()">
	</div>
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
				<input type="hidden" name="idx" value="${visit.idx}">
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