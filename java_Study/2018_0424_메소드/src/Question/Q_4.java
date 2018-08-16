
package Question;

import java.util.Scanner;

public class Q_4 {

	public static void main(String[] args) {
		int a,b;
		String str;
		char result;
		System.out.print("두 정수와 *,-,+,/ 중 하나의 연산자를 입력하세요. >>");
		Scanner s = new Scanner(System.in);
		a= s.nextInt();
		b= s.nextInt();
		str= s.next();
		if(str.length()>1) {
			System.out.print("잘못입력하셨습니다.");
			return;
		}
		
		if(str.equals("*"))
			System.out.println(a*b);
		else if(str.equals("-"))
			System.out.println(a-b);
		else if(str.equals("+"))
			System.out.println(a+b);
		else if(str.equals("/"))
			System.out.println(a/b);

		
		
		
		
		
	}

}
