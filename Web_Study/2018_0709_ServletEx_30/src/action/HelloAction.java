package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr();
		System.out.println(ip + "님 안녕하세요 호호호호호호ㅗ홓호ㅗ호호호호호호호호호호호호호호호");
		
		request.setCharacterEncoding("utf-8");
		String color = request.getParameter("color");
		if(color == null)
			color = "red";
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("<html>");
		response.getWriter().println("<head><title>안녕</title></head>");
		response.getWriter().println("<body bgcolor = "+ color + ">");
		
		
		response.getWriter().println("<h1>"+ip + "[님]안녕하세요. 허허허허<br>호ㅗ호ㅗ호호호호호호홓</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		response.getWriter().println("");
		
		
	}

}
