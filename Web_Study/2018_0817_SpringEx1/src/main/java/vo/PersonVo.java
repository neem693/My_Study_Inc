package vo;

public class PersonVo {
	String name;
	int age;
	String tel;
	
	public PersonVo() {
		// TODO Auto-generated constructor stub
		System.out.println("--단일변수_빠선VO--");
	}
	
	
	
	
	public PersonVo(String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
		System.out.println("--많은변수_빠선VO--");
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("셋네임");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
