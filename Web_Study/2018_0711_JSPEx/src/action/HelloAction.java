package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// hello.do?gubun=아침
		// hello.do?gubun=점심
		// hello.do?gubun=저녁

		// 수신인코딩 설정
		request.setCharacterEncoding("utf-8");

		String gubun = request.getParameter("gubun");

		if (gubun == null || gubun == "") {
			gubun = "아침";

		}

		String message = "";
		switch (gubun) {
		case "아침":
			message = "Good Morning";
			break;
		case "점심":
			message = "Good AfterNoon";
			break;
		case "저녁":
			message = "Good Evening!!";
			break;

		default:
			break;
		}
		
		
		String result_message = String.format("[%s]인사 : %s", gubun,message);
		
		
		//Servlet과 JSP간의 데이터를 공유하기 위해서 Binding시킨다
		request.setAttribute("result_message", result_message);
		
		//계산된 결과를 출력객체(JSP)에게 전달해서 출력하게끔 forward시킨다.
		
		RequestDispatcher disp = request.getRequestDispatcher("hello.jsp");
		disp.forward(request, response);

	}
}
