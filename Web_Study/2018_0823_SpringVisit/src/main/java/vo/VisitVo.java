package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisitVo {

	//SimpleDateFormat oracle_format = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat string_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat today_format = new SimpleDateFormat("HH:mm:ss");

	int num;
	int idx;
	String name;
	String content;
	String pwd;
	String ip;
	//String regdate;
	Date regdate;

	public VisitVo() {
		// TODO Auto-generated constructor stub
	}

	public VisitVo(int idx, String name, String content, String pwd, String ip, Date regdate) {
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
		String output = null;
		Date today = new Date();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(regdate);
		cal2.setTime(today);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);

		if (sameDay) {
			output = today_format.format(this.regdate);
		} else
			output = string_format.format(this.regdate);

		return output;
	}

	public void setRegdate(Date regdate) {

		
			this.regdate = regdate;
		
		//this.regdate = string_format.format(date);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

}
