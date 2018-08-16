package mymain;

import myutil.MyArrays;

public class MyMain_2차원문제 {

	public static void main(String[] args) {
		int [][] mm  =new int [5][5];
		
		MyArrays.set_array2(mm);
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.rotate_right_90(mm);
		System.out.println("--[우 90도 돌린 후]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm);
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.rotate_left_90(mm);
		System.out.println("--[좌 90도 돌린 후]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm);
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_left_right(mm);
		System.out.println("--[왼쪽으로 뒤집기]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_up_down(mm);
		System.out.println("--[위에서 아래로 돌린 후]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_diagonal2(mm);
		System.out.println("--[왼쪽 대각선 돌린 후]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_diagonal1(mm);
		System.out.println("--[오른쪽 대각선으로 돌린 후]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[원본]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.cross_flip_diagonal(mm);
		System.out.println("--[오른쪽 왼쪽 모두 대각선으로 돌린 후]--");
		MyArrays.display_array2(mm);
		}

}
