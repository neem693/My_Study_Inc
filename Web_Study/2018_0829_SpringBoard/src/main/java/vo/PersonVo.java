package vo;

import java.util.Date;

public class PersonVo {
	
	String id,name,pwd;
	Date date;
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PersonVo(String id, String name, String pwd, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.date = date;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
