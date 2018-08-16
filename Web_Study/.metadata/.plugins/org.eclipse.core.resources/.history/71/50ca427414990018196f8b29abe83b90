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

import dao.ProductDao;
import vo.ProductVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/shop/insert.do")
public class ProductInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forward_page = "";
		String dir = "/shop/images";
		String saveDir = request.getServletContext().getRealPath(dir);
		int size = 1024 * 1024 * 10;
		String p_image_s = "", p_image_l = "";
		String category,p_num,p_name,p_company,p_content;
		int p_price,p_saleprice;
		ProductVo vo = null;
		
		
		
		MultipartRequest mr = new MultipartRequest(request, saveDir, size, "utf-8", new DefaultFileRenamePolicy());
	
		File fs = mr.getFile("p_image_s");
		File fl = mr.getFile("p_image_l");
		p_image_s = fs.getName();
		p_image_l = fl.getName();
		if (p_image_s.equals("") || p_image_l.equals("")) {
			forward_page = "insert_form.do?isFail=y";
		} else {
			
			category = mr.getParameter("category");
			p_num = mr.getParameter("p_num");
			p_name = mr.getParameter("p_name");
			p_company = mr.getParameter("p_company");
			p_price = Integer.parseInt(mr.getParameter("p_price"));
			p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
			p_content = mr.getParameter("p_content");
			
			//vo = new ProductVo(p_price, p_saleprice, category, p_num, p_name, p_company, p_image_s, p_image_l, p_content, "sysdate");
			vo = new ProductVo();
			vo.setCategory(category);
			vo.setP_num(p_num);
			vo.setP_name(p_name);
			vo.setP_company(p_company);
			vo.setP_price(p_price);
			vo.setP_saleprice(p_saleprice);
			vo.setP_image_l(p_image_l);
			vo.setP_image_s(p_image_s);
			vo.setP_content(p_content);
		
			int res = ProductDao.getInstance().insert(vo);
			System.out.println(res);
			
			forward_page= "list.do?category="+category;
			

		}

		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}