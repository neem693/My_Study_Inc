package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

	Random rand = new Random();
	int[] win_number = new int[7];
	int[] user_number;
	int count;// 맞은갯수
	int rank;// 등수

	// 등수계산
	void make_rank() {
		count = 0;
		rank = 0;
		for (int i = 0; i < win_number.length - 1; i++) {
			for (int j = 0; j < user_number.length; j++) {
				if (user_number[j] == win_number[i]) {
					count++;
				}
			}
		}
		switch (count) {

		case 3:
			rank = 5;
			break;
		case 4:
			rank = 4;
			break;
		case 5:
			rank = 3;
			break;
		case 6:
			rank = 1;
			break;
		}
		if (rank == 3)
			for (int i = 0; i < user_number.length; i++)
				if (win_number[6] == user_number[i])
					rank = 2;

	}

	public void setUser_number(int[] user_number) {
		this.user_number = user_number;
		make_rank();
	}

	public void make_win_number() {
		// 1~45
		// 중복 x
		// 보너스번호 추가
		Arrays.fill(win_number, 0);
		int check;
		AGAIN: for (int i = 0; i < win_number.length; i++) {
			check = rand.nextInt(45) + 1;
			for (int j = 0; j < i; j++)
				if (check == win_number[j]) {
					i -= 1;
					continue AGAIN;
				}
			win_number[i] = check;

		}
		Arrays.sort(win_number, 0, 0 + 6);
	}

	public void display() {
		System.out.println("---[추첨결과]---");
		System.out.print("당첨번호: ");
		for (int i = 0; i < win_number.length; i++) {
			if (i == 6)
				System.out.printf(" [%3d]", win_number[i]);
			else
				System.out.printf("%3d", win_number[i]);
		}
		System.out.println();
		Arrays.sort(user_number, 0, 0 + 6);
		System.out.print("유저번호: ");
		for (int i = 0; i < user_number.length; i++) {
			System.out.printf("%3d", user_number[i]);
		}
		System.out.println();
		System.out.printf("맞은갯수: %d(개)\n", count);
		System.out.printf("등수: %d(등)\n", rank);
	}

}
