package mymain;

import java.lang.reflect.Array;
import java.util.Arrays;

import myutil.MyArrays;

public class MyMain_ArrayCopy {

	public static void main(String[] args) {
		int [] src = {1,2,3,4,5};
		int [] dest = new int[10];
		
		MyArrays.copy_array(src, 1, dest, 2, 3);
		MyArrays.display_array(dest);
		Arrays.fill(dest, 0);
		System.arraycopy(src, 1, dest, 2, 3);
		MyArrays.display_array(dest);
		

	}

}
