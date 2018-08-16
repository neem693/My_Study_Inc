<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${empty sessionScope.user }">

	<script>
		alert("현재 컨텐츠를 이용하려면 로그인이 필요합니다.");
		location.href = '${pageContext.request.contextPath }/member/login_form.do';
	</script>

</c:if>
<!DOCTYPE html>
<html>
<head>
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
li.movie{
background-color: red;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/js/httpRequest.js"
	type="text/javascript"></script>
<script type="text/javascript">
	window.onload = function() {
		var url = 'json_list.do'; // MovieListAction
		sendRequest(url, null, resultFn, "GET");
	};

	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var data = xhr.responseText;
			//alert(data);
			//서버에서 전송해준 데이터 받기

			data = eval(data);
			//alert(data.length);

			var select_movie = document.getElementById("select_movie");

			for (var i = 0; i < data.length; i++) {
				var player = data[i].player;
				var dir = data[i].dir;
				var title = data[i].title;

				var option = document.createElement("option");
				option.innerHTML = title;
				option.value = dir;

				select_movie.appendChild(option);
			}

		}
	}

	function showMovie(s) {

		var dir = s.value;
		var url = "show.do"
		var video = document.getElementById("video_movie");
		console.log(dir);
		//video.src = encodeURIComponent(dir);
		video.src = encodeURI(dir);

		//		alert(encodeURI(dir));

		//		alert(encodeURIComponent(dir));
		video.play();

	}
	function send(f) {
		var movie = f.movie.value
		if (movie == '') {
			alert("영상을 입력하세요");
			return;
		}
		f.submit();
	}
</script>
</head>
<body>

	<%@include file="../subject/subject.jsp"%>

	${user.id}님 환영합니다.
	<input type="button"
		onclick="location.href='${pageContext.request.contextPath}/member/logout.do'"
		value="로그아웃">
	<br>
	<select id="select_movie" onchange="showMovie(this)">
		<option value="">::재생할 곡을 선택하세요::</option>

	</select>

	<div id="show">
		<video id="video_movie" controls="controls" width="500"></video>
	</div>

	<hr>
	<form action="upload_movie.do" method="POST"
		enctype="multipart/form-data">
		<input type="file" name="movie"> <input type="button"
			value="영상올리기" onclick="send(this.form)">
	</form>



</body>
</html>