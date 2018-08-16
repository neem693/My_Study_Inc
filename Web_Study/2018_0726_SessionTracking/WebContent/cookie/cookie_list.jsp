<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//현재 도메인이름으로 저장된 쿠키정보를 모두 읽어온다.
	Cookie[] cookies = request.getCookies();
	StringBuffer sb = new StringBuffer("[최근 방문페이지]");
	if (cookies != null) {//쿠키가 없을 때 NULL이 떨어지는걸 방지하기 위하여 
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if (name.equals("JSESSIONID") == false) {
				//System.out.printf("[%s]:%s\n", name, value);
				sb.append(String.format("<br><a href = '%s'>%s</a>", value, name));
			}
		}
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(sb.toString());
	}
%>
