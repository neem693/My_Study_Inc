package action.book;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.book.MySearchUtilBook;
import vo.book.BookVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/book/search.do")
public class BookSearchListBook extends HttpServlet {
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

		String b_name = request.getParameter("bookName");
		int display = Integer.parseInt(request.getParameter("display"));
		int start_count = Integer.parseInt(request.getParameter("start"));
		int start = (start_count - 1) * display + 1;
		String sort = request.getParameter("sort");

		List<BookVo> list = MySearchUtilBook.search_shop(b_name, start, display, sort);

		request.setAttribute("list", list);

		String forward_page = "search_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}