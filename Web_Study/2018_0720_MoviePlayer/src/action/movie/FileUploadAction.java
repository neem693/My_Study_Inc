package action.movie;

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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/movie/upload_movie.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		
		
		String web_path = "/mp4/";
		ServletContext application = request.getServletContext();
		String save_dir = application.getRealPath(web_path);
		int max_size = 1024 * 1024 * 100;
		
		
		MultipartRequest mr = new MultipartRequest(request, save_dir, max_size,"utf-8",new DefaultFileRenamePolicy());
	
		response.sendRedirect("list.do");
	}

}