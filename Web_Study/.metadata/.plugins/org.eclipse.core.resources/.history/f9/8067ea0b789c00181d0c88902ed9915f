package action.comment;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import vo.CommentVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/comment_insert.do")
public class CommentInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int b_idx = Integer.parseInt(request.getParameter("b_idx"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		String ip  = request.getRemoteAddr();
		
		CommentVo vo = new CommentVo(id, name, ip, content, b_idx);
		
		int res = CommentDao.getInstance().insert(vo);
		
		String result = "success";
		
		if(res ==0||res == -1)
			result = "fail";
		
		String result_json = String.format("[{'result':'%s'}]", result);
		response.setContentType("text/html; charset=utf-8;");
		response.getWriter().print(result_json);
		

	}

}