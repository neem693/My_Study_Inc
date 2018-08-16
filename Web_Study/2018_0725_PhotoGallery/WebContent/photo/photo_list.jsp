<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/photo_list.css"></link>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
var g_idx;

	function download(filename) {
		filename = encodeURIComponent(filename);
		location.href = "${pageContext.request.contextPath}/FileDownload.do?dir=/image/&filename="
				+ filename;
	}
	function modi(f) {
		var pwd_str = f.pwd.value;
		var idx_str = f.idx.value;

		var result = check_pwd(pwd_str, idx_str,"modify");
		result = eval(result);
		result = result[0].result;
		if(result == "yes"){
			alert("수정갑니다.");
		}else{
			alert("비밀번호 제대로 입력해주세요.");
		}
		
		f.action = "modify_form.do";
		f.submit();
		
	};

	function del(f) {
		var pwd_str = f.pwd.value;
		var idx_str = f.idx.value;
		var result = check_pwd(pwd_str, idx_str,"delete");
		//console.log(result);
		result = eval(result);
		result = result[0].result;
		if(result == "yes"){
			alert("삭제완료 ㅋㅋㅋ");
		}else{
			alert("삭제실패ㅋㅋㅋ");
		}
		location.reload();
		
		
			
		
		
	};
	

	function check_pwd(pwd, idx,type) {
		var res;
		$.ajax({
			url : 'check_pwd_idx_ajax.do',
			type : 'post',
			async: false,
			data : {
				'pwd' : pwd,
				'idx' : idx,
				'type': type
			},
			success : function(result) {
				//console.log(result);
				res = result;
			}
		});
		//console.log("ajax가 실행된 후 이게 실행된다.");
		return res;
	}
	
	
	function del2(idx){
		
		var pwd_window = document.getElementById("pwd_window");
		pwd_window.style.display = 'block';
		//console.log(pwd_window.style.width/2);
		pwd_window.style.left =(window.innerWidth/2 - 300/2) + "px";
		pwd_window.style.top = (window.innerHeight/2 - 70/2) + "px";
		var c_pwd = document.getElementById("c_pwd");
		c_pwd.focus();
		g_idx = idx;
	}
	function pwd_close(){
		var pwd_window = document.getElementById("pwd_window");
		pwd_window.style.display = 'none';
		
		var c_pwd = document.getElementById("c_pwd");
		c_pwd.value = "";
	}
	function check_pwd1(){
		var c_pwd = document.getElementById("c_pwd");
		console.log()
	}
</script>
</head>
<body>
	<div style="clear: both; border: 1px solid black;" id="pwd_window">
		<div align="right">
			<input type="button" value="x" onclick="pwd_close()">
		</div>
		<div>
			비밀번호:<input type="password" id="c_pwd"> <input type="button"
				value="확인" onclick="check_pwd1()">
		</div>
	</div>
	<div id="main_box">
		<h1>:::PhotoGallery::::</h1>
		<hr>
		<div>
			<input type="button" value="사진올리기"
				onclick="location.href = 'insert_form.do'">
		</div>

		<hr>
		<div id="photo_box">
			<c:if test="${empty list}">
				<div id="empty_msg">등록된 사진이 없습니다.</div>
			</c:if>
			<c:forEach var="vo" items="${list}">
				<form method="POST">
					<div class="photo_type">
						<img alt=""
							src="${pageContext.request.contextPath}/image/${vo.filename}">
						<p class="title">${vo.title}</p>
						<input name="idx" type="hidden" value="${vo.idx }"> <input
							name="pwd" type="password" value="${vo.pwd}"><br> <input
							type="button" value="다운" onclick="download('${vo.filename}')"><input
							type="button" value="삭제" onclick="del(this.form)"><br><input type="button" value="삭제2" onclick="del2(${vo.idx})"><input type="button" value="수정" onclick="modi(this.form)">


					</div>
				</form>
			</c:forEach>
			<!-- <span style="clear: both;"></span> -->
		</div>
	</div>



</body>
</html>