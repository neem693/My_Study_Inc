package action;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.sql.SQLException;

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
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("zipcode"));

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String ip = request.getRemoteAddr();

		System.out.println(name);
		System.out.println(pwd);
		System.out.println(zipcode);
		System.out.println(addr);
		System.out.println(ip);

		MemberVo vo = new MemberVo(name, id, pwd, zipcode, addr, ip);

		int res = Member_Dao.getInstance().insert(vo);
		System.out.println(res);
		response.sendRedirect("list.do");

	}

}