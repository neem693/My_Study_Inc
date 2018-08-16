package mymain;

import java.util.Arrays;

import vo.PersonComp;
import vo.PersonVo;

public class MyMain_ArraySort {

	public static void main(String[] args) {
		
		PersonVo[] p_array = {
				
				new PersonVo("라갈동",32,"서울 구로구"),
				new PersonVo("마갈동",22,"서울 구로구"),
				new PersonVo("다갈동",52,"서울 구로구"),
				new PersonVo("나갈동",42,"서울 구로구"),
				new PersonVo("가갈동",28,"서울 구로구"),
				new PersonVo("바갈동",27,"서울 구로구"),
				new PersonVo("하갈동",39,"서울 구로구"),
				
		};
		
		System.out.println("---before sort---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		//Arrays.sort(p_array);//객체를 가지고 소팅을 할 때는 기준이 없기에 에러가 난다.
		
		//정렬의 기준을 설정할 객체 생성
		
		
		PersonComp com = new PersonComp();
		Arrays.sort(p_array, com);
		System.out.println("---after sort : 기본값 이름순 오름차순---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		
		//나이순 오름차순
		com.setSort_field(PersonComp.SORT_FIELD_AGE);
		
		Arrays.sort(p_array, com);
		
		System.out.println("---after sort : 나이순 오름차순 ---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		System.out.println("---after sort : 이름순 내림차순---");
		com.setSort_field(PersonComp.SORT_FIELD_NAME);
		com.setSort_type(com.SORT_TYPE_DESC);
		Arrays.sort(p_array, com);
		
		for(PersonVo p : p_array)
			System.out.println(p);
		
		

	}

}
