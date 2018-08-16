package Question;

import java.util.Scanner;

public class Q_2 {

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		System.out.print("세 개의 정수를 입력하세요. >>");
		int o = s.nextInt();
		int t = s.nextInt();
		int th = s.nextInt();
		System.out.println("수 : " + o + " " + t + " " + th );
		System.out.print("세 개의 정수 중에서 가장 작은 값 : ");
		System.out.println(Math.min(o,Math.min(t, th)));
		
		
		

	}

}
