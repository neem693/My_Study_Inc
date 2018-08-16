package myutil;

public class Mabangjin {

	int chasu;
	int[][] mabangArray;

	public void setChasu(int chasu) {
		this.chasu = chasu;
		// 마방진 구성
		make_mabangjin();
	}

	private void make_mabangjin() {
		mabangArray = new int[chasu][chasu];

		int row = 0;
		int col = chasu / 2; // 정중앙
		int su = 1;

		mabangArray[row][col] = su++;
		for (int i = 0; i < chasu * chasu - 1; i++) {
			// 조건
			// 위 &우축 모두 나갔을 때
			// 대각으로 이동
			row--;
			col++;

			// 위 & 우측 모두 나갔을때 : 이전위치에서 아래쪽으로 이동
			if (row < 0 && col >= chasu) {
				row += 2;
				col--;
			} else if (row < 0) {
				// 위로 나갔을때 : 아래로이동
				row = chasu - 1;
			} else if (col >= chasu) {
				// 우측으로 나갔을때 : 앞으로 이동
				col = 0;
			}
			// 이미 값이 채워졌을때 : 이전위치에서 아래쪽으로 이동
			if (mabangArray[row][col] != 0) {
				row += 2;
				col--;
			}
			// 이동한 위치에 값을 넣는다
			mabangArray[row][col] = su++;

		}
	}

	public void display() {
		int sum_col = 0;
		int[] sum_row = new int[chasu];
		int again = 0;
		for (int i = 0; i < chasu; i++) {
			for (int j = 0; j < chasu; j++) {
				System.out.printf("%4d", mabangArray[i][j]);
				sum_col += mabangArray[i][j];
				sum_row[j] += mabangArray[i][j];
			}
			System.out.printf("|%4d", sum_col);
			System.out.println();
			sum_col = 0;

		}
		while (true) {

			for (int i = 0; i < chasu; i++) {
				if (again==0)
					System.out.printf("%4s", "--");
				else
					System.out.printf("%4d", sum_row[i]);
			}
			
			again ++;
			if(again == 2) {
				break;
			}
			
			System.out.println();

		}
		System.out.println();
		
	}

	public int getChasu() {
		return chasu;
	}
}
