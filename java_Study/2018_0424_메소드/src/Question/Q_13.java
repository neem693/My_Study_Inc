package Question;

import java.io.IOException;
import java.util.Scanner;

public class Q_13 {
	// 알파벳 이 몇개, 숫자가 몇개, 화이트 문자가 몇개(\t,\r,\n, ' '(스페이스바)), 특수 기호가 몇개
	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);

		int str;
		int alph = 0;
		int number = 0;
		int white = 0;
		int special = 0;
		System.out.println("데이터를 입력하세요. 끝내려면 [CTRL] + Z를 누르세요");
		while (true) {
			str = System.in.read();
			if (str == -1)
				break;
			System.out.printf("%c", str);

			if (str >= 65 && str <= 90 || str >= 97 && str <= 122)
				alph++;
			else if (str >= 48 && str <= 57)
				number++;
			else if (str >= 33 && str <= 47 || str >= 58 && str <= 64 || str >= 91 && str <= 96
					|| str >= 123 && str <= 126)
				special++;
			else if (str == 13 || str == 10 || str == 32 || str == 9)
				white++;
		}
		System.out.println("알파벳 숫자:" + alph);
		System.out.println("숫자: " + number);
		System.out.println("화이트 문자:" + white);
		System.out.println("특수 기호:" + special);

	}

}
