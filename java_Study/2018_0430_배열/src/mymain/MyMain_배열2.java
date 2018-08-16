package mymain;

import myutil.MyArrays;

public class MyMain_배열2 {
	
	
	

	public static void main(String[] args) {
		
		int [][] mm = new int[3][4];
		MyArrays.set_array2(mm);
		MyArrays.display_array2(mm);
		
		int [][] mm2 = new int[3][];
		System.out.println("--가변길이 배열--");
		mm2[0] = new int[] {1,2};
		mm2[1] = new int[] {3,4,5};
		mm2[2] = new int[] {6,7,8,9};
		
		MyArrays.display_array2(mm2);
		
	}

}
