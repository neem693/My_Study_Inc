package mymain;

import java.util.Calendar;
import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_달력 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		//Calendar는 이렇게 밖에 생성을 못한다.
		
		int year = 2018;
		int month = 5;
		
		//내가 원하는 날짜로 수정
		
		c.set(year, month-1,1);
		//0베이스 부터 하기 달력 -1을 해야 한다.
		
		int yoil = c.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d-%d-%d 요일 : %d\n",year,month,1,yoil);
		
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			System.out.print("년  월 : ");
			year = s.nextInt();
			month = s.nextInt();
			
			if(year>=9999 || month >12) {
				System.out.println("치명적인 오류가 발생하였습니다. 종료하겠습니다.");
				break;
			}
			
			mc.setDate(year, month);
			mc.display();
		}

	}

}
