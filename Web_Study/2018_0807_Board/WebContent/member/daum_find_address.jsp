<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
function pop(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            //alert("우편번호:" + data.zonecode + "\n지번주소:" +data.roadAddress);
            document.getElementById("zipcode").value = data.zonecode;
            document.getElementById("addr1").value = data.roadAddress;
        }
    }).open();
}
</script>

</head>
<body>
우편번호:<input id="zipcode">
<input type="button"  value="검색" onclick="pop();"><br>
<input id="addr1">

</body>
</html>