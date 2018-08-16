package mymain;


class Test{
	public void sub_instance() {
		System.out.println("--sub_instance()--");
	}
}

class Static_Method
{
	public static void sub_static()
	{
		System.out.println("--sub_static()");
	}
}


public class MyMain_Method {

	
	public static void main(String[] args) {
		Test t = new Test();
		Test t1 = new Test();
		
		t.sub_instance();
		
		Static_Method.sub_static();
		
		

	}

}
