package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MyMain_Set_Test {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		//인터페이스(사용메뉴얼)			설계서
		Set<Integer> set_lotto = new HashSet<Integer>();
		//Set<Integer> set_lotto = new TreeSet<Integer>();
		
		
		int n =6;
		while(n>0)
		{
			int su = rand.nextInt(45) + 1; //1~45
			//중복값 허용을 하지않기 때문에
			//동일 값이 들어가면 add실패함
			if(set_lotto.add(su)==false)continue;
			n--;
		}
		System.out.println(set_lotto.toString());
		
		System.out.println("----개선 loop ----");
		for(Integer nob : set_lotto)
			System.out.println(nob);//toString 이용
		
		System.out.println("---Iterator 이용----");
		Iterator<Integer> it = set_lotto.iterator(); 
		
		while(it.hasNext()) {
			Integer nob2 = it.next();//현재값 가져오기
			System.out.println(nob2);
		}
		
		

	}

}
