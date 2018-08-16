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

import dao.GogekDbo;
import dao.SawonDao;
import vo.GogekVo;
import vo.SawonVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/gogek/search.do")
public class GogekSearch extends HttpServlet {
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
		String addr = null;
		List<GogekVo> list = null;
		addr = request.getParameter("addr");
		if (addr.equals("all")) {
			list = GogekDbo.getInstance().selectSido();
		} else {
			list = GogekDbo.getInstance().selectSido(addr);
		}
		System.out.println(list.size());
		System.out.println(list.get(0).getGoaddr());
		request.setAttribute("list", list);

		String forward_page = "gogek_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}