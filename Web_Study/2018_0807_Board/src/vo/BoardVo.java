package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BoardVo {

	int idx, readhit, ref, step, depth,no,del,c_count;
	String id, name, subject, content, pwd, ip, regdate, viewdate;
	Date date;


	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat outputFormat_today = new SimpleDateFormat("HH:mm:ss");
	SimpleDateFormat viewOutputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(String id, String name, String subject, String content, String pwd, String ip) {
		super();

		this.id = id;
		this.name = name;
		this.subject = subject;
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

	public int getReadhit() {
		return readhit;
	}

	public void setReadhit(int readhit) {
		this.readhit = readhit;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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
		String time = null;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(this.date);
		cal2.setTime(new Date());
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		if (sameDay)
			time = outputFormat_today.format(date);
		else
			time = outputFormat.format(date);
		time = time.replaceAll("\n", "<br>");
		// System.out.println(time);

		return time;
	}

	public void setRegdate(String regdate) {
		try {
			this.date = inputFormat.parse(regdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setViewdate(viewOutputFormat.format(date));
		this.regdate = regdate;
	}

	public String getViewdate() {
		return viewdate;
	}

	public void setViewdate(String viewdate) {
		this.viewdate = viewdate;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getC_count() {
		return c_count;
	}

	public void setC_count(int c_count) {
		this.c_count = c_count;
	}
	
	


}
