package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyMain_마방진 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int chasu;
		Mabangjin mabangjin = new Mabangjin();
		
		while(true) {
			System.out.print("차수");
			chasu = s.nextInt();
			
			if(chasu%2==0) {
				System.out.println("홀수만 입력하세요");
				continue;
			}
			mabangjin.setChasu(chasu);
			mabangjin.display();
		}
	}
}
