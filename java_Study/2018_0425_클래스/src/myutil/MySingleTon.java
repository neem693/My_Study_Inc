package myutil;

public class MySingleTon {
	
	static MySingleTon single =null;
	
	public static MySingleTon getInstance()
	{
		if(single == null)single = new MySingleTon();
		return single;
	}
	
	
	public MySingleTon() {
		System.out.println("---MySingleTon()---");
	}
	
	public int plus(int a,int b) {
		return a+b;
	}
	

}
