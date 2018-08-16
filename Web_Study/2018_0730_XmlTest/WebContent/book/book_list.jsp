<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	function find() {

		var bookName = $("#bookName").val();
		
		var start = $("#start").val();
		var display = $("#display").val();
		var sort = $("#sort").val();

		if (bookName == '') {
			alert("검색할 책 이름을 입력하세요.");
			$("#bookName").focus();
			return;
		}
		console.log(bookName);
		$.ajax({
			url:'search.do',
			data:{
				'bookName':bookName,
				'start':start,
				'display':display,
				'sort':sort
			},
			success: function(result){
				$("#disp").html(result);
			}
		});
		

	}
</script>
</head>
<body>

	<input id="bookName">
	<select id="start">
		<option selected="selected" value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
	</select>
	<select id="display">
		<option selected="selected" value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
		<option value="40">40</option>
		<option value="50">50</option>
		<option value="100">100</option>
	</select>
	<select id="sort">
		<!-- 
	정렬 옵션: sim(유사도순), date(출간일순), count(판매량순) -->
		<option selected="selected" value="sim">유사도순</option>
		<option value="date">출간일순</option>
		<option value="count">판매량순</option>
	</select>

	<input type="button" onclick="find()" value = "검색하기">
	<div id = "disp"></div>


</body>
</html>