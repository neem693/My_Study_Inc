<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 30%;
	border: 2px solid black;
	margin: 0 auto;
}

th {
	background-color: #ccaacc;
}

td>input {
	padding: 5px;
	width: 50%;
}

td>input[type='button'] {
	width: inherit;
}

td.button_end {
	text-align: center;
}

td.button_end>input {
	width: 200px;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/reg_exp.js"></script>
<script>
	var try_addr;

	window.onload = function() {
		try_addr = true;
		$("input").on("focus", function() {
			var attr = $(this).attr("id");
			if (attr == "addr" || attr == "zipcode")
				try_addr = false;
		});

	}

	function check_id() {
		var id = $('#id').val();
		if (id == '') {
			alert('아이디를 입력하세요');
			return;
		}
		var op = {
			url : 'check_id.do',
			data : {
				'id' : id
			},
			success : function(data) {
				data = eval(data);
				//alert(data[0].answer);
				if (data[0].answer == "yes") {
					alert("사용할 수 있는 아이디 입니다.");
					//$('#id').attr("disabled", "disabled");
					$('#id').attr("readOnly", "on");
					$('#bt_reg').removeAttr("disabled");

				} else {
					alert("사용할 수 없는 아이디 입니다.");
				}
			},
			error : function(error) {
			}
		};

		$.ajax(op);
		/* $.ajax({
			url : 'check_id.do',
			data : {
				'id' : id
			},
			success : function(data) {
				//alert(data);
				data = eval(data);
				//alert(data[0].answer);
				if (data[0].answer == "yes") {
					alert("사용할 수 있는 아이디 입니다.");
					$('#id').attr("disabled", "disabled");
					$('#id').attr("readOnly", "on");
					$("#bt_reg").removeAttr("disabled");

				} else
					alert("사용할 수 없는 아이디 입니다.");
			}
		}); */

		//서버로 요청(ajax)
	}
	function send(f) {
		console.log("이것은 샌드이다.");
		var name = f.name;
		var id = f.id;
		var pwd = f.pwd;
		var addr = f.addr;
		var zipcode = f.zipcode;

		if (name.value == '') {
			alert("이름을 입력해주세요");
			name.focus();
			return;
		}
		console.log(pwd.value);
		if (reg_pwd.test(pwd.value) == false) {
			alert("비밀번호는 최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함되어야 합니다.");
			return;
		}
		if (!try_addr) {
			alert("주소찾기 버튼을 눌러서 주소를 입력해주세요");
			return;
		}

		alert(f.addr.value);
		alert(f.zipcode.value);

		addr.disabled = false;
		zipcode.disabled = false;
		id.disabled = false;

		f.method = "GET";
		f.action = "update.do"
		f.submit();

	}

	function find() {

		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
				// 예제를 참고하여 다양한 활용법을 확인해 보세요.
				//alert("우편번호:" + data.zonecode + "\n지번주소:" +data.roadAddress);
				var zipcode = document.getElementById("zipcode");
				var addr = document.getElementById("addr");
				zipcode.value = data.zonecode;
				addr.value = data.roadAddress;

				zipcode.readOnly = "true";
				zipcode.disabled = "true";
				addr.readOnly = "true";
				addr.disabled = "true";

				try_addr = true;

			}
		}).open();

	}
</script>
</head>
<body>

	<form>
		<input type="hidden" name="idx" value="${vo.idx}">
		<table>
			<caption>::::회원가입::::</caption>
			<tr>
				<th>이름</th>
				<td><input name="name" id="name" value="${vo.name}"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" id="id" value="${vo.id}"
					disabled="disabled"><input type="button" value="중복체크"
					onclick="check_id();"></td>
			</tr>
			<tr>
				<th>비번</th>
				<td><input name="pwd" type="password"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" id="addr" value="${vo.addr}"> <input
					type="button" value="주소검색" onclick="find()"></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input name="zipcode" id="zipcode" value="${vo.zipcode}"></td>
			</tr>
			<tr>
				<td class="button_end" colspan="2"><input id='bt_reg'
					type="button" value="수정하기" onclick="send(this.form)"> <!-- send_member가 아니라 send로 보낼 때 에러가 나며 잘 되지 않는다. -->
					<input type="button" value="목록보기"
					onclick="location.href = 'list.do'"></td>
			</tr>
		</table>

	</form>

</body>
</html>