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

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/board/comment_delete.do")
public class CommentDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		
		int res = CommentDao.getInstance().delete(idx);
		String result; 
		if(res==-1 || res==0) {
			result = String.format("[{'result':'%s'}]","fail");
		}else {
			result = String.format("[{'result':'%s'}]","success");
		}
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(result);

	}

}