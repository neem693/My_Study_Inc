package action;

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
import com.oreilly.servlet.multipart.FileRenamePolicy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String webPath = "/upload/";// 웹경로
		ServletContext application = request.getServletContext();
		// 웹 경로=> 절대경로 구하기
		String saveDir = application.getRealPath(webPath);
		int maxSize = 1024 * 1024 * 100;// 100M

		MultipartRequest mr = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());

		String title1 = mr.getParameter("title1");
		String title2 = mr.getParameter("title2");

		System.out.println(saveDir);

		String filename1 = "no_file";
		String filename2 = "no_file";
		File f = mr.getFile("photo1");
		if (f != null) { // 업로드된 화일이 존재하면
			filename1 = f.getName();
		}
		f = mr.getFile("photo2");
		if (f != null) {
			filename2 = f.getName();
		}

		request.setAttribute("title1", title1);
		request.setAttribute("title2", title2);
		request.setAttribute("filename1", filename1);
		request.setAttribute("filename2", filename2);

		String forward_page = "upload_result2.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}