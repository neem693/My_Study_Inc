package action;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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

@WebServlet("/visit/list.do")
public class VisitListAction extends HttpServlet {
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
		String search_text = request.getParameter("search_text");
		VisitVo vo = new VisitVo();
		List<VisitVo> list = null;
		if (search != null) {
			if (search.equals("name")) {
				vo.setName(search_text);
			} else if (search.equals("name_content")) {
				vo.setName(search_text);
				vo.setContent(search_text);
			} else if (search.equals("content")) {
				vo.setContent(search_text);
			}
			list = VisitDao.getInstance().selectList(vo);
		} else {
			list = VisitDao.getInstance().selectList();
		}


		request.setAttribute("list", list);
		// request.setAttribute("search_text", search_text);
		// request.setAttribute("search", search);
		String forward_page = "visit_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

	
}
