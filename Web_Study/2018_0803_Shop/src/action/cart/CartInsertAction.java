package action.cart;

/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;
import vo.MemberVo;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/shop/cart_insert.do")
public class CartInsertAction extends HttpServlet {
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();


		MemberVo m_vo = (MemberVo) request.getSession().getAttribute("user");
		if (m_vo.getId() == null) {
			System.out.println("실패");
			out.print(String.format("[{'anwser':'%s'}]", "fail"));
			return;

		}
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));

		CartVo c_vo = new CartVo();
		c_vo.setP_idx(p_idx);
		c_vo.setM_idx(m_idx);

		CartVo r_vo = CartDao.getInstance().selectOne(c_vo);
		System.out.println(r_vo);
		System.out.println(!(r_vo == null));
		if (!(r_vo == null)) {
			System.out.println("존재함");
			out.print(String.format("[{'anwser':'%s'}]", "exist"));
			return;

		}

		int res = CartDao.getInstance().insert(c_vo);
		out.print(String.format("[{'anwser':'%s'}]", "add"));

	}

}