package action.audio;

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

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/audio/upload.do")
public class AudioUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String web_path = "/mp3/";
		String save_dir = request.getServletContext().getRealPath(web_path);
		
		
		MultipartRequest mr = new MultipartRequest(request, save_dir, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());
		System.out.println(mr.getFile("mp3").getName());

		response.sendRedirect("list.do");

	}

}