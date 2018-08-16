<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function send(f){
	
	var title = f.title.value;
	var photo = f.photo.value;
	if(title ==''){
		alert("제목을 입력하세요");
		f.title.focus();
		return;
	}
	if(photo ==''){
		alert("업로드할 화일을 선택하세요.");
		return;
	}
	
	f.action = 'upload.do';//FileUploadAction
	f.submit();

}

</script>
</head>
<body>

	<form method="POST" enctype="multipart/form-data">
		제목:<input name="title"><br> 포토:<input type="file"
			name="photo"><br> <input type="button" value="올리기"
			onclick="send(this.form)">

	</form>


</body>
</html>