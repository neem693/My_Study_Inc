package action;


/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member_Dao;
import vo.MemberVo;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/member/check_pwd_send.do")
public class CheckPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String idx_str = request.getParameter("idx");
		//System.out.println(idx_str);
		String pwd = request.getParameter("pwd");
		//System.out.println(pwd);
		int idx = Integer.parseInt(idx_str);
		
		MemberVo vo = Member_Dao.getInstance().selectOne(idx);
		
		if(pwd.equals(vo.getPwd())) {
			out.println("yes");
		}
		else {
			out.println("no");
		}
		
		

	}

}