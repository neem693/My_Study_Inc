package Question;

import java.util.Scanner;

public class Q_5 {

	public static void main(String[] args) {
		System.out.print("문자 한 개를 입력하세요");
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		if(str.length()>1) {
			System.out.print("잘못입력하셨습니다.");
			return;
		}
		
		str = str.toUpperCase();
		
		if(str.charAt(0) ==65) {
			System.out.println("Afghanistan");
		}
		else if(str.charAt(0) ==66) {
			System.out.println("Bahamas, The");
		}
		else if(str.charAt(0) ==67) {
			System.out.println("Cambodia");
		}
		else if(str.charAt(0) ==68) {
			System.out.println("Denmark");
		}
		else if(str.charAt(0) ==69) {
			System.out.println("Ecuador");
		}
		else if(str.charAt(0) ==70) {
			System.out.println("Fiji");
		}
		else if(str.charAt(0) ==71) {
			System.out.println("Gabon");
		}
		else if(str.charAt(0) ==72) {
			System.out.println("Haiti");
		}
		else if(str.charAt(0) ==73) {
			System.out.println("Iceland");
		}
		else if(str.charAt(0) ==74) {
			System.out.println("Jamaica");
		}
		else if(str.charAt(0) ==75) {
			System.out.println("Kazakhstan");
		}
		else if(str.charAt(0) ==76) {
			System.out.println("Laos");
		}
		else if(str.charAt(0) ==77) {
			System.out.println("Macau");
		}
		else if(str.charAt(0) ==78) {
			System.out.println("Namibia");
		}
		else if(str.charAt(0) ==79) {
			System.out.println("Oman");
		}
		else if(str.charAt(0) ==80) {
			System.out.println("Pakistan");
		}
		else if(str.charAt(0) ==81) {
			System.out.println("Qatar");
		}
		else if(str.charAt(0) ==82) {
			System.out.println("Romania");
		}
		else if(str.charAt(0) ==83) {
			System.out.println("Saint Kitts and Nevis");
		}
		else if(str.charAt(0) ==84) {
			System.out.println("Taiwan");
		}
		else if(str.charAt(0) ==85) {
			System.out.println("Uganda");
		}
		else if(str.charAt(0) ==86) {
			System.out.println("Vanuatu");
		}
		else if(str.charAt(0) ==89) {
			System.out.println("Yemen");
		}
		else if(str.charAt(0) ==90) {
			System.out.println("Zambia");
		}
		else {
			System.out.println("문제발생");
		}
		
		
		
		
		
		

	}

}
