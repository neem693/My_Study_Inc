package mymain;

import myutil.MyDate;
import myutil.MyDate2;

public class MyMain1 {

	public static void main(String[] args) {
		MyDate md1 = new MyDate();
		MyDate in = new MyDate();
		MyDate2 md2 = new MyDate2();
		
		
		
		md1.day = 25;
		md1.setYear(2018);
		int year = md1.getYear();
		
		md2.display();
		
		md2.setDate(2018,4,25);
		md2.display();
		
		
		
		
	}

}
