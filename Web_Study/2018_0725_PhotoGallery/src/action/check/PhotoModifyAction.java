package action.check;

import java.io.File;
/**
 * Servlet implementation class SungDeleteAction
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/photo/modify.do")
public class PhotoModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String web_path = "/image/";
		ServletContext application = request.getServletContext();
		String save_dir = application.getRealPath(web_path);

		MultipartRequest mr = new MultipartRequest(request, save_dir, 1024 * 1024 * 10, "utf-8",
				new DefaultFileRenamePolicy());
		String is_delete = mr.getParameter("is_delete");
		String filename;
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		String before_filename = mr.getParameter("before_filename");
		String ip = request.getRemoteAddr();
		int idx = Integer.parseInt(mr.getParameter("idx"));
		boolean check = false;
		PhotoVo vo = new PhotoVo();
		vo.setIdx(idx);
		vo.setFilename(before_filename);
		check = PhotoDao.getInstance().check2(vo);
		if (!check) {
			System.out.println("잘못된 데이터입니다.");
			response.sendRedirect("list.do");

			return;

		}
		
		//System.out.println(is_delete);

		if (is_delete.equals("yes")) {
			vo = new PhotoVo();
			File f = new File(save_dir, before_filename);
			f.delete();

			f = mr.getFile("photo");
			filename = f.getName();
		} else {
			filename = before_filename;
		}

		vo = new PhotoVo(idx, title, filename, pwd, ip);

		int res = PhotoDao.getInstance().update(vo);
		//System.out.println(res + "수정을 완료합니다.");
		

		response.sendRedirect("list.do");

	}

}