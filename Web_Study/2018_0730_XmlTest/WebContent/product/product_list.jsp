<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js"></script>
<script>
	function find() {
		console.log("실행되는 중");
		var p_name = $("#p_name").val();
		var start_page =$("#start_page").val();
		var display_count =$("#display_count").val();
		
		if(p_name ==''){
			alert("검색할 상품명을 입력하세요");
			$("#p_name").focus();
			return;
		}
		
		$.ajax({
			url:'search.do',
			data:{
				'p_name':p_name,
				'start_page':start_page,
				'display_count':display_count
				},
				success:function(data){
					$("#disp").html(data);
				}
		});

	}
</script>
</head>
<body>

	검색상품명:
	<input id="p_name">
	<input type="button" value="검색" onclick="find();">
	<br> 시작Page:
	<select id="start_page">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
	</select> 조회건수:
	<select id="display_count">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
		<option value="50">50</option>
		<option value="100">100</option>

	</select>

<div id = "disp"></div>

</body>
</html>