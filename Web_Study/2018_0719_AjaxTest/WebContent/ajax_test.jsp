<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#disp {
	width: 400px;
	height: 600px;
	background-color: black;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/test.js"></script>
<script src="js/httpRequest.js"></script>
<script type="text/javascript">
	function gugudan() {
		var reg_gugudan = /^[2-9]{1}$/;
		var dan_ctrl = document.getElementById("dan");
		var dan = dan_ctrl.value;
		if (reg_gugudan.test(dan) == false) {

			alert('2~9사이의 정수만 입력하세요');
			dan_ctrl.value = '';
			dan_ctrl.focus();
			return;

		}
		//요청서버정보
		var url = 'gugudan.do'; //gugudanAction
		var param = 'dan=' + dan;
		//ajax 통신으로 요청
		sendRequest(url, param, resultFn, 'GET');

	}

	//요청한 결과를 처리하는 callback함수

	function resultFn() {

		console.log('xhr.readyState=' + xhr.readyState);
		console.log('xhr.status=' + xhr.status);

		if (xhr.status == 200 && xhr.readyState == 4) {

			var data = xhr.responseText;

			document.getElementById("disp").innerHTML = data;

		}

	}
</script>
</head>
<body>
	단:
	<input id="dan">
	<input type="button" value="계산" onclick="gugudan();">
	<hr>
	<div id="disp"></div>
</body>
</html>