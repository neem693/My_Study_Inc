package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;
import dao.VisitDao;
import vo.VisitVo;

public class PickOneAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));

		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		request.setAttribute("vo", vo);

		String forward_page = "modify.jsp";

		return forward_page;
	}

}
