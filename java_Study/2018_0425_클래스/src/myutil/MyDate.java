package myutil;

public class MyDate {
	
	//접근제한자 자료형 변수명;
	private int year;
	protected int month;
	public int day;
	int day_of_year;
	
	
	public void setYear(int y)
	{
		year = y;
	}
	//setter method 라고 한다.
	//즉, 명명법이 있다. 자기가 주고 싶은 데로 주는것이 아니다. set필드명()
	
	

	//year값을 얻어오는 메소드 정의
	public int getYear()
	{
		return year;
	}



	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getDay_of_year() {
		return day_of_year;
	}



	public void setDay_of_year(int day_of_year) {
		this.day_of_year = day_of_year;
	}
	
	
	
	

}
