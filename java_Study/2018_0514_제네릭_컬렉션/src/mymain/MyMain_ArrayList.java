package mymain;

import java.util.ArrayList;
import java.util.List;

public class MyMain_ArrayList {
	public static void main(String[] args) {
		List<String> fruit_list = new ArrayList<String>();
		
		fruit_list.add("사과");
		fruit_list.add("배");
		fruit_list.add("참외");
		fruit_list.add("수박");
		
		System.out.println("---첨자를 이용한 출력---");
		for(int i =0;i<fruit_list.size();i++) {
			
			String fruit = fruit_list.get(i);
			System.out.printf("%d : %s\n",i,fruit);
			
		}
		System.out.println("---개선 loop 이용한 출력");
		for(String fruit : fruit_list)
			System.out.println(fruit);
		
	}

}
