<%@page import="vo.PersonVo"%>
<%@page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	PersonVo p1 = (PersonVo) wc.getBean("p1");
	PersonVo p2 = (PersonVo) wc.getBean("p2");
	PersonVo p3 = wc.getBean("p3", PersonVo.class);

	//현재 pageContext 등록 =>EL사용하려고
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);

	pageContext.setAttribute("p3", p3);
%>

<hr>
Spring이 생성해준 객체정보 출력
<hr>

<br>
<br>
<br>

<hr>
p1's info
<hr>
name: ${p1.name}
<br>
age : ${p1.age}
<br>
tel : ${p1['tel']}
<br>



<hr>
p2's info
<hr>
name: ${p2.name}
<br>
age : ${p2.age}
<br>
tel : ${p2['tel']}
<br>




<hr>
p3's info
<hr>
name: ${p3.name}
<br>
age : ${p3.age}
<br>
tel : ${p3['tel']}
<br>