<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@page import="vo.DeptVo"%>
<%@page import="java.util.List"%>
<%@page import="dao.DeptDao"%>
<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	//부서목록 가져오기
	List<DeptVo> dept_list = DeptDao.getInstance().selectList();
	out.println(dept_list.size());
	//dept_list를 EL로 표현 => Scope 내에 있어야..
	pageContext.setAttribute("dept_list", dept_list);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" align="center" width="400">
		<caption>:::부서목록:::</caption>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
		</tr>
		<c:forEach var="dept" items="${ dept_list }">
			<tr>
				<td>${dept.deptno }</td>
				<td>${dept.dname }</td>
				<td>${dept.loc }</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>