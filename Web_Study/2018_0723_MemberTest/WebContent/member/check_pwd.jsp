<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.main_box {
	width: 50%;
	margin: 0 auto;
	text-align: center;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script>
	$(document).ready(function() {
		$("form").on("keypress", function(e) {
			if (e.keyCode == 13) {
				e.preventDefault();
				console.log("엔터키가 눌러졌다.");
				var form = document.getElementById("form1");
				pwd_send(form);
			}
		});
	});
	function pwd_send(f) {
		var type = "${type}";
		var idx = "${idx}";
		var pwd = f.pwd.value;
		var op;

		op = {
			type : "POST",
			url : "check_pwd_send.do",
			data : {
				'pwd' : pwd,
				'idx' : idx
			},
			success : function(result) {
				console.log(result);
				if (result.indexOf("yes") == -1) {
					alert("비밀번호가 올바르지 않습니다.");
					return;
				} else {
					if (type == "del")
						f.action = "delete.do";
					else
						f.action = "modi.do";
					f.method = "POST";
					f.submit();
				}

			}
		};

		$.ajax(op);

	}
</script>
</head>
<body>

	<div class="main_box">
		<form id="form1">
			<input type="hidden" name="idx" value="${idx}">
			<p>확인을 위해비밀번호를 입력하세요</p>
			<input name="pwd" type="password"> <input type="button"
				onclick="pwd_send(this.form)" value="비밀번호 확인">
		</form>
	</div>


</body>
</html>