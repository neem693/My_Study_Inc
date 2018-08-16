package action.check;

import java.io.File;
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

import dao.PhotoDao;
import vo.PhotoVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/photo/check_pwd_idx_ajax.do")
public class CheckPwdIdxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		int res = -1;
		String res_str = null;
		PrintWriter out = response.getWriter();
		String pwd = request.getParameter("pwd");
		String idx = request.getParameter("idx");
		String type = request.getParameter("type");
		// System.out.println(idx);
		// System.out.println(pwd);
		PhotoVo vo = new PhotoVo(Integer.parseInt(idx), pwd);
		PhotoVo photo_vo = PhotoDao.getInstance().selectOne(vo);
		if (photo_vo != null) {
			res = 1;
			System.out.println(photo_vo.getFilename());
			System.out.println(photo_vo.getIdx());
		}
		if (type.equals("delete") && res == 1) {
			String web_path = "/image/";
			ServletContext application = request.getServletContext();
			String save_dir = application.getRealPath(web_path);
			File f = new File(save_dir, photo_vo.getFilename());
			System.out.println(f.delete());
			res = PhotoDao.getInstance().delete(vo);
		}

		if (res == 1) {
			res_str = String.format("[{'result' : '%s'}]", "yes");
		} else
			res_str = String.format("[{'result' : '%s'}]", "no");

		out.println(res_str);

	}

}