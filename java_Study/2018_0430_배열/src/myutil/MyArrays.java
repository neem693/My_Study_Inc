package myutil;

public class MyArrays {
	
	
	
	public static void copy_array(int [] src,int src_index,int[] dest,int dest_index,int dest_length) {
		
		for(int i = 0; i<dest_length;i++) {
			dest[dest_index + i] = src[src_index + i];
		}
	}

	public static void display_array(int[] mr) {
		System.out.printf("[");
		for (int i = 0; i < mr.length; i++)
			System.out.printf("%3d", mr[i]);
		System.out.println(" ]");
	}

	public static void display_array(String[] mr) {
		System.out.print("[");
		for (int i = 0; i < mr.length; i++)
			System.out.printf("%5s", mr[i]);
		System.out.println(" ]");
	}

	public static void sort_asc(int[] mr) {
		int temp;
		for (int i = 0; i < mr.length - 1; i++) {
			for (int j = i + 1; j < mr.length; j++) {
				if (mr[i] > mr[j]) {
					temp = mr[i];
					mr[i] = mr[j];
					mr[j] = temp;
				}
			}
		}
	}

	public static void sort_desc(int[] mr) {
		int temp;
		for (int i = 0; i < mr.length - 1; i++) {
			for (int j = i + 1; j < mr.length; j++) {
				if (mr[i] < mr[j]) {
					temp = mr[i];
					mr[i] = mr[j];
					mr[j] = temp;
				}
			}
		}
	}

	public static void set_array2(int[][] m2) {
		int su = 1;
		int rows = m2.length;
		for (int i = 0; i < rows; i++) {
			int cols = m2[i].length;
			for (int j = 0; j < cols; j++)
				m2[i][j] = su++;
		}
	}

	public static void display_array2(int[][] m2) {
		for (int g[] : m2) {
			for (int r : g) {
				System.out.printf("%3d", r);
			}
			System.out.println();
		}
	}

	public static void display_array2_block(int[][] m2) {
		for (int i = 0; i < m2.length; i++) {
			for (int j = 0; j < m2[i].length; j++) {
				if (m2[i][j] == 1)
					System.out.printf("%s", "¢Ë");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static int[][] rotate_right_90(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = mm[last_index - j][i];
			}
		}

		return dest;
	}

	public static int[][] rotate_left_90(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = mm[j][last_index - i];
			}
		}

		return dest;

	}

	public static int[][] flip_left_right(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = mm[i][last_index - j];
			}
		}
		return dest;
	}

	public static int[][] flip_up_down(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				dest[i][j] = mm[last_index - i][j];
			}
		}
		return dest;
	}

	public static int[][] flip_diagonal2(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				if(i==j)
				dest[i][j] = mm[i][j];
				else dest[i][j] = mm[j][i];
			}
		}
		return dest;
	}
	
	public static int[][] flip_diagonal1(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				if((i+j) ==last_index)
				dest[i][j] = mm[i][j];
				else dest[i][j] = mm[last_index -j][last_index-i];
			}
		}
		return dest;
	}
	public static int[][] cross_flip_diagonal(int[][] mm) {
		int[][] dest = new int[mm.length][mm[0].length];
		int last_index=mm.length-1;
		for (int i = 0; i < dest.length; i++) {
			for (int j = 0; j < dest[i].length; j++) {
				if(i==j||((i+j) ==last_index))
				dest[i][j] = mm[i][j];
				else dest[i][j] = mm[last_index-i][last_index-j];
			}
		}
		return dest;
	}
	
	
}