package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBDao;
import vo.GogekVo;
import vo.SawonVo;

/**
 * Servlet implementation class ShowList
 */
@WebServlet("/show_list.do")
public class ShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SawonVo> sawon_list = DBDao.getInstance().sawonSelect();
		List<GogekVo> gogek_list = DBDao.getInstance().gogekSelect();

		request.setAttribute("sawon_list", sawon_list);
		request.setAttribute("gogek_list", gogek_list);

		request.getRequestDispatcher("show_list.jsp").forward(request, response);

	}

}
