package myutil;

public class MyDate2 {
	private int year;
	private int month;
	private int day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int myfunction(int d) {
		d=d-10;
		return d;
	}
	public int getMonth() {
		return this.month;
	}
	
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		day=day-2;
		this.day = day;
	}
	
	public void setDate(int y,int m,int d) {
		year = y;
		month = m;
		day = d;
	}
	public void display() {
		System.out.printf("%d-%02d-%02d\n",year,month,day);
	}
	

}
