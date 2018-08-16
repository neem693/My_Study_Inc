package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MemberVo {

	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년MM월dd일\nHH시mm분ss초");
	SimpleDateFormat outputFormat_today = new SimpleDateFormat("HH시mm분ss초");

	int idx;
	String name, id, pwd, zipcode, addr, ip, regdate;
	Date date;

	public MemberVo() {
		// TODO Auto-generated constructor stub

	}

	/* 수정용 */
	public MemberVo(int idx, String name, String id, String pwd, String zipcode, String addr, String ip) {
		super();
		this.idx = idx;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.zipcode = zipcode;
		this.addr = addr;
		this.ip = ip;
	}

	/* 인서트 용 */
	public MemberVo(String name, String id, String pwd, String zipcode, String addr, String ip) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.zipcode = zipcode;
		this.addr = addr;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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

		this.regdate = regdate;
	}

}
