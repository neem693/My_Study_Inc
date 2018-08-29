package com.ic.bbs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDao;
import myconst.MyConst;
import myconst.MyConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;

@Controller
public class BoardController {
	@Autowired
	BoardDao board_dao;
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/board/list.do")
	public String list(String search, String text, String page, Model model) {

		BoardVo voo = null;
		String query = null;

		if (search != null) {
			voo = new BoardVo();
			if (search.equals("name")) {
				voo.setName(text);
				query = String.format("&search=name&text=%s", text);
			} else if (search.equals("content")) {
				voo.setContent(text);
				query = String.format("&search=content&text=%s", text);
			} else if (search.equals("subject")) {
				voo.setSubject(text);
				query = String.format("&search=subject&text=%s", text);
			} else {
				voo.setName(text);
				voo.setContent(text);
				voo.setSubject(text);
				query = String.format("&search=name_subject_content&text=%s", text);
			}
		}
		System.out.println(request.getRequestURL());
		System.out.println("페이지:" + page);
		int nowPage = 1;
		String strPage = page;
		if (strPage != null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);
		 System.out.println(nowPage);

		// 결정된 page에 따라서 start,end 계산
		int start = (nowPage - 1) * MyConst.Board.BLOCK_LIST + 1;
		int end = start + MyConst.Board.BLOCK_LIST - 1;

		// mybatis mapper에 전달하기 위해서 Map으로 포장
		Map map = new HashMap();

		map.put("start", start);
		map.put("end", end);
		map.put("vo", voo);

		List<BoardVo> list = board_dao.selectList(map);
		int count = board_dao.selectCount(map);
		// System.out.println(count);
		String pageMenu = null;
		if (query == null)
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE);
		else
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE,
					query);
		// System.out.println(pageMenu);
		// System.out.println("실행");

		// System.out.println(list.size());

		// request.setAttribute("list", list);
		// request.setAttribute("pageMenu", pageMenu);
		// request.getSession().removeAttribute("show");

		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		session.removeAttribute("show");

		String forward_page = "board_list.jsp";
		// RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		// disp.forward(request, response);

		return MyConstant.BoardController.VIEW_PATH + forward_page;
	}

	@RequestMapping("/board/board_view.do")
	public String board_view(Integer idx,String page,String search, String text, Model model) {
		
		//int idx = Integer.parseInt(request.getParameter("idx"));

		
		
		BoardVo vo = board_dao.selectOne(idx.intValue());
		
		
		//String page = request.getParameter("page");
		
		if(vo.getDel() == 1) {
			//response.sendRedirect("list.do?fail=deleted&page="+page);
			return "redirect:list.do?fail=deleted&page="+page;
		}

		//HttpSession session = request.getSession();
		if (session.getAttribute("show") == null) {
			//System.out.println(session.getAttribute("show"));
			int res = board_dao.update_readhit(idx);
			session.setAttribute("show", session.getId());
		}
		
		

		model.addAttribute("vo", vo);


		//list--------------------------------------------------------
//		String search = request.getParameter("search");
//		String text = request.getParameter("text");
		BoardVo voo = null;
		String query = null;

		if (search != null) {
			voo = new BoardVo();
			if (search.equals("name")) {
				voo.setName(text);
				query = String.format("&search=name&text=%s", text);
			} else if (search.equals("content")) {
				voo.setContent(text);
				query = String.format("&search=content&text=%s", text);
			} else if (search.equals("subject")) {
				voo.setSubject(text);
				query = String.format("&search=subject&text=%s", text);
			} else {
				voo.setName(text);
				voo.setContent(text);
				voo.setSubject(text);
				query = String.format("&search=name_subject_content&&text=%s", text);
			}
		}

		int nowPage = 1;
		String strPage = page;
		if (strPage != null && !strPage.isEmpty())
			nowPage = Integer.parseInt(strPage);
		//System.out.println(nowPage);

		// 결정된 page에 따라서 start,end 계산
		int start = (nowPage - 1) * MyConst.Board.BLOCK_LIST + 1;
		int end = start + MyConst.Board.BLOCK_LIST - 1;

		// mybatis mapper에 전달하기 위해서 Map으로 포장
		Map map = new HashMap();

		map.put("start", start);
		map.put("end", end);
		map.put("vo", voo);

		List<BoardVo> list = board_dao.selectList(map);
		int count = board_dao.selectCount(map);
		//System.out.println(count);
		String pageMenu = null;
		if (query == null)
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE);
		else
			pageMenu = Paging.getPaging("list.do", nowPage, count, MyConst.Board.BLOCK_LIST, MyConst.Board.BLOCK_PAGE,
					query);
		//System.out.println(pageMenu);
		// System.out.println("실행");

		// System.out.println(list.size());
//		request.setAttribute("list", list);
//		request.setAttribute("pageMenu", pageMenu);
//		request.getSession().removeAttribute("show");
		model.addAttribute("list",list);
		model.addAttribute("pageMenu",pageMenu);
		
		
		
		
		//-----list------------------------------------------

		String forward_page = "board_view.jsp";
//		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
//		disp.forward(request, response);
		return MyConstant.BoardController.VIEW_PATH + forward_page;
	}

	@RequestMapping("/board/insert_form.do")
	public String insert_form() {

		return MyConstant.BoardController.VIEW_PATH + "board_write.jsp";
	}
	
	@RequestMapping("/board/insert.do")
	public String insert(BoardVo vo) {
		
		MemberVo user = (MemberVo)session.getAttribute("user");
		if (user == null) {
			//response.sendRedirect("list.do?fail=empty user");
			return "redirect:list.do?fail=empty_user";
		}

//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
//		String pwd = request.getParameter("pwd");
//		String ip = request.getRemoteAddr();
//
//		BoardVo vo = new BoardVo(id, name, subject, content, pwd, ip);
		vo.setIp(request.getRemoteAddr());

		// insert into board values(seq_board_idx.nextVal,'hong','홍길동','도배한다. 오늘은 에어컨이
		// 안나오니까 도배한다.
		// 냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐','에어컨',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0);
		int res = board_dao.insert(vo);
		System.out.println(res);
		//response.sendRedirect("list.do");
		return "redirect:list.do";
	}

}
