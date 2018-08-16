package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterActionServlet
 */
@WebServlet("/member_reg.do")
public class MemberRegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String blood = request.getParameter("blood");
		String profile = request.getParameter("profile");
		
		String[] hobby_array = request.getParameterValues("hobby");
		String hobby_str = "취미없음";
		if(hobby_array != null) {
			StringBuffer sb = new StringBuffer();
			for(String hobby : hobby_array) {
				sb.append(hobby);
				sb.append(" ");
			}
			hobby_str = sb.toString();
		}
		
		String [] friend_array = request.getParameterValues("friend");
		String friend_str = "";
		
		StringBuffer sb1 = new StringBuffer();
		for(String friend : friend_array) {
			sb1.append(friend);
			sb1.append(" ");
		}
		friend_str = sb1.toString().trim();
		
		if(friend_str.isEmpty())
			friend_str = "친구없음";
		
		
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(sex);
		System.out.println(hobby_str);
		System.out.println(friend_str);
		
		response.getWriter().println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<style>\r\n" + 
				"\r\n" + 
				"table {\r\n" + 
				"	border-collapse: collapse;\r\n" + 
				"	width: 30%;\r\n" + 
				"	margin: 0 auto;\r\n" + 
				"	border: 3px solid black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"tr, td {\r\n" + 
				"	border: 1px solid black;\r\n" + 
				"}\r\n" + 
				"td{\r\n" + 
				"text-align: center;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" +
				"<script>\r\n" + 
				"window.onload = function(){\r\n" + 
				"	var td = document.getElementsByTagName(\"td\");\r\n" + 
				"	td = td[1];\r\n" + 
				"\r\n" + 
				"	td.style.width = \"45%\";\r\n" + 
				"	\r\n" + 
				"};\r\n" + 
				"</script>" +
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"	<table>\r\n" + 
				"		<tr>\r\n" + 
				"			<td colspan=\"2\">입력된 항목</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">이름</td>\r\n" + 
				"			<td width=\"80%\">" + name + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">아이디</td>\r\n" + 
				"			<td width=\"80%\">" + id + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">비밀번호</td>\r\n" + 
				"			<td width=\"80%\">" + pwd + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">성별</td>\r\n" + 
				"			<td width=\"80%\">" + sex + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">취미</td>\r\n" + 
				"			<td width=\"80%\">"+ hobby_str + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">친구</td>\r\n" + 
				"			<td width=\"80%\">"+ friend_str + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">혈액형</td>\r\n" + 
				"			<td width=\"80%\">" + blood + "형</td>\r\n" + 
				"		</tr>\r\n" + 
				"		<tr>\r\n" + 
				"			<td width=\"20%\">자기소개</td>\r\n" + 
				"			<td width=\"80%\">" + profile + "</td>\r\n" + 
				"		</tr>\r\n" + 
				"	</table>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}

}
