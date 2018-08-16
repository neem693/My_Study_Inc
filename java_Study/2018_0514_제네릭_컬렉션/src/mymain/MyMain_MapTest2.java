package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_MapTest2 {

	public static void main(String[] args) {
		
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		for(int i =1;i<=100;i++) {
			String name = String.format("길동%d", i);
			int age = 20 + i %10;
			String addr = String.format("서울시 구로구 구로%d동", 1 + i%3);
			PersonVo p = new PersonVo(name,age,addr);
			p_list.add(p);
		}
		
		System.out.printf("현재 인원수 : %d\n", p_list.size());
		
		//길동 100의 정보를 검색 : ArrayList 순차검색
		int search_count =0;
		for(PersonVo p : p_list) {
			search_count++;
			if(p.getName().equals("길동100")) {
				System.out.println(p);
				break;
			}
		}
		System.out.printf("검색횟수: %d\n",search_count);
		Map<String,PersonVo> personMap = new HashMap<String,PersonVo>();
		for(int i =1;i<=100;i++) {
			String name = String.format("길동%d", i);
			int age = 20 + i %10;
			String addr = String.format("서울시 구로구 구로%d동", 1 + i%3);
			PersonVo p = new PersonVo(name,age,addr);
			personMap.put(name, p);
		}
		PersonVo pp = personMap.get("길동100");
		System.out.println("검색횟수 한번");

		System.out.println(pp);

	}

}
