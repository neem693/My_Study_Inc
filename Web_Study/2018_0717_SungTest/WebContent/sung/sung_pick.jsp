<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {

		var reg_number = /^([0-1][0]{2}|[0-9]{2})$/;

		var name = f.name.value;
		var kor = f.kor.value;
		var eng = f.eng.value;
		var mat = f.mat.value;

		if (name == '') {
			alert("이름을 입력하세요");
			f.name.value = '';
			f.name.focus();
			return;
		}

		if (reg_number.test(kor) == false) {
			alert("0~100사이의 숫자만 입력하세요!");
			f.kor.focus();
			return;
		}

		if (reg_number.test(mat) == false) {
			alert("0~100사이의 숫자만 입력하세요!");
			f.mat.focus();
			return;

		}
		if (reg_number.test(eng) == false) {
			alert("0~100사이의 숫자만 입력하세요!");
			f.eng.focus();
			return;

		}
		f.action = "modify.do";
		f.submit(); //서버로 전송
	}
</script>
</head>
<body>

	<form>
	
		<table border="1" align="center">
			<caption>::::성적 등록::::</caption>
			
			<tr>
				<th>번호</th>
				<td><input type="hidden" name="idx" value="${vo.idx}">${vo.idx}</td>

			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name" value="${ vo.name }"></td>

			</tr>
			<tr>

				<th>국어</th>
				<td><input name="kor" value="${vo.kor }"></td>


			</tr>
			<tr>

				<th>영어</th>
				<td><input name="eng" value="${vo.eng }"></td>


			</tr>
			<tr>


				<th>수학</th>
				<td><input name="mat" value="${vo.mat }"></td>
			</tr>
			<tr>

				<td colspan="2" align="center"><input type="button"
					value="수정하기" onclick="send(this.form)"> <input
					type="button" value="목록보기" onclick="location.href ='list.do'"></td>
			</tr>


		</table>
	</form> 

</body>
</html>