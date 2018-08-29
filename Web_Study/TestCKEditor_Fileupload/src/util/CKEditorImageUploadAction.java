package util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class CKEditorImageUploadAction
 */
@WebServlet("/ckeditorImageUpload.do")
public class CKEditorImageUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printWriter = null;

        try{
        	String web_path = "/upload/";
            String abs_path = request.getServletContext().getRealPath(web_path);
            int    max_size = 1024*1024*100;
            
            MultipartRequest mr = new MultipartRequest(request, abs_path,max_size,"utf-8",
            		                       new DefaultFileRenamePolicy() 
            		);
            
            File f = mr.getFile("upload");
            String fileName="";
            if(f!=null){
            	fileName = f.getName();
            }
        	
 
            String callback = request.getParameter("CKEditorFuncNum");
            
            response.setContentType("text/html;charset=utf-8");
            printWriter = response.getWriter();
            
            String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
            //System.out.println(url);
            
            String fileUrl = url + web_path + fileName;//url경로
 
            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
                    + callback
                    + ",'"
                    + fileUrl
                    + "','이미지를 업로드 하였습니다.'"
                    + ")</script>");
            printWriter.flush();
 
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}

}
