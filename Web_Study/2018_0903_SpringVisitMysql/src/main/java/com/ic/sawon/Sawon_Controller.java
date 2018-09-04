package com.ic.sawon;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.Sawon_Dao;
import myconst.MyConstant;
import vo.SawonVo;

@Controller
public class Sawon_Controller {
	
	Sawon_Dao dao;
	
	
	
	public Sawon_Dao getDao() {
		return dao;
	}



	public void setDao(Sawon_Dao dao) {
		this.dao = dao;
	}



	@RequestMapping("/sawon_list.do")
	public ModelAndView select() {
		List<SawonVo> list= dao.selectList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName(MyConstant.SawonController.VIEW_PATH + "sawon_list.jsp");
		return mv;
		
		
	}
	
	

}
