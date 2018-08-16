package mymain;

import myutil.MySingleTon;

public class MyMain_Singleton {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			MySingleTon singleton = MySingleTon.getInstance();
			int res = singleton.plus(i, i);
			System.out.printf("%d + %d = %d\n", i, i, res);
		}
	}

}
