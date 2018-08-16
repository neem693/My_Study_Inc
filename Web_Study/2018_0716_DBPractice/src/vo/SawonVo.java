package vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SawonVo {

	SimpleDateFormat in_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	SimpleDateFormat out_format = new SimpleDateFormat("yyyy-MM-dd");

	int sabun;
	String saname;
	String sasex;
	String deptno;
	String sajob;
	Date sahire;
	int samgr;
	int sapay;

	public SawonVo(int sabun, String saname, String sasex, String deptno, String sajob, Date sahire, int samgr,
			int sapay) {
		super();
		this.sabun = sabun;
		this.saname = saname;
		this.sasex = sasex;
		this.deptno = deptno;
		this.sajob = sajob;
		this.sahire = sahire;
		this.samgr = samgr;
		this.sapay = sapay;
	}

	public SawonVo() {
		// TODO Auto-generated constructor stub
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getSaname() {
		return saname;
	}

	public void setSaname(String saname) {
		this.saname = saname;
	}

	public String getSasex() {
		return sasex;
	}

	public void setSasex(String sasex) {
		this.sasex = sasex;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getSajob() {
		return sajob;
	}

	public void setSajob(String sajob) {
		this.sajob = sajob;
	}

	public String getSahire() {
		return out_format.format(sahire);
	}

	public void setSahire(String str_date) {
		Date sahire = null;
		try {
			sahire = in_format.parse(str_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sahire = sahire;
	}

	public int getSamgr() {
		return samgr;
	}

	public void setSamgr(int samgr) {
		this.samgr = samgr;
	}

	public int getSapay() {
		return sapay;
	}

	public void setSapay(int sapay) {
		this.sapay = sapay;
	}

}
