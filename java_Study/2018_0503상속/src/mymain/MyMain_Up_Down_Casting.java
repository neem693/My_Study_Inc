package mymain;

import java.util.ArrayList;

public class MyMain_Up_Down_Casting {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("사과");
		list.add("참외");
		list.add("수박");
		
		//값을 얻어와서 사용시에는 down-casting 해야 된다.
		String fruit = (String)list.get(0);
		
		
		System.out.println("개선 루프를 돌리자/사과 삭제");
		
		list.remove(0);
		
		
		for(int i =0;i<list.size();i++) {
			String f = (String)list.get(i);
			System.out.println(f);
			System.out.println();
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//이렇게 쓰면 String에 있던 toStirng()메소드가 오버라이드 되서 Object로 출력이 되더라도 String에 있는 toStirng()메소드이다.
		
		System.out.println();
		
		for(Object ob : list) {
			System.out.println((String)ob);
		}
		

	}

}
