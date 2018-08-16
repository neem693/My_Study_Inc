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
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import dao.Board_Dao;
import vo.BoardVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/board_view.do")
public class BoardViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));

		BoardVo vo = Board_Dao.getInstance().selectOne(idx);
		String page = request.getParameter("page");
		
		if(vo.getDel() == 1) {
			response.sendRedirect("list.do?fail=deleted&page="+page);
			return;
		}

		HttpSession session = request.getSession();
		if (session.getAttribute("show") == null) {
			//System.out.println(session.getAttribute("show"));
			int res = Board_Dao.getInstance().update_readhit(idx);
			session.setAttribute("show", session.getId());
		}

		request.setAttribute("vo", vo);

		String forward_page = "board_view.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}