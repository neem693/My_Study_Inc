<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
width: 30%;
}
#modify_table_tr { 
	display:none;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	var g_idx = "${vo.idx}";
	var g_filename = "${vo.filename}";
	var $df;
	var $uf;
	var $is_delete;
	function send(f) {
		//alert(f.is_delete.value);
		f.submit();
	}
	function change(){
		//console.log($is_delete.val());
		$is_delete.val("yes");
		
	}
	function del() {

		$df = $("#delete_table_tr");
		$uf = $("#modify_table_tr");
		$df.css("display", "none");
		$uf.css("display", "table-row");
		$is_delete = $("#is_delete");

		/* 	var idx = "${vo.idx}";
			var filename = "${vo.filename}";
			var $df = $("#delete_table_tr");
			var $uf = $("#modify_table_tr");
			$.ajax({
				url : 'delete_file.do',
				type : 'POST',
				async : false,
				data : {
					'idx' : idx,
					'filename' : filename
				}
				success: function(result){
					if(result=='ok'){
						$df.attr("display","none");
						$uf.attr("display","block");
					}
				}
			}); */

	}
</script>
</head>
<body>

	<form action="modify.do" method="POST" enctype="multipart/form-data">
		<input name = "is_delete" id = "is_delete" type="hidden" value="no"> <input type="hidden" name = "idx"
			value="${vo.idx}">
		<table border="1" align="center">
			<caption>::::사진등록::::</caption>


			<tr>
				<th>제목</th>
				<td><input name="title" value="${vo.title }"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr id="delete_table_tr">
				<th><input type="button" id="delete_btn" value="삭제"
					onclick="del()"></th>
				<td>파일이름:<input name = "before_filename" value ="${vo.filename}" readonly="readonly" ></td>
			</tr>
			<tr id="modify_table_tr">
				<th>파일등록</th>
				<td><input type="file" name ="photo" onchange="change()"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="수정하기"
					onclick="send(this.form)"> <input type="button"
					value="목록보기" onclick="location.href = 'list.do'"></td>
			</tr>

		</table>
	</form>

</body>
</html>