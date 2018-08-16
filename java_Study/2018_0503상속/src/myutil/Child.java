package myutil;

public class Child extends Parent{
	
	protected int child_money;
	public Child() {
		child_money = 10000;
		System.out.println("--Child()--");
	}
	
	public Child(int parent_money,int child_money) {
		super(parent_money);
		this.child_money = child_money;
		System.out.println("--Child(int p, int c)--");
	}
	
	
	public void diplay_total_money() {
		System.out.printf("아버지(%d)+자식(%d) = 총액(%d)\n",super.parent_money,this.child_money,super.parent_money + this.child_money);
	}

}
