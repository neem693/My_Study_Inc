package com.ic.myvisit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestInerceptorController {
	
	@RequestMapping(value = "/adult/list.do")
	@ResponseBody
	public String adult_list() {
		
		return "AA";
		
	}
	
	@RequestMapping(value = "/adult/not_login.do")
	@ResponseBody
	public String adult_login() {
		
		return "AA";
		
	}


}
