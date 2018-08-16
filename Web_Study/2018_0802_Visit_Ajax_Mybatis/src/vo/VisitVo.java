package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisitVo {

	SimpleDateFormat oralce_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	SimpleDateFormat string_format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat today_format = new SimpleDateFormat("HH:mm:ss");

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
		String output = null;
		Date today = new Date();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date);
		cal2.setTime(today);
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);

		if (sameDay) {
			output = today_format.format(this.date);
		} else
			output = regdate;

		return output;
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
