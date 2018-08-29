package com.ic.bbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.BoardVo;
import vo.PersonVo;

@Controller
public class JSONController {
	
	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test_map() {
		Map map = new HashMap();
		map.put("name", "홍길동");
		map.put("age",20);
		map.put("tel", "010-111-1234");
		
		
		return map;
		
	}
	
	@RequestMapping("/test_object.do")
	@ResponseBody
	public PersonVo test_object() {
		
		PersonVo vo = new PersonVo("길동1","진짜길동0","232323",new Date());
		return vo;
		
	}
	
	@RequestMapping("/test_list.do")
	@ResponseBody
	public List test_list() {
		List list = new ArrayList();
		
		list.add("서울");
		list.add("경기");
		list.add("대전");
		list.add("인천");
		
		return list;
	}
	
	@RequestMapping("test_object_list.do")
	@ResponseBody
	public List test_object_list() {
		List list = new ArrayList();
		
		list.add(new PersonVo("길동1","진짜길동0","232323",new Date()));
		list.add(new PersonVo("길동2","진짜길동1","223323",new Date()));
		list.add(new PersonVo("길동3","진짜길동2","23323",new Date()));
		list.add(new PersonVo("길동4","진짜길동3","23323",new Date()));

		
		
		return list;
		
		
	}
	
	

}
