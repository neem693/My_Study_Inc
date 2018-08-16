package action.photo;

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
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int maxSize = 1024 * 1024 * 10;

		String web_path = "/image/";
		ServletContext application = request.getServletContext();
		String saveDir = application.getRealPath(web_path);
		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());

		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		String ip = request.getRemoteAddr();
		File f = mr.getFile("photo");

		String filename = "No_File";
		if (f != null) {
			filename = f.getName();
		}

		if (filename.equals("No_File")) {
			send(response);
			return;
		}
		PhotoVo vo = new PhotoVo(title, filename, pwd, ip);

		int res = PhotoDao.getInstance().insert(vo);

		if (res == 0) {
			System.out.println("제대로 입력되지 않았음");
		}

		send(response);

	}

	private void send(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("list.do");

	}

}