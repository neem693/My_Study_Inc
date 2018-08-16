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
@WebServlet("/board/modify_form.do")
public class BoardModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}
		int idx = Integer.parseInt(request.getParameter("idx"));		
		String id = request.getParameter("id");
		if(!(user.getId().equals(id))) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}
		
		BoardVo mvo = new BoardVo();
		mvo.setId(id);
		mvo.setIdx(idx);
		
		BoardVo vo = Board_Dao.getInstance().selectOne_detail(mvo);
		if(vo==null) {
			response.sendRedirect("list.do?fail=empty user");
			return;
		}
		
		String page = request.getParameter("page");
		System.out.println(page);
		
		request.setAttribute("vo", vo);

		String forward_page = "modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}