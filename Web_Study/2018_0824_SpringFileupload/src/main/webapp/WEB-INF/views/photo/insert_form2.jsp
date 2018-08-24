<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(f){
	var title =f.title.value;
	var photo1 = f.photo[0].value;
	var photo2 = f.photo[1].value;
	
	if(title==''){
		alert("제목을 입력하세요");
		f.title.focus();
		return;
		
	}
	
	if(photo1==''){
		alert("사진1을 입력하세요");
		return;
		
	}
	if(photo2==''){
		alert("사진2를 입력하세요");
		return;
		
	}
	f.action = 'insert2.do';
	f.submit();
	
	
}
</script>
</head>
<body>

	<form method="POST" enctype="multipart/form-data">
		제목1:<input name="title"><br> 
		
		사진1:<input type="file"name="photo"><br>	
		사진2:<input type="file"name="photo"><br>		
		
		<input type="button" value="전송하기" onclick="send(this.form);">

	</form>

</body>
</html>