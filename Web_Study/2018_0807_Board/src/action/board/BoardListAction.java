package action.board;

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

import dao.Board_Dao;
import jdk.nashorn.internal.parser.JSONParser;
import myconst.MyConst;
import util.Paging;
import vo.BoardVo;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		String text = request.getParameter("text");
		BoardVo voo = null;
		String query = null;

		if (search != null) {
			voo = new BoardVo();
			if (search.equals("name")) {
				voo.setName(text);
				query = String.format("&search=name&text=%s", text);
			} else if (search.equals("content")) {
				voo.setContent(text);
				query = String.format("&search=content&text=%s", text);
			} else if (search.equals("subject")) {
				voo.setSubject(text);
				query = String.format("&search=subject&text=%s", text);
			} else {
				voo.setName(text);
				voo.setContent(text);
				voo.setSubject(text);
				query = String.format("&search=name_subject_content&&text=%s", text);
			}
		}

		int nowPage = 1;
		String strPage = request.getParameter("page");
		if (strPage != null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);
		//System.out.println(nowPage);

		// 결정된 page에 따라서 start,end 계산
		int start = (nowPage - 1) * MyConst.Board.BLOCK_LIST + 1;
		int end = start + MyConst.Board.BLOCK_LIST - 1;

		// mybatis mapper에 전달하기 위해서 Map으로 포장
		Map map = new HashMap();

		map.put("start", start);
		map.put("end", end);
		map.put("vo", voo);

		List<BoardVo> list = Board_Dao.getInstance().selectList(map);
		int count = Board_Dao.getInstance().selectCount(map);
		//System.out.println(count);
		String pageMenu = null;
		if (query == null)
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE);
		else
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE,
					query);
		//System.out.println(pageMenu);
		// System.out.println("실행");

		// System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu);
		request.getSession().removeAttribute("show");

		String forward_page = "board_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}