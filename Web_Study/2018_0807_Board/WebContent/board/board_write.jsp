<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>쓰기</title>
<script></script>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script language=javascript>
	function send_check(f) {

		if (f.subject.value == '') {
			alert('제목을 입력하세요');
			f.subject.focus();
			return false;
		}

		if (f.pwd.value == '') {
			alert('비밀번호를 입력하세요');
			f.pwd.focus();
			return false;
		}

		f.action = "insert.do";
		f.submit();
	}
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table width="760" align="center">
		<tr>
			<td>
				<table width="690" height="50" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td><img src="../img/title_04.gif"></td>
					</tr>
				</table> <!--타이틀 영역의 끝-->
			</td>
		</tr>
		<tr>
			<td>
				<form method="post">
					<input type="hidden" name="id" value="${user.id }">
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="120" height="25" class="td_d">제목</td>
							<td class="td_d_1" colspan="3"><input name="subject"
								type="text" class="search" style="width: 250px;"></td>

						</tr>
						<tr>
							<td height="25" class="td_d_4">작성자</td>
							<td class="td_d_2" colspan="3"><input name="name"
								type="text" value="${user.name}" readonly="readonly"
								class="search" style="width: 250px;"></td>
						</tr>

						<tr>
							<td class="td_d_4">내용</td>
							<td class="td_d_2" colspan="3"><TEXTAREA NAME='content'
									rows="9" cols="65"></TEXTAREA></td>
						</tr>
						<tr>
							<td height="25" class="td_d_4">비밀번호</td>
							<td class="td_d_3" colspan="3"><input name="pwd"
								type="password" class="search" style="width: 70px;"></td>
						</tr>



					</table>
					<table width="750" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="5"></td>
						</tr>
						<tr>
							<td align="center"><input type="image"
								src="../img/btn_reg.gif"
								onClick="send_check(this.form); return false;"
								style="cursor: pointer;"> <img src="../img/btn_back.gif"
								onClick="location.href='list.do'" style="cursor: pointer;"></td>
						</tr>
					</table>

				</form>
			</td>
		</tr>
	</table>
</body>

</html>