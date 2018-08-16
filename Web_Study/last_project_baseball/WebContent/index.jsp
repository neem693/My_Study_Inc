<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/layout.css">
<script type="text/javascript">
	function show_menu() {

		var nav = document.getElementById("nav");
		if (nav.className == "")
			nav.className = "show_nav";
		else
			nav.className = "";

	}
</script>

</head>
<body>

	<nav id="nav">
		<div class="nav">
			<div onclick="show_menu();" class="fa fa-align-justify small_bar">
				<p class="nav_text">메뉴</p>
			</div>
			<div class="fa fa-home target small_bar">
				<p class="nav_text">홈</p>
			</div>
			<div class="fa fa-comments small_bar">
				<p class="nav_text">동행</p>
			</div>
			<div class="fa fa-file-text-o small_bar">
				<p class="nav_text">게시판</p>
			</div>
		</div>
		<div class="login">
			<form>
				<table style="margin: 0 auto">
					<tr>
						<td>ID</td>
						<td><input name="id"></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input name="pwd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" id="login_btn"
							value="로그인"></td>
					</tr>
				</table>
			</form>
		</div>

		<div class="menu">

			<h1>동행</h1>

			<div class="fa fa-handshake-o bar_item">
				<p class="nav_text">같이가기</p>
			</div>
			<div class="fa fa-handshake-o bar_item">
				<p class="nav_text">같이가기</p>
			</div>


		</div>


	</nav>





</body>
</html>