package com.ic.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import myconst.MyConstant;
import vo.DeptVo;

@Controller
public class DeptController {
	DeptDao dao;

	public DeptController(DeptDao dao) {
		super();
		this.dao = dao;
	}

	public DeptController() {
		// TODO Auto-generated constructor stub
	}

	public DeptDao getDao() {
		return dao;
	}

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}
	
	
	
	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list =  dao.selectList();
		model.addAttribute("list", list);
		
		return MyConstant.DeptController.VIEW_PATH + "dept_list.jsp";
	}

}
