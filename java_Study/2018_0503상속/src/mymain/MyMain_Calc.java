package mymain;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_Calc {
	
	static void use_only_basecalc(BaseCalc bc)
	{
		int x =10, y= 5,z;
		z=bc.plus(x, y);
		System.out.printf("use_only_basecalc : %d\n",z);
	}
	
	static void use_only_object(Object ob)
	{
		int a =10,b=5,c;
		c=((BaseCalc)ob).plus(a,b);
		System.out.println(c);
	}
	

	public static void main(String[] args) {
		
		int a=10,b=5,result;
		
		AdvanceCalc ac = new AdvanceCalc();
		BaseCalc bc = new AdvanceCalc();
		AdvanceCalc gc = (AdvanceCalc)bc;
		result = ac.plus(a, b);
		System.out.printf("%d + %d = %d\n",a,b,result);
		
		result = ac.hap(a);
		System.out.printf("1 ~ %d±îÁö ÇÕ: %d\n",a,result);
		
		result = ac.pow(a, b);
		System.out.printf("%d's %d½Â	 : %d\n",a,b,result);
		
		use_only_basecalc(ac);
		use_only_object(ac);
		
	}
}
