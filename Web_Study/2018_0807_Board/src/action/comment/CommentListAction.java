package action.comment;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import myconst.MyConst;
import util.Paging;
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
		String strPage = request.getParameter("page");
		System.out.println(strPage);
		int nowPage = 1;
		if (strPage != null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);

		int start = (nowPage - 1) * MyConst.Board.BLOCK_LIST + 1;
		int end = start + MyConst.Board.BLOCK_LIST - 1;

		// mybatis mapper에 전달하기 위해서 Map으로 포장
		Map map = new HashMap();

		System.out.println(start);
		System.out.println(end);

		map.put("start", start);
		map.put("end", end);
		map.put("b_idx", b_idx);

		// List<CommentVo> list = CommentDao.getInstance().selectList(b_idx);
		List<CommentVo> list = CommentDao.getInstance().selectList(map);
		int count_comment = CommentDao.getInstance().selectListCount(b_idx);
		String rtr_comment_list = Paging.getCommentPaging(nowPage, count_comment, MyConst.Comment.BLOCK_LIST,
				MyConst.Comment.BLOCK_PAGE);
		
		//System.out.println(rtr_comment_list);
		
		request.setAttribute("rtr_comment_list", rtr_comment_list);

		request.setAttribute("list", list);

		for (CommentVo vo : list) {
			vo.setContent(vo.getContent().replaceAll("\\n", "<br>"));
		}

		String forward_page = "comment_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}