package mymain;

import java.util.Scanner;

import myutil.MyInfo;

public class MyMain_MyInfo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		
		MyInfo info = new MyInfo();
		
		int year,month;
		String yn = "";
		System.out.print("월을 입력하라>>");
		month = s.nextInt();
		info.setMonth(month);
		
		while(true) {
			System.out.print("출생년도>>");
			year = s.nextInt();

			info.setYear(year);
			int age = info.getAge()	;
			String tti = info.getTti();
			String ganzi = info.getZi();
			
			
			//결과출력
			System.out.println("--------------------------");
			System.out.printf("년도 : %d(%s년)\n",year,ganzi);
			System.out.printf("나이 : %d(살)\n",age+1);
			System.out.printf("띠    : %s\n",tti);
			System.out.println("--------------------------");
			
			System.out.print("또(y/n):");
			yn = s.next();
			
			if(yn.equalsIgnoreCase("y")== false)break;
			
			

		}
		s.close();
	}
}
