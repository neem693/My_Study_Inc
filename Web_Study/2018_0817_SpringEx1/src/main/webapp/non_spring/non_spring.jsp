<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//객체생성
	PersonVo p1 = new PersonVo("일길동", 30, "010-111-1111");

	//객체생성방법2
	PersonVo p2 = new PersonVo();
	p2.setName("이길동");
	p2.setAge(23);
	p2.setTel("010-222-1234");

	//현재 pageContext 등록 =>EL사용하려고
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
%>

<hr>
p1's info
<hr>
name: ${p1.name}<br>
age : ${p1.age}<br>
tel : ${p1['tel']}<br>



<hr>
p2's info
<hr>
name: ${p2.name}<br>
age : ${p2.age}<br>
tel : ${p2['tel']}<br>