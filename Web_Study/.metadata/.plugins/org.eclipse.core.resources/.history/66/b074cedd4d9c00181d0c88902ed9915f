package action.login;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Member_Dao;
import vo.MemberVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String page = request.getParameter("page");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// id에 해당되는 회원정보 얻어온다.
		MemberVo vo = Member_Dao.getInstance().selectOne(id);

		if (vo == null) {
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		} else if (vo.getPwd().equals(pwd) == false) {
			response.sendRedirect("login_form.do?reason=fail_pwd");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", vo);
		String root = request.getRequestURI();
		String root_array[] = root.split("/");
		root = root_array[1];
		String full_dir = String.format("/%s/board/list.do?page=%s", root,page);
		response.sendRedirect(full_dir);
		
		//정상적인 로그인 처리
		

	}

}