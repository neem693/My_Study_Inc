package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import vo.PersonVo;

public class MyMain_MapTest {

	public static void main(String[] args) {
		
		Map<Integer,String> telMap = new HashMap<Integer,String>();
		
		telMap.put(1,"010-111-1234");
		telMap.put(2,"010-222-1234");
		telMap.put(3,"010-333-1234");
		
		int short_num =1;
		String tel = telMap.get(short_num);
		
		telMap.put(1, "010-999-9999");//다시 저장
		
		System.out.printf("단축번호 %d : %s\n", short_num,tel);
		
		Set<Integer> keySet = telMap.keySet();
		
		System.out.println("---key 집합---");
		for(int key : keySet)
			System.out.println(key);
		System.out.println("사이즈 : " + telMap.size());
		System.out.println("---Value 집합---");
		for(int i =1; i<=telMap.size();i++)
			System.out.println(telMap.get(i));
		
		

	}

}
