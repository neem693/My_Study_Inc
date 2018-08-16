package action.board;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board_Dao;
import vo.BoardVo;
import vo.MemberVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/modify.do")
public class BoardModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}
		String idx = request.getParameter("idx");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = null;
		

		BoardVo vo = new BoardVo(id, name, subject, content, pwd, ip);
		vo.setIdx(Integer.parseInt(idx));
		String page = request.getParameter("page");
		System.out.println(page);

		int res = Board_Dao.getInstance().update_all(vo);
		//System.out.println(res);
		response.sendRedirect("list.do?page="+page);
	}
}