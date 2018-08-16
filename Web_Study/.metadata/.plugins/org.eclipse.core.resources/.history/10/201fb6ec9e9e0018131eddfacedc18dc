<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.r_box{
clear: both;
width: 80%;
border-top: 2px solid black;
}
.r_name{
text-align: right;
padding: 10px;
float: left;
width: 20%;
box-sizing: border-box;
}
.r_content{
float: right;
border-left: 1px solid black;

width: 80%;
min-height: 100px;
box-sizing: border-box;

}


</style>
</head>
<body>


	<c:forEach var="vo" items="${list }">
		<div class="r_box">
			<div class="r_name">작성자: ${vo.name}<br>${vo.id}<br>${vo.regdate}</div>
			<c:if test="${vo.id eq user.id}">
				<input type="button" value="X" onclick="del_re(${vo.idx})">
			</c:if>
			<div class="r_content">${vo.content}</div>
		</div>
		

	</c:forEach>

</body>
</html>