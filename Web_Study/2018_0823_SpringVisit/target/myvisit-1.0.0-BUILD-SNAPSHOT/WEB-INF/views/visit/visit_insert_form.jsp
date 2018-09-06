<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
	
		var name = f.name.value.trim();
		var content = f.content.value.trim();
		var pwd = f.pwd.value.trim();

		if (name == '') {
			alert("작성자명을 입력하세요");
			f.name.focus();
			return;
		}

		if (content == '') {
			alert("내용을 입력하세요");
			f.content.focus();
			return;

		}
		if (pwd == '') {
			alert('비밀번호를 입력하세요');
			f.pwd.focus();
			return;
		}

		f.action = 'insert.do';//VisitInsertAction
		//전송방식 지정
		f.method = 'POST';
		f.submit();
		
		

	}
</script>
</head>
<body>
	<form>
		<table>
			<caption>:::방명록 작성하기::::</caption>
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="4" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="글쓰기"
					onclick="send(this.form)"><input type="button" value="목록보기" onclick="location.href ='list.do'"></td>
		</table>
	</form>
</body>
</html>