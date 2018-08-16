package action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;
import dao.VisitDao;
import vo.VisitVo;

public class ListAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
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

		return forward_page;
	}

	



}
