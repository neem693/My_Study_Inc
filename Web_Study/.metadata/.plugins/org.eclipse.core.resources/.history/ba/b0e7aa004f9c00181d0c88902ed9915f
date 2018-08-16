<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//로그인 정보를 셋팅
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

$(document).ready(function(){
	
	setTimeout("error_msg();",500);
	
})

function error_msg(){
	if('${param.reason}'=='fail_id'){
		alert("아이디가 틀려요");
	}
	else if('${param.reason}'=='fail_pwd'){
		alert("비밀번호가 틀려요");
	}
	else if('${param.reason}'=='logout_success'){
		alert("로그아웃이 완료되었습니다.");
	}
}

function send(f){
	var id = f.id.value;
	var pwd = f.pwd.value;
	var $id_info = $("#id_info");
	var $pwd_info = $("#pass_info");
	$id_info.html('');
	$pwd_info.html('');
	
	if(id==''){
		$id_info.html('아이디를 입력하세요');
		f.id.focus();
		return;
		
	}
	if(pwd==''){
		$pwd_info.html('패스워드를 입력하세요');
		f.id.focus();
		return;
	}
	f.method = "POST";
	f.action = 'login.do';
	f.submit();
}
</script>
<style type="text/css">
table {
	width: 500px;
	margin: 0 auto;
	border: 1px solid black;
	margin: 0 auto;
}

input[type=button] {
width: 50%;
	box-sizing: border-box;
}

input {
	width: 50%;
}

.buttons {
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<form method="post">
	<input type="hidden" name = "page"  value="${param.page}">
		<table>
			<tr>
				<th width="20%">아이디</th>
				<td><input name="id" id="id"><span id="id_info"></span></td>
			</tr>
			<tr>
				<th>페스워드</th>
				<td><input name="pwd" id="pwd" type="password"><span
					id="pass_info"></span></td>
			</tr>
			<tr>
				<td class="buttons" colspan="2"><input type="button"
					value="로그인" onclick="send(this.form)"><input type="button"
					value="회원가입" onclick="location.href ='insert_form.do'"></td>
			</tr>

		</table>
	</form>

</body>
</html>