package vo;

public class GogekVo {
	
	int gobun;
	String goname;
	String goaddr;
	String gojumin;
	int godam;
	public GogekVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GogekVo(int gobun, String goname, String goaddr, String gojumin, int godam) {
		super();
		this.gobun = gobun;
		this.goname = goname;
		this.goaddr = goaddr;
		this.gojumin = gojumin;
		this.godam = godam;
	}


	public int getGobun() {
		return gobun;
	}
	public void setGobun(int gobun) {
		this.gobun = gobun;
	}
	public String getGoname() {
		return goname;
	}
	public void setGoname(String goname) {
		this.goname = goname;
	}
	public String getGoaddr() {
		return goaddr;
	}
	public void setGoaddr(String goaddr) {
		this.goaddr = goaddr;
	}
	public String getGojumin() {
		return gojumin.replaceAll("[0-9]{6,6}$", "******");
	}
	public void setGojumin(String gojumin) {
		
		this.gojumin = gojumin;
	}
	public int getGodam() {
		return godam;
	}
	public void setGodam(int godam) {
		this.godam = godam;
	}
	

}
