package action;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import dao.SawonDao;
import vo.SawonVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/sawon/job_dept_list.do")
public class SawonListAction_job_dept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String sajob = request.getParameter("sajob");
		SawonDao dao = SawonDao.getInstance();
		List<SawonVo> list = null;

		if (deptno == 0 && sajob.equals("all")) {
			list = dao.selectList();
		} else if (deptno == 0) {
			list = dao.selectList(sajob);
		} else if (sajob.equals("all")) {
			list = dao.selectList(deptno);
		} else {
			/*
			 * SawonVo vo = new SawonVo(); vo.setDeptno(deptno); vo.setSajob(sajob);
			 * 
			 * list = dao.selectList(vo);
			 */
			Map map = new HashedMap();
			map.put("no", deptno);
			map.put("job", sajob);
			list = dao.selectList(map);
		}

		request.setAttribute("list", list);
		System.out.println(list.size());
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}