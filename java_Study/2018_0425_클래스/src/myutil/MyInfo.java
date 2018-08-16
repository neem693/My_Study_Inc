package myutil;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyInfo {

	private int year;
	private int month;
	private int current_year;
	private int current_month;

	public MyInfo() {
		Calendar gs = GregorianCalendar.getInstance();
		current_year = gs.get(Calendar.YEAR);
		current_month = gs.get(Calendar.MONTH) +1;
	}
	public int getYear(){	
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getCurrent_year() {
		return current_year;
	}


	

	public int getAge() {
		if(year<100) {
			year += 1900;
		}
		
		return current_year - year;
	}

	public String getZi() {

		String gan="";
		String zi="";

		switch (year % 10) {
		case 4:
			gan = "°©";
			break;
		case 5:
			gan = "À»";
			break;
		case 6:
			gan = "º´";
			break;
		case 7:
			gan = "Á¤";
			break;
		case 8:
			gan = "¹«";
			break;
		case 9:
			gan = "±â";
			break;
		case 0:
			gan = "°æ";
			break;
		case 1:
			gan = "½Å";
			break;
		case 2:
			gan = "ÀÓ";
			break;
		case 3:
			gan = "°è";
			break;
		}
		switch (year % 12) {
		case 4:
			zi = "ÀÚ";
			break;
		case 5:
			zi = "Ãà";
			break;
		case 6:
			zi = "ÀÎ";
			break;
		case 7:
			zi = "¹¦";
			break;
		case 8:
			zi = "Áø";
			break;
		case 9:
			zi = "»ç";
			break;
		case 10:
			zi = "¿À";
			break;
		case 11:
			zi = "¹Ì";
			break;
		case 0:
			zi = "½Å";
			break;
		case 1:
			zi = "À¯";
			break;
		case 2:
			zi = "¼ú";
			break;
		case 3:
			zi = "ÇØ";
			break;
		}
		return gan.concat(zi);
	}
	
	public String getTti() {
		String zi ="";
		switch (year % 12) {
		case 4:
			zi = "Áã";
			break;
		case 5:
			zi = "¼Ò";
			break;
		case 6:
			zi = "È£¶ûÀÌ";
			break;
		case 7:
			zi = "Åä³¢";
			break;
		case 8:
			zi = "µå·¡°ï";
			break;
		case 9:
			zi = "¹ì";
			break;
		case 10:
			zi = "¸»";
			break;
		case 11:
			zi = "¾ç";
			break;
		case 0:
			zi = "¿ø¼þÀÌ";
			break;
		case 1:
			zi = "´ß";
			break;
		case 2:
			zi = "°³";
			break;
		case 3:
			zi = "µÅÁö";
			break;
		}
		zi.concat("¶ì");
		return zi;
	}

}
