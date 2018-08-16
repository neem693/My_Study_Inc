package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;
import dao.VisitDao;
import vo.VisitVo;

public class InsertAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		response.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		content = content.replaceAll("\n", "<br>");
		
		System.out.println(name + " " + content + " " + pwd + " " + ip);
		
		VisitVo vo  = new VisitVo(name, content, pwd, ip);
		
		int res = VisitDao.getInstance().insert(vo);
		System.out.print(res);
		
		
		
		
		
		//방명록 목록보기로 이동
		

		String redirect_page = "redirect:list.do";
		return redirect_page;
	}



	

}
