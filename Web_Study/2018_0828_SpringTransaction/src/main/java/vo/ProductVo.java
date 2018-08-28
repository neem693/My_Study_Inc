package vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {
	
	SimpleDateFormat output_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	int idx;
	String name;
	int cnt;
	Date regdate;
	
	
	
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
	
	
	public int getCnt() {
		return cnt;
	}
	
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	public String getRegdate() {
		return output_format.format(regdate);
	}
	
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	
}


