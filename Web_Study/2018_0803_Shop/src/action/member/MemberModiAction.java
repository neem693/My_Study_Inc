package action.member;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

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
@WebServlet("/member/modi.do")
public class MemberModiAction extends HttpServlet {
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

		String pwd = request.getParameter("pwd");
		String idx = request.getParameter("idx");
		
		MemberVo vo = new MemberVo();
		vo.setPwd(pwd);
		vo.setIdx(Integer.parseInt(idx));
		
		MemberVo res=null;
		
		res = Member_Dao.getInstance().selectOne(vo);
		
		
		
		request.setAttribute("vo", res);
		

//		System.out.println(res.getName());
//		System.out.println(res.getId());
//		System.out.println(res.getPwd());
//		System.out.println(res.getAddr());
//		System.out.println(res.getZipcode());
		
		String forward_page = "member_modify.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}