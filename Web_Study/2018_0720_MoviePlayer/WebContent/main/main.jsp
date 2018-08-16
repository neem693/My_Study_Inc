<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty user}">
	<script>
		alert("현재 컨텐츠를 이용하려면 로그인이 필요합니다.");
		location.href = '${pageContext.request.contextPath }/member/login_form.do';
	</script>
</c:if>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>${user.id}님
		환영합니다.<input type="button" value="로그아웃"
			onclick="location.href ='${pageContext.request.contextPath}/member/logout.do'">
	</p>
	<h1>이곳은 메인입니다.</h1>
	<h2>
		<a href="${pageContext.request.contextPath}/movie/list.do">1.비디오
			볼거냐?</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/audio/list.do">2.오디오
			볼거냐?</a>
	</h2>

</body>
</html>