package action.cart;


/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;
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
@WebServlet("/shop/cart_list.do")
public class CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberVo user = (MemberVo)request.getSession().getAttribute("user");
		
		if(user ==null) {
			response.sendRedirect("../member/login_form.do");
			return;
		}
		List<CartVo> list = CartDao.getInstance().selectList(user.getIdx());
		int allMount = CartDao.getInstance().selectAllAmount(user.getIdx());
		request.setAttribute("list", list);
		request.setAttribute("all", allMount);
		

		String forward_page = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
