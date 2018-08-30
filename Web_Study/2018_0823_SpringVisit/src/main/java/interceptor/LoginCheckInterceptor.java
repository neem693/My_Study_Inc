package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor 
      extends HandlerInterceptorAdapter
{

	@Override
	public boolean preHandle(
			HttpServletRequest  request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		//로그인 체크
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		System.out.println("요청 URI : " + uri);
		
		if(uri.contains("not_login")) {
			return super.preHandle(request, response, handler);
		}
			
		
		//로그인정보 구하기
		Object user = session.getAttribute("user");
		if(user==null){
			//로그인이 안된상태
			String contextPath = request.getContextPath();
			String redirect_page = String.format("%s/%s?error=not_login", contextPath,"login_form.do");
			response.sendRedirect(redirect_page);
			
			return false;
		}
					
		
		//월래 주소로 돌려놓아라
		return super.preHandle(request, response, handler);
	}
	
}
