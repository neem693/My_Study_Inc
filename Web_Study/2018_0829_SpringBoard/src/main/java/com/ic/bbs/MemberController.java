package com.ic.bbs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Member_Dao;
import myconst.MyConstant;
import vo.MemberVo;

@Controller
public class MemberController {

	Member_Dao member_dao;
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;

	public Member_Dao getMember_dao() {
		return member_dao;
	}

	public void setMember_dao(Member_Dao member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("/member/login_form.do")
	public String login_form() {

		return MyConstant.MemberController.VIEW_PATH + "member_login_form.jsp";

	}

	@RequestMapping("/member/login.do")
	public String login(String url, String page, String id, String pwd, Model model) {
		// request.setCharacterEncoding("utf-8");

		
		// String url = request.getParameter("url");
		// String page = request.getParameter("page");
		// String id = request.getParameter("id");
		// String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd + "이것은 테스트");

		// id에 해당되는 회원정보 얻어온다.
		MemberVo vo = member_dao.selectOne(id);

		if (vo == null) {
			model.addAttribute("reason", "fail_id");
			return "redirect:login_form.do";
			// response.sendRedirect("login_form.do?reason=fail_id");
			// return;
		} else if (vo.getPwd().equals(pwd) == false) {
			model.addAttribute("reason", "fail_pwd");
			return "redirectlogin_form.do";
			// response.sendRedirect("login_form.do?reason=fail_pwd");
			// return;
		}

		session.setAttribute("user", vo);

		String root = request.getRequestURI();
		String root_array[] = root.split("/");
		root = root_array[1];
		String full_dir = String.format("redirect:/board/list.do?page=%s", page);
		String full_dir_url = String.format("redirect:%s", url);

		System.out.println(full_dir + " " + full_dir_url + "냠냠냠");
		if (url == null || url.isEmpty())
			return full_dir;
		else
			return full_dir_url;
	}

}
