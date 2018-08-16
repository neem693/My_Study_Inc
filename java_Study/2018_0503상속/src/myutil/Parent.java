package myutil;

public class Parent {
	
	protected int parent_money;
	
	public Parent() {
		//생략하면 묵시적으로 super();가 만들어짐
		super();
		parent_money = 1000;
		System.out.println("--Parent()--");
		
	}

	public Parent(int parent_money) {
		super();
		this.parent_money = parent_money;
		System.out.println("--Parent(int a)--");
		
	}
	
	

}
