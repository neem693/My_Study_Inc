package action;

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

import dao.Member_Dao;
import vo.MemberVo;



/**
 * Servlet implementation class SungDeleteAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//수신 인코딩 설정
		PrintWriter out;
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		//id에 해당되는 MemberVo객체 얻어오기
		MemberVo vo = Member_Dao.getInstance().selectOne(id);
		
		//System.out.println(id);
		String result = "no";
		
		if(vo==null) {
			result = "yes";
		}
		
		response.setContentType("text/html charset =utf-8");
		out = response.getWriter();
		String result_json = String.format("[{'answer':'%s'}]", result);
		//이렇게 안하면 안넘어 간다. {}로 하면은 안넘어 간다. 반드시 배열을 추가해줘야 한다.
		out.print(result_json);

	}

}