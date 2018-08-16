package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;
import dao.VisitDao;
import vo.VisitVo;

public class CheckPwdAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");

		VisitVo vo = VisitDao.getInstance().selectOne(idx);

		if (vo.getPwd().equals(c_pwd)) {
			out.print("c");
		} else
			out.print("x");
		
		return null;

	}

}
