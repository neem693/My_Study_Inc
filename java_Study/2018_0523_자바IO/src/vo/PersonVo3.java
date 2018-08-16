package vo;

import java.io.Serializable;

public class PersonVo3 implements Serializable {
	
	String name;
	transient int age; //직렬화 제외
	String addr;
	
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("[%s, %d, %s]", name,age,addr);
		return str;
	}
	
	public PersonVo3(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}
