package com.ic.myvisit;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.VisitDao;
import myconst.MyConstant;
import util.Paging;
import vo.VisitVo;

@Controller
public class VisitController {
	
	
	
	VisitDao dao;

	
	
	public VisitDao getDao() {
		return dao;
	}

	public void setDao(VisitDao dao) {
		this.dao = dao;
	}
	
	//검색포함 목록조회
	@RequestMapping("/visit/list.do")
	public String list(String page,String search,String search_text, Model model) {
		int nowpage = 1;
		if(page==null) {
			System.out.println("페이지가 널이다.");
		}else
			nowpage = Integer.parseInt(page);
		
		int start = (nowpage - 1)* MyConstant.VisitController.BLOCK_LIST +1           -1;//mysql이기에 -1을 해줘야 한다.
		//int end = start + MyConstant.VisitController.BLOCK_LIST -1;
		int end = MyConstant.VisitController.BLOCK_LIST; // mysql은 갯수를 표현해야 함
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		System.out.println(start + " " + end);
		
//		String search = request.getParameter("search");
//		String search_text = request.getParameter("search_text");
		VisitVo vo = new VisitVo();
		List<VisitVo> list = null;
		if (search != null) {
			if (search.equals("name")) {
				vo.setName(search_text);
				map.put("name", search_text);
			} else if (search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			} else if (search.equals("content")) {
				map.put("content", search_text);
//				vo.setContent(search_text);
			}
			
			list = dao.selectList_map(map);
		} else {
			list = dao.selectList_map(map);
		}
		System.out.println(vo.getName());
		System.out.println(vo.getContent());
		System.out.println(list.size());
		int count = dao.selectOne_all_count();
		System.out.println(count);
		String paging = Paging.getPaging("list.do", nowpage, count, MyConstant.VisitController.BLOCK_LIST, MyConstant.VisitController.BLOCK_PAGE);
		System.out.println(paging);

		
		
	
		
		model.addAttribute("paging",paging);
		model.addAttribute("list", list);

		// request.setAttribute("search_text", search_text);
		// request.setAttribute("search", search);
		String forward_page = "visit_list.jsp";
//		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
//		disp.forward(request, response);
		
		return MyConstant.VisitController.VIEW_PATH + forward_page;
	}
	
	@RequestMapping("/")
	public String default_page() {
		return "redirect:visit/list.do";
	}
	
	
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return MyConstant.VisitController.VIEW_PATH + "visit_insert_form.jsp";
	}
	
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo,HttpServletRequest request) {
		
		/*String name = request.getParameter("name");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");*/
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		String content = vo.getContent().replaceAll("\n", "<br>");
		vo.setContent(content);
		
		System.out.println(vo);
		
		//VisitVo vo  = new VisitVo(name, content, pwd, ip);
		
		int res = dao.insert(vo);
		System.out.println(res);
		
		
		
		
		
		//방명록 목록보기로 이동
		

	
		return "redirect:list.do";
	}
	
	
	@RequestMapping("/visit/modify_comp.do")
	public String modify(VisitVo vo, HttpServletRequest request) {
		
//		String name = request.getParameter("name");
//		String content = request.getParameter("content");
//		String pwd = request.getParameter("pwd");
//		int idx = Integer.parseInt(request.getParameter("idx"));
		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		String content = vo.getContent();
		content = content.replaceAll("\n", "<br>");
		
		
//		VisitVo vo = new VisitVo(name, content, pwd, ip);
//		vo.setIdx(idx);
		
		int res = dao.update(vo);
		System.out.println(res);
		String redirect_page = "list.do";
		return "redirect:" +redirect_page;
		
	}
	
	@RequestMapping("/visit/pickone.do")
	public String pickOne(int idx, Model model) {
//int idx = Integer.parseInt(request.getParameter("idx"));
		
		VisitVo vo= dao.selectOne(idx);
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);
		model.addAttribute("vo",vo);
		
		
		String forward_page = "modify.jsp";
		return MyConstant.VisitController.VIEW_PATH + forward_page; 
	}
	
	
	@RequestMapping("/visit/delete.do")
	public String delete(int idx){
		
		VisitVo vo = new VisitVo();

		vo.setIdx(idx);
		System.out.println(vo.getIdx());

		int res = dao.delete(vo);
		System.out.println(res);
		String redirect_page = "list.do";
		
		return "redirect:"+redirect_page;
	}
	
	
	@RequestMapping("/visit/test.do")
	public String test(Model model) {
		
		model.addAttribute("page",5);
		model.addAttribute("search","name");
		model.addAttribute("search_text","길동");
		
		
		return "redirect:list.do";
	}
	
	
	//비밀번호 체크
	
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public String check_pwd(int idx, String c_pwd) {
		
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
		
//		int idx = Integer.parseInt( request.getParameter("idx"));
//		String c_pwd = request.getParameter("c_pwd");
		System.out.println("호출된다.");
		VisitVo vo = dao.selectOne(idx);
		String out = null;
		if(vo.getPwd().equals(c_pwd)) {
			out="c";
		}else
			out="x";
		
		return out;
	}
	
	
	
	

}
