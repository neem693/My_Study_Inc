package mymain;

import java.util.ArrayList;

public class MyMain_ArrayList {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		System.out.printf("list's size = %d\n",list.size());
		
		
		list.add(100);
		list.add(200);
		list.add(300);
		
		
		System.out.printf("list's size = %d\n",list.size());
		
		list.remove(1);//2번째 요소 삭제
		System.out.printf("list's size = %d\n",list.size());
		
		
		int n = (int)list.get(0);
		//((Integer)list.get(0)).intValue()
		System.out.println(n);
		
		

	}

}
