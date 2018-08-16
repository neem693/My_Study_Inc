package action.comment;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import vo.CommentVo;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/comment_list.do")
public class CommentListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		
		List<CommentVo> list = CommentDao.getInstance().selectList(b_idx);
		
		request.setAttribute("list", list);
		
		for(CommentVo vo : list) {
			vo.setContent(vo.getContent().replaceAll("\\n", "<br>"));
		}

		String forward_page = "comment_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}