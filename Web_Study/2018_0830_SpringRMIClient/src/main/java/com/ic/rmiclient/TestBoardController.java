package com.ic.rmiclient;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BoardDao;
import vo.BoardVo;

@Controller
public class TestBoardController {
	
	BoardDao boardDaoRMI;

	public BoardDao getBoardDaoRMI() {
		return boardDaoRMI;
	}

	public void setBoardDaoRMI(BoardDao boardDaoRMI) {
		this.boardDaoRMI = boardDaoRMI;
	}
	
	
	//게시판 목록 요청
	@RequestMapping("/board_list.do")
	public String list(Model model) {
		
		//원격 서버에 있는 BoardDao객체로부터 목록을 얻어오기
		
		List<BoardVo> list = boardDaoRMI.selectList();
		System.out.println(list.size());
		model.addAttribute("list",list);
		
		
		
		return "/WEB-INF/views/board_list.jsp";
	}
	
	
	
	
	

}
