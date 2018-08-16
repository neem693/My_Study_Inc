package mymain;

import java.util.ArrayList;

public class MyMain_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 10;
		Integer nOb = new Integer(n);
		//이걸 박싱이라고 한다.
		Integer nOb1 = n;
		
		int n1 = nOb.intValue();
		//언 박싱이라고 한다.
		int n2 = nOb;
		
		float f =nOb; //nOb.floatValue()
		double d = nOb; //nOb.doubleValue()
		//두개다 언박싱이다.
		
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(new Integer(10));
		

	}

}
