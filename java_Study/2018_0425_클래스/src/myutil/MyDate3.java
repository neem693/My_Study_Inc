package myutil;

import java.util.Calendar;

public class MyDate3 {
	int year;
	int month;
	int day;
	
	public void display_this() {
		System.out.println(this);
	}
	
	public MyDate3()
	{
		
		Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) +1;
		this.day = c.get(Calendar.DAY_OF_MONTH);
		
	}
	
	public MyDate3(int y)
	{
		this();
		year =y;
		
	}
	public MyDate3(int y, int m) {
		this(y);
		month = m;
	}
	public MyDate3(int y, int m, int d)
	{
		this(y,m);
		day = d;
	}
	
	public void display() {
		System.out.printf("%d³â %d¿ù %dÀÏ\n",year,month,day);
	}
	
	

}
