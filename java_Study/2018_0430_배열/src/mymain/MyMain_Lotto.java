package mymain;

import java.util.Arrays;
import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		int check;
		int [] user_number = new int[6];
		Lotto lotto = new Lotto();
		Scanner s = new Scanner(System.in);
		
		
		lotto.make_win_number();
		
		
		END:
		while(true)
		{
			System.out.println("번호 6개를 입력");
			AGAIN: for(int i =0; i<6;i++) {
				check = s.nextInt();
				for(int j =0; j<i;j++) {
					if(check == user_number[j]) {
						System.out.println("번호가 중복됩니다. 다른 값으로 다시 입력해주세요.");
						i--;
						continue AGAIN;
					}
				}
				
				
				if(!(check>=0 && check <=45)) {
					System.out.println("치명적인 오류가 발생하셨습니다. 나중에 다시 시도해주세요.");
					break END;
				}
				else user_number[i] = check;
			}
			lotto.setUser_number(user_number);
			lotto.display();

		}
		

	}

}
