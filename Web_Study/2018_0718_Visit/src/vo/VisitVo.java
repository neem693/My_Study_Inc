package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class VisitVo {
	
	SimpleDateFormat oralce_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	SimpleDateFormat string_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	Date date;
	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}




	










	public VisitVo(int idx, String name, String content, String pwd, String ip, String regdate) {
		super();
		this.idx = idx;
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
		this.regdate = regdate;
	}















	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}






	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {

		try {
			this.date = oralce_format.parse(regdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.regdate = string_format.format(date);
	}


	

}
