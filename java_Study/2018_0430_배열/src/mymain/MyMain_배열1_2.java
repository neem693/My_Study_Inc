package mymain;

import myutil.MyArrays;

public class MyMain_배열1_2 {

	public static void main(String[] args) {
		
		//int [] mr = new int [] {10,20,30,40,50};
		int [] mr = {20,30,40,10,50};

		MyArrays.display_array(mr);
		
		String [] tti_array = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","개","돼지"};
		String [] gan_array = {"경","신","임","계","갑","을","병","정","무","기"};
		String [] ji_array = {"신","유","술","해","자","축","인","묘","진","사","오","미"};
		
		
		MyArrays.display_array(gan_array);
		
		int year = 1980;
		
		
		int tti_index = 1980%12;
		String tti = tti_array[tti_index];
		System.out.println(tti);
		String ganji = String.format("%s%s년",gan_array[year%10],ji_array[year%12]);
		System.out.printf("%d년도(%s)\n",year,ganji);
		
		//기본배열변수에 새로운 배열객체를 초기화 형태로 생성시 아래방법
		System.out.println("---before sort---");
		MyArrays.display_array(mr);
		

		
		System.out.println("---after sort(asc)---");
		MyArrays.sort_asc(mr);
		MyArrays.display_array(mr);
		
		
		System.out.println("---after sort(desc)---");
		MyArrays.sort_desc(mr);
		MyArrays.display_array(mr);
	
	}
}
