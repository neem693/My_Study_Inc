<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
	border: 3px solid black;
	margin: 0 auto;
}

th, tr, td {
	border: 1px solid black;
	padding: 10px;
}

th {
	background-color: #ccccff;
	color: white;
}

#tab_div {
	border: 2px solid blue;
	margin: 0 auto;
	width: 50%;
	padding-bottom: 50px;
	text-align: center;
}
</style>
<title>Insert title here</title>
<script type="text/javascript">
function del(idx){
	if(confirm('정말 삭제하겠는가?')==false)return;
	alert("정말 냉혹한 자이군");
	
	location.href = 'delete.do?idx=' + idx;
}

function modify(idx){
	location.href = 'pick.do?idx=' + idx;
}

</script>

</head>
<body>

	<div id="tab_div">
		<span><input type="button" value="등록하기" onclick="location.href = 'insert_form.do'"></span>
		<table>
			<caption>::::성적관리::::</caption>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
				<th>비고</th>
			</tr>
			<c:forEach var="sung" items="${ requestScope.list }">
				<tr>
					<td>${sung.idx }</td>
					<td>${sung.name }</td>
					<td>${sung.kor }</td>
					<td>${sung.eng }</td>
					<td>${sung.mat }</td>
					<td>${sung.tot }</td>
					<td>${sung.avg }</td>
					<td>${sung.rank }</td>
					<td><input type ="button" value = "수정" onclick="modify(${sung.idx})">
						<input type = "button" value = "삭제" onclick="del(${sung.idx})"></td>

				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>