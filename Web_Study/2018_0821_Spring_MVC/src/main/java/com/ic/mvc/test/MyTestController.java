package com.ic.mvc.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyTestController {
	

	public MyTestController() {
		// TODO Auto-generated constructor stub
		System.out.println("--MyTestController()--");
	}
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		
		String msg = "¿ä¿ä ÇãÀÌÂ¥ ¿Ô¼·";
		
		//DispatcherServlet ¿¡°Ô Àü´Þ => °á°úÀûÀ¸·Î request binding
		model.addAttribute("msg",msg);
		
		return "/WEB-INF/views/test.jsp";
	}
	@RequestMapping("/test2.do")
	public ModelAndView test2(){
		
		ModelAndView mv = new ModelAndView();
		String msg = "ModelAndView ¿ä ¿Ó½ç ³È³È ÇìÇò";
		mv.addObject("msg",msg);
		mv.setViewName("/WEB-INF/views/test2.jsp");
		
		return mv;
		
	}

}
