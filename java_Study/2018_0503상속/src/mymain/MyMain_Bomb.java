package mymain;

import java.util.Scanner;

import myutil.Bomb;

public class MyMain_Bomb {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int chasu_row,chasu_col,bomb_count;
		System.out.printf("%d",(int)'*');
		
		while(true)
		{
			System.out.println("ÇàÂ÷¼ö ¿­Â÷¼ö Áö·Ú°¹¼ö");
			chasu_row  = scan.nextInt();
			chasu_col = scan.nextInt();
			bomb_count = scan.nextInt();
			
			Bomb bomb = new Bomb();
			bomb.set(chasu_row, chasu_col, bomb_count);
			bomb.display();
			System.out.println();
		}
	}
}
