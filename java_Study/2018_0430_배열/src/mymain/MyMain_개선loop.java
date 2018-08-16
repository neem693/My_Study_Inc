package mymain;

public class MyMain_개선loop {

	public static void main(String[] args) {
		String [] fruit_array = new String [] {
				new String("사과"),
				new String("참외"),
				"수박"
		};
		String [] fruit_array2 = {"사과","참외","수박"};
		
		System.out.println("--개선 Loop--");
		
		for(String fruit : fruit_array)
			System.out.println(fruit);

	}

}
