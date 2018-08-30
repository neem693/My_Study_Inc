package com.ic.bbs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import RMI.BoardDaoImpl;
import RMI.BoardVo;

@Controller
public class RIMControllerTest {
	
	
	BoardDaoImpl board_dao;

	public BoardDaoImpl getBoard_dao() {
		return board_dao;
	}

	public void setBoard_dao(BoardDaoImpl board_dao) {
		this.board_dao = board_dao;
	}

	@RequestMapping("/rmi/list.do")
	@ResponseBody
	public String list() {
	List<BoardVo> list =  board_dao.selectList();
	return list.size() + "";

	}

}
