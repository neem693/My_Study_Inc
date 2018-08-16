package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jumin jumin = new Jumin();
		Scanner scan = new Scanner(System.in);
		//키보드로부터 입력받는다
		String jumin_no="801212-1234560";
		
		
		while(true)
		{
			System.out.print("주민번호(xxxxxx-xxxxxxx):");
			jumin_no = scan.next();
			
			jumin.setJumin_no(jumin_no);
			
			int year = jumin.getYear();//출생년도 
			int age  = jumin.getAge();//나이
			String tti= jumin.getTti();//띠
			String season = jumin.getSeason();//계절
			String local = jumin.getLocal();//지역
			String ganji = jumin.getZi();//간지
			String sex = jumin.getSex();//성별
			
			System.out.println("---[결과]---");
			System.out.printf("출생년도:%d(%s년) 당신은 %d살 이네요\n", year,ganji,age);
			System.out.printf("출생계절:%s\n", season);
			System.out.printf("출생지역:%s\n",local);
			System.out.printf("당신의성별: %s\n",sex);
			System.out.printf("당신의띠: %s\n",tti);
			
			
			System.out.print("계속 할거에요? y/n>>");
			String again = scan.next();
			if(again.equalsIgnoreCase("y"))
				continue;
			else
				break;
			
			
			
			
		
		}
		scan.close();
		
		
		

	}

}
