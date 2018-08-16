package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String str_jumin = request.getParameter("jumin");
		Jumin jumin_cal = new Jumin(str_jumin);
		
		
		
		request.setAttribute("year", jumin_cal.getYear());
		request.setAttribute("age", jumin_cal.getAge());
		request.setAttribute("tti", jumin_cal.getTti());
		request.setAttribute("zzi", jumin_cal.getZi());
		request.setAttribute("season", jumin_cal.getSeason());
		request.setAttribute("sex", jumin_cal.getSex());
		request.setAttribute("local", jumin_cal.getLocal());
		
		RequestDispatcher disp = request.getRequestDispatcher("jumin_result.jsp");
		disp.forward(request, response);
		
		
		
	}

}
