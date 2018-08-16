package Question;

import java.util.Scanner;

public class Q_12 {
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("실수를 입력하세요>>");
		double r = s.nextDouble();
		double fr= r;
		System.out.println(r);

		System.out.print("정수를 입력하세요>>");
		int n = s.nextInt();
		
		for(int i =0; i <n-1;i++) {
			r*=fr;
		
		}
		System.out.println(r);
		
		

	}

}
