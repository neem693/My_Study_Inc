package mymain;

import myutil.MyArrayList;

public class MyMain_MyArrayList {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(500);
		list.add(600);
		
		
		System.out.printf("list's size = %d\n",list.size());
		
		try {
			Integer nob = (Integer)list.get(2);
			System.out.println(nob.intValue());
			list.remove(2);
			list.remove(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		list.allget();
		

	}

}
