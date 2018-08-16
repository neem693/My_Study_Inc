package myutil;

import java.util.Random;

public class Bomb {

	int chasu_row, chasu_col, bomb_count;
	int[][] bomb_array;
	Random rand = new Random();

	public void make_bomb() {
		bomb_array = new int[chasu_row + 2][chasu_col + 2];// 하나씩 늘어나기 때문에

		int n = bomb_count; // 지뢰갯수
		while (n > 0) {
			int row = rand.nextInt(chasu_row) + 1;
			int col = rand.nextInt(chasu_col) + 1;
			// 랜덤한 위치에 이미 지뢰가 있으면 다시해라.
			if (bomb_array[row][col] != 0)
				continue;

			bomb_array[row][col] = '*';

			n--;
		}
	}
	
	
	

	public void make_hint_number() {
		for (int i = 1; i <= chasu_row; i++) {
			for (int j = 1; j <= chasu_col; j++) {
				if (bomb_array[i][j] >= '*') {
					bomb_array[i-1][j-1]++;
					bomb_array[i-1][j]++;
					bomb_array[i-1][j+1]++;
					bomb_array[i][j-1]++;
					bomb_array[i][j+1]++;
					bomb_array[i+1][j-1]++;
					bomb_array[i+1][j]++;
					bomb_array[i+1][j+1]++;
				}
			}
		}
		for (int i = 1; i <= chasu_row; i++) {
			for (int j = 1; j <= chasu_col; j++) {
				if (bomb_array[i][j] >= '*') {
					bomb_array[i][j]= '*';

				}
			}
		}
	}

	public void display() {
		for (int i = 1; i <= chasu_row; i++) {
			for (int j = 1; j <= chasu_col; j++) {
				if (bomb_array[i][j] == '*')
					System.out.printf("%3c", bomb_array[i][j]);
				else
					System.out.printf("%3d", bomb_array[i][j]);
			}
			System.out.println();
		}
	}

	public void set(int chasu_row, int chasu_col, int bomb_count) {
		this.chasu_row = chasu_row;
		this.chasu_col = chasu_col;
		this.bomb_count = bomb_count;

		make_bomb();// 지뢰판

		make_hint_number();

	}

}
