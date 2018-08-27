package com.ic.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;
import service.TestServiceImpl;

@Controller
public class TestController {
	
	TestService service;

	public TestService getService() {
		return service;
	}

	public void setService(TestService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value ="/test.do", produces="text/plain; charset=utf-8" )
	@ResponseBody
	public String test() {
		
		service.test();
		service.test2();
		
		return "≥»≥»≥»  service.test(); »£√‚";
	}
	
	@RequestMapping(value ="/test2.do", produces="text/plain; charset=utf-8" )
	@ResponseBody
	public String test2() {
		
		service.test2();
		
		return "≥»≥»≥»  service.test2(); »£√‚";
	}
	
	

}
