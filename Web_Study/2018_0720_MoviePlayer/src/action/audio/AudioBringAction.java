package action.audio;

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
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/audio/bringAudio.do")
public class AudioBringAction extends HttpServlet {
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
		String web_path = "/mp3/";
		String save_dir = request.getServletContext().getRealPath(web_path);

		File f = new File(save_dir);
		File ff[] = f.listFiles();

		StringBuffer sb = new StringBuffer();
		sb.append("[");

		for (int i = 0; i < ff.length; i++) {
			File sf = ff[i];
			String file_name = sf.getName();
			System.out.println(file_name);
			String file_names[] = file_name.split("_");
			String type = file_names[0];
			System.out.println(file_names[2]);
			String art = file_names[2].split("\\.")[0];
			String title = String.format("(%s)%s_%s", art, file_names[1], type);

			String root = request.getRequestURI();
			String root_array[] = root.split("/");
			root = root_array[1];

			String dir = String.format("/%s/mp3/%s", root, file_name);

			sb.append(String.format("{'title':'%s','addr':'%s'}", title, dir));
			if ((i == ff.length-1) == false) {
				sb.append(",");
			}
		}
		sb.append("]");
		PrintWriter out = response.getWriter();
		out.println(sb);

	}

}