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

import dao.VisitDao;
import vo.VisitVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/visit/modify_comp.do")
public class VisitMoCompAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String ip = request.getRemoteAddr();
		
		
		content = content.replaceAll("\n", "<br>");
		
		
		VisitVo vo  = new VisitVo(name, content, pwd, ip);
		vo.setIdx(idx);
		
		int res = VisitDao.getInstance().update(vo);
		
		String redirect_page = "list.do";
		response.sendRedirect(redirect_page);


	}

}