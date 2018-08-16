package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import vo.DeptVo;

/**
 * Servlet implementation class DeptnolisAction
 */
@WebServlet("/dept_list.do")
public class DeptnolisAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<DeptVo> dept_list = DeptDao.getInstance().selectList();
		
		request.setAttribute("dept_list", dept_list);
		
		
		request.getRequestDispatcher("dept_list2.jsp").forward(request,response);
		
	}

}
