<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {

		f.submit();
	}
</script>
</head>
<body>

	<form action="insert.do" method="POST" enctype="multipart/form-data">
		<table border="1" align="center">
			<caption>::::사진등록::::</caption>

			<tr>
				<th>제목</th>
				<td><input name="title"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<th>사진</th>
				<td><input type="file" name="photo"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="사진올리기"
					onclick="send(this.form)"><input type="button" value="목록보기"
					onclick="location.href = 'list.do'"></td>
			</tr>

		</table>
	</form>

</body>
</html>