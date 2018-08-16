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

import dao.SawonDao;
import vo.SawonVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/sawon/search.do")
public class SawonSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String saname = request.getParameter("saname");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		List<SawonVo> list = null; 
		
		if(deptno ==0) {
			list = SawonDao.getInstance().selectList(saname);
		}
		else {
			list = SawonDao.getInstance().selectList(saname,deptno);
		}
		
		request.setAttribute("list", list);

		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}