package com.ic.param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import myconst.MyConstant;
import vo.PersonVo;

@Controller
public class ParameterController {

	@RequestMapping("/test_form.do")
	public String test_form() {

		return MyConstant.ParameterController.VIEW_PATH + "test_form.jsp";

	}
	
	
	@RequestMapping("insert2.do")
	@ResponseBody
	public String insert2(PersonVo vo,HttpServletRequest request) 
	{
		System.out.println("객체로 받은 결과");
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getTel());
		System.out.println("요청자 ip:" + request.getRemoteAddr());
		

		return "Complete";
	}

	@RequestMapping("insert.do")
	@ResponseBody
	public String insert( String name, 
						 int age,
						 String tel) 
	{
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(tel);
		
		

		return "Complete";
	}

	@RequestMapping("/test_modify_form.do")
	public String test_modify_form() {

		return MyConstant.ParameterController.VIEW_PATH + "test_modify_form.jsp";

	}

}
