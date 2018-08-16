<%@page import="vo.PersonVo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//EL(Expression Language): 표현언어
	//형식) $( 변수 or 수식)
	//1. 변수는 각 Scopre 내에 저장된 변수만 사용할 수 있다.

	String msg = "반갑습니다";
	Map map = new HashMap();
	map.put("driver", "oracle.jdbc.driver.OracleDriver");
	map.put("url", "jdbc:oracle:thin:@localhost:1521:xe");
	map.put("user", "scott");
	map.put("pwd", "tiger");

	PersonVo p = new PersonVo("일길동", 33, "010-111-1234");

	PersonVo[] p_array = { new PersonVo("이길동", 31, "010-111-1234"), new PersonVo("삼길동", 32, "010-333-1234") };

	pageContext.setAttribute("msg", msg);
	session.setAttribute("msg_session", msg);

	pageContext.setAttribute("map", map);
	pageContext.setAttribute("p", p);
	pageContext.setAttribute("p_array", p_array);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	msg: ${ msg }
	<br>
	<hr>
	DB접속정보(Map Data 출력)
	<hr>
	Driver : ${ pageScope.map.driver }
	<br> Url : ${ map['url']}
	<br> User : ${ map["user"] }
	<br> Pwd : ${ map.pwd }

	<hr>
	PersonVo's Data
	<hr>
	이름 : ${ pageScope.p.name }
	<br>
	<!-- p.getName() call -->
	나이 : ${ p['age'] }
	<br> 전화: ${ p.tel }
	<br>

	<hr>
	PersonVo's array
	<hr>

	1번째 사람 정보
	<br> 이름: ${ p_array[0].name }
	<br> 이름: ${ p_array[0].age	 }
	<br> 이름: ${ p_array[0].tel	 }
	<br>

</body>
</html>