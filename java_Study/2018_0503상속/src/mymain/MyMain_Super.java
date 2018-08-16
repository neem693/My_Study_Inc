package mymain;

import myutil.Child;

public class MyMain_Super {

	public static void main(String[] args) {
		
		Child child = new Child();
		child.diplay_total_money();
		
		Child child2 = new Child(100000,200000);
		child2.diplay_total_money();

	}

}
