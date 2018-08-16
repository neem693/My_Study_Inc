<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty user}">
	<script>
		alert("현재 컨텐츠를 이용하려면 로그인이 필요합니다.");
		location.href = '${pageContext.request.contextPath }/member/login_form.do';
	</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.subject{
background-color: black;
margin: 0;
padding: 50px 0;
}
.subject ul li {
	
	list-style-type: none;
	display: inline-block;
	margin: 0 50px;
	font-size: x-large;
}

.subject>ul {
text-align: center;
}
li>a{
color: yellow;

}
li.audio{
background-color: red;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	var res = 0;
	var audio_select;
	var audio;
	var audio_src;
	$(document).ready(function() {
		$audio_select = $("#audio_selector");
		$audio = $("#audio");
		//$audio_src = $("#audio_src");

		var op = {
			url : "bringAudio.do",
			type : "POST",
			async : false,
			success : function(result) {
				res = result;
				//alert(res);
			}
		}
		$.ajax(op);
		res = eval(res);
		add_audio(res);

		$audio_select.on('change', function() {
			audio_play($(this));
		});

	});
	function add_audio(res) {
		if (res.length == 0) {
			console.log("아무것도 읎네");
			return;
		}
		var len = res.length;
		for (var i = 0; i < len; i++) {
			var option = document.createElement("option");
			option.value = res[i].addr;
			option.innerHTML = res[i].title;
			$audio_select.append(option);

		}

	}
	function audio_play(s) {
		console.log("이거 실행한다.");
		console.log(s.val());
		var addr = s.val();
		addr = encodeURI(addr);
		//addr = encodeURIComponent(addr);
		$audio.attr("src", addr);
		$audio.get(0).play();
	}
	function send(f) {
		f.method = "POST";
		f.submit();
	}
</script>
</head>
<body>
	<%@include file="../subject/subject.jsp"%>
	<p style="clear: both;"></p>
	<p>${user.id}님
		환영합니다.<input type="button" value="로그아웃"
			onclick="location.href ='${pageContext.request.contextPath}/member/logout.do'">
	</p>
	<select id="audio_selector">
		<option selected="selected">:::선택하세요:::
	</select>
	<br>
	<br>
	<audio id="audio" controls="controls" src="">
	</audio>

	<form action="upload.do" enctype="multipart/form-data">
		<input name="mp3" type="file"> <input type="button"
			onclick="send(this.form)" value="전송하기">
	</form>

</body>
</html>