package com.ic.gallery;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import dao.PhotoDao;
import myconst.MyConstant;
import vo.PhotoVo;

@Controller
public class PhotoGalleryController {

	PhotoDao dao;

	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ServletContext application;

	public PhotoDao getDao() {
		return dao;
	}

	public void setDao(PhotoDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/photo/list.do")
	public String list(Model model) {

		List<PhotoVo> list = dao.selectList();

		model.addAttribute("list", list);

		return MyConstant.PhotoController.VIEW_PATH + "photo_list.jsp";
	}

	@RequestMapping("/photo/insert_form.do")
	public String insert_form() {

		return MyConstant.PhotoController.VIEW_PATH + "photo_insert_form.jsp";
		// String forward_page = "photo_insert_form.jsp";
		// RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		// disp.forward(request, response);
	}

	@RequestMapping("/photo/insert.do")
	public String insert(PhotoVo vo) {

		String web_path = "/resources/image/";
		String real_path = application.getRealPath(web_path);
		MultipartFile photo = vo.getPhoto();
		if (photo.isEmpty() == false) {
			String ip = request.getRemoteAddr();
			String filename = photo.getOriginalFilename();

			new File(real_path).mkdirs();
			File f = new File(real_path, filename);

			while (f.exists()) {
				int time = (int) System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				f = new File(real_path, filename);
			}
			vo.setIp(ip);
			vo.setFilename(filename);
			int res = dao.insert(vo);
			System.out.println("인서트 결과: " + res);

			try {
				photo.transferTo(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			return "redirect:list.do?insert=NoPhoto";

		return "redirect:list.do?insert=success";

		

	}

	@RequestMapping("/photo/FileDownload.do")
	public void download(String dir, String filename, HttpServletResponse response) throws Exception {
		// String dir = request.getParameter("dir");
		String fullpath = application.getRealPath(dir);
		// String filename = "";
		// filename = request.getParameter("filename");
		String fullpathname = String.format("%s/%s", fullpath, filename);
		// System.out.println(fullpathname);
		File file = new File(fullpathname);
		byte[] b = new byte[1024 * 1024 * 10];

		// 사용자 브라우저 타입 얻어오기
		String strAgent = request.getHeader("User-Agent");
		String userCharset = request.getCharacterEncoding();
		if (userCharset == null)
			userCharset = "utf-8";

		// System.out.println("filename:"+filename+"\nagent:"+strAgent+"\ncharset:"+userCharset);
		// System.out.println("----------------------------------------------------------------");
		String value = "";
		// IE 일 경우
		if (strAgent.indexOf("MSIE") > -1) {
			// IE 5.5 일 경우
			if (strAgent.indexOf("MSIE 5.5") > -1) {
				value = "filename=" + filename;
			}
			// 그밖에
			else if (strAgent.indexOf("MSIE 7.0") > -1) {
				if (userCharset.equalsIgnoreCase("UTF-8")) {
					filename = URLEncoder.encode(filename, userCharset);
					filename = filename.replaceAll("\\+", " ");
					value = "attachment; filename=\"" + filename + "\"";

				} else {
					value = "attachment; filename=" + new String(filename.getBytes(userCharset), "ISO-8859-1");

				}
			} else {
				// IE 8.0이상에서는 2회 호출됨..
				if (userCharset.equalsIgnoreCase("UTF-8")) {
					filename = URLEncoder.encode(filename, "utf-8");
					filename = filename.replaceAll("\\+", " ");
					value = "attachment; filename=\"" + filename + "\"";

				} else {
					value = "attachment; filename=" + new String(filename.getBytes(userCharset), "ISO-8859-1");

				}
			}

		} else if (strAgent.indexOf("Firefox") > -1) {
			// Firefox : 공백문자이후은 인식안됨...
			value = "attachment; filename=" + new String(filename.getBytes(), "ISO-8859-1");
		} else {
			// IE 를 제외한 브라우저
			value = "attachment; filename=" + new String(filename.getBytes(), "ISO-8859-1");
		}

		response.setContentType("Pragma: no-cache");

		// 전송 데이터가 stream 처리되도록 : 웹상전송 문자셋은 : 8859_1
		response.setContentType("application/octet-stream;charset=8859_1;");
		// 모든 화일에 대하고 다운로드 대화상자가 열리게 설정
		// Content-Disposition : attachment
		response.setHeader("Content-Disposition", value);
		// 전송타입은 binary(이진화일)
		response.setHeader("Content-Transfer-Encoding", "binary;");
		if (file.isFile()) {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			int i = 0;
			try {
				while ((i = bis.read(b)) != -1) {
					bos.write(b, 0, i);
				}
			} catch (Exception e) {
				// e.printStackTrace();
			} finally {
				if (bos != null)
					bos.close();
				if (bis != null)
					bis.close();

			}
		}
		// return "redirect:list.do";
	}
	
	
	@RequestMapping("/photo/check_pwd_idx_ajax.do")
	@ResponseBody
	public String check_pwd(String pwd,String idx, String type) {
//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
		int res = -1;
		String res_str = null;
//		PrintWriter out = response.getWriter();
//		String pwd = request.getParameter("pwd");
//		String idx = request.getParameter("idx");
//		String type = request.getParameter("type");
	 System.out.println(idx);
	 System.out.println(pwd);
		PhotoVo vo = new PhotoVo(Integer.parseInt(idx), pwd);
		System.out.println("디버그");
		PhotoVo photo_vo = dao.selectOne(vo);
		System.out.println("검색 한 이후");
		if (photo_vo != null) {
			res = 1;
			System.out.println(photo_vo.getFilename());
			System.out.println(photo_vo.getIdx());
		}
		if (type.equals("delete") && res == 1) {
			String web_path = "/resources/image/";
			String save_dir = application.getRealPath(web_path);
			File f = new File(save_dir, photo_vo.getFilename());
			System.out.println(f.delete());
			res = dao.delete(vo);
		}

		if (res == 1) {
			res_str = String.format("[{'result' : '%s'}]", "yes");
		} else
			res_str = String.format("[{'result' : '%s'}]", "no");

		return res_str;
	}
	
	
	@RequestMapping("/photo/modify_form.do")
	public String modify_form(String idx, String pwd,Model model) {
		
		System.out.println("modify_form.do 호출");
		
		PhotoVo one = new PhotoVo(Integer.parseInt(idx), pwd);

		PhotoVo vo = dao.selectOne(one);
		
		System.out.println(vo.getTitle());
		
		model.addAttribute("vo",vo);
		
		return MyConstant.PhotoController.VIEW_PATH +  "modify_form.jsp";
		///2018_0824_SpringPhotoGallery/src/main/webapp/WEB-INF/views/photo/modify_form.jsp
	}
	
	@RequestMapping("/photo/modify.do")
	public String modify(PhotoVo vo) {
		
	 	String web_path = "/resources/image/";
			///2018_0824_SpringPhotoGallery/src/main/webapp/resources/image
	 	
			String save_dir = application.getRealPath(web_path);
			boolean check = false;
			String filename =null;
			
			PhotoVo voo = new PhotoVo();
			voo.setIdx(vo.getIdx());
			voo.setFilename(vo.getBefore_filename());
			check = dao.check2(voo);
			if (check==false) {
				System.out.println("잘못된 데이터입니다.");
				

				return "redirect:list.do?fail=wrongData";

			}
			
			//System.out.println(is_delete);

			if (vo.getIs_delete().equals("yes")) {
				voo = new PhotoVo();
				File f = new File(save_dir, vo.getBefore_filename());
				f.delete();

				
				//f = mr.getFile("photo");
				filename = vo.getPhoto().getOriginalFilename();
				
				//파일 생성
				f = new File(save_dir,filename);
				
				while(f.exists()) {
					int time = (int)System.currentTimeMillis();
					filename = String.format("%d_%s", time,filename);
				}
				
				try {
					vo.getPhoto().transferTo(f);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} else {
				filename = vo.getBefore_filename();
			}

			voo = vo;
			voo.setFilename(filename);
			voo.setIp(request.getRemoteAddr());

			int res = dao.update(voo);
			//System.out.println(res + "수정을 완료합니다.");
			

			//response.sendRedirect("list.do");
		
		return "redirect:list.do?success=modify";
	
		
	}
		
	

}
