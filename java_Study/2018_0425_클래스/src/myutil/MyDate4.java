package myutil;


public class MyDate4 {

	int year,month,day;
	
	public void display_this() {
		System.out.printf("클래스 내부에서 확인한 this: %s\n", this);
	}
	
	
	public MyDate4(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}



	public MyDate4(int year, int month) {
		super();
		this.year = year;
		this.month = month;
	}



	public MyDate4(int year) {
		super();
		this.year = year;
	}

	public MyDate4() {
		super();
	}


	



}
