package mymain;

public class MyMain_Elipsis {
	
	static void int_elipsis(int...nr)
	{
		System.out.print("elipsis : ");
		for(int i=0;i<nr.length; i++)
			System.out.print(nr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int_elipsis(10);
		int_elipsis(10,20);
		int_elipsis(10,20,30);
		
		

	}

}
