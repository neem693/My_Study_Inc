package mymain;

import inter.BaseCalc;
import inter.BaseCalcImpl;

public class MyMain_BaseCalc {

	public static void main(String[] args) {
		
		BaseCalc calc = new BaseCalcImpl();
		
		
		int a = 10, b=5,c;
		
		c = calc.plus(a, b);
		
		System.out.printf("%d + %d = %d\n",a,b,c);

	}

}
