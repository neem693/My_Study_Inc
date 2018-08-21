<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function send(f){
	f.action = "insert.do";
	f.submit();
}
function send2(f){
	f.action = "insert2.do";
	f.submit();
	
}
</script>
</head>
<body>
	<form>

		이름:<input name="name" value = "홍길동"><br> 
		나이:<input name="age" value="30"><br>
		전화:<input name="tel" value="010-111-1111"><br> 
		
		
		
		<input type="button" value="낱개로 받기" onclick="send(this.form);"> 
		<input type="button" value="객체로 받기" onclick="send2(this.form);">


	</form>

</body>
</html>