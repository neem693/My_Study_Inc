package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_PersonList {

	public static void main(String[] args) {
		PersonVo p = new PersonVo("일갈동",20,"서울 관안구");
		System.out.println(p.toString());
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		PersonVo p1 = new  PersonVo("이길동", 20, "서울 도봉구");
		
		p_list.add(p);
		p_list.add(p1);
		p_list.add(new PersonVo("삼길동", 21, "서울 구로구"));
		p_list.add(new PersonVo("사길동", 22, "서울 노원구"));
		p_list.add(new PersonVo("오길동", 23, "서울 동대문구"));
		
		System.out.println("---첨자를 이용한 방법---");
		
		
		for(int i =0;i<p_list.size();i++) {
			PersonVo pp = p_list.get(i);
			System.out.println(pp);
			//toString이 자동으로 호출 됨
		}
		System.out.println("---개선 루프를 이용한 방법 ---");
		for(PersonVo pp : p_list)
			System.out.println(pp);
		

	}

}
