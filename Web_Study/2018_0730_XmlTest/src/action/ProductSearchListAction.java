package action;

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

import util.MySearchUtil;
import vo.ProductVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/product/search.do")
public class ProductSearchListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		// 넘어온 파라메터 수신
		String p_name = request.getParameter("p_name");
		// 조회건수
		int display = Integer.parseInt(request.getParameter("display_count"));
		// 시작페이지
		int start_page = Integer.parseInt(request.getParameter("start_page"));
		// 가져올 시간 위치 계산
		int start = (start_page - 1) * display + 1;
		
		//start_page = 2 display= 10
		
		List<ProductVo> list = MySearchUtil.search_shop(p_name, start, display);
		request.setAttribute("list", list);
		

		String forward_page = "product_search_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}