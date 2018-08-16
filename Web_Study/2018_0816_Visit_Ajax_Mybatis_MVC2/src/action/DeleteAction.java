package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;
import dao.VisitDao;
import vo.VisitVo;

public class DeleteAction implements Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		VisitVo vo = new VisitVo();

		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		System.out.println(vo.getIdx());

		int res = VisitDao.getInstance().delete(vo);
		System.out.println(res);
		String redirect_page = "redirect:list.do";

		return redirect_page;
	}

}
