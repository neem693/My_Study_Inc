package action;
/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/gugudan.do")
public class GugudanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int dan = Integer.parseInt(request.getParameter("dan"));
		
		response.setContentType("text/html; charset=utf-8");
		StringBuffer strb = new StringBuffer();
		for(int i=2;i<=9;i++) {
			strb.append(i + " x " + dan + " = " + i*dan+ "<br>");
		}
		
		response.getWriter().print("구구단 결과 보낼게^^<br>" + strb.toString());

	}

}