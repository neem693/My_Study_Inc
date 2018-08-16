package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		String str = "<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"	<p>\r\n" + 
				"		::::계산결과::::<br> cal1<br> cal2<br> cal3<br> cal4<br>\r\n" + 
				"		cal5<br> <a href=\"6_cacul.html\">다시하기</a>\r\n" + 
				"	</p>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		str = str.replace("cal1", su1 + "+" +su2 + "=" + (su1+su2));
		str = str.replace("cal2", su1 + "-" +su2 + "=" + (su1-su2));
		str = str.replace("cal3", su1 + "*" +su2 + "=" + (su1*su2));
		str = str.replace("cal4", su1 + "/" +su2 + "=" + (su1/su2));
		str = str.replace("cal5", su1 + "%" +su2 + "=" + (su1%su2));
		
		PrintWriter out = response.getWriter();
		out.println(str);
	}

}
