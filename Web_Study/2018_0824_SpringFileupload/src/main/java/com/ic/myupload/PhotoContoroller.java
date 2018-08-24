package com.ic.myupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import myconst.MyConstant;
import vo.PhotoVo;
import vo.PhotoVo2;

@Controller
public class PhotoContoroller {

	// DispatcherServlet에서 자동으로 연결해준다.
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ServletContext application;

	@RequestMapping("/insert_form.do")
	public String insert_form() {

		return MyConstant.PhotoController.VIEW_PATH + "insert_form.jsp";
	}

	@RequestMapping("/insert_form2.do")
	public String insert_form2() {

		return MyConstant.PhotoController.VIEW_PATH + "insert_form2.jsp";
	}

	// @RequestMapping(value="/insert.do",produces="text/html; charset=utf-8")
	// @ResponseBody
	@RequestMapping("/insert.do")
	public String insert(PhotoVo vo, Model model) throws Exception {

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		// 업로드된 화일정보 체크
		MultipartFile photo = vo.getPhoto();
		if (photo.isEmpty() == false) {// 업로드 화일이 있는 경우
			vo.setFilename(photo.getOriginalFilename());
			//

			new File(abs_path).mkdirs();
			File f = new File(abs_path, vo.getFilename());
			// 파일을 복사

			while (f.exists()) {
				long tm = System.currentTimeMillis();// 현재 시스템 시간
				vo.setFilename(String.format("%d_%s", tm, vo.getFilename()));
				f = new File(abs_path, vo.getFilename());
			}

			// 임시화일 =>저장된 위치로 복사
			photo.transferTo(f);
		}
		System.out.println(abs_path);
		model.addAttribute("vo", vo);

		return MyConstant.PhotoController.VIEW_PATH + "insert_result.jsp";
	}

	@RequestMapping("/insert2.do")
	public String insert2(PhotoVo2 vo, Model model) throws IllegalStateException, IOException {

		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		MultipartFile[] photo_array = vo.getPhoto();
		String[] filename_array = new String[photo_array.length];
		for (int i = 0; i < photo_array.length; i++) {
			filename_array[i] = photo_array[i].getOriginalFilename();

			MultipartFile photo = photo_array[i];

			if (photo.isEmpty() == false) {// 업로드 화일이 있는 경우
				//

				new File(abs_path).mkdirs();
				File f = new File(abs_path, filename_array[i]);
				// 파일을 복사

				while (f.exists()) {
					long tm = System.currentTimeMillis();// 현재 시스템 시간
					filename_array[i] = String.format("%d_%s", tm, filename_array[i]);
					f = new File(abs_path, filename_array[i]);
				}

				// 임시화일 =>저장된 위치로 복사
				photo.transferTo(f);
			}

		}
		vo.setFilename(filename_array);
		model.addAttribute("vo",vo);

		return MyConstant.PhotoController.VIEW_PATH + "insert_result2.jsp";
	}

}
