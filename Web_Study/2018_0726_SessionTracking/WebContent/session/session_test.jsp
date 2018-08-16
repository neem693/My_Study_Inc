<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

//세션 ID
String session_id = session.getId();
HttpSession my_session = request.getSession();
String session_id2 = my_session.getId();
String ip = request.getRemoteAddr();

session.setMaxInactiveInterval(10);



System.out.println(String.format("[%s]:%s",ip,session_id));

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>