package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungModifyAction
 */
@WebServlet("/sung/modify.do")
public class SungModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		SungVo vo = new SungVo();
		vo.setName(request.getParameter("name"));
		vo.setEng(Integer.parseInt(request.getParameter("eng")));
		vo.setKor(Integer.parseInt(request.getParameter("kor")));
		vo.setMat(Integer.parseInt(request.getParameter("mat")));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		int res = SungTBDao.getInstance().update(vo);
		
	response.sendRedirect("list.do");

		
		
	}

}
