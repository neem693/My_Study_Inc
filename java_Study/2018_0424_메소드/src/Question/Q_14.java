package Question;

public class Q_14 {

	public static void main(String[] args) {
		double r = 0;
		double f = 1.0;
		int i =1;
		while(true) {
			if(i>=11)
				break;
			
			
			System.out.print(f);
			if(r!=0)
				System.out.print("/"+i);
			if(i!=9)
				System.out.print("+");
			r += f/i;
			i+=2;
			
			
			
		}
		System.out.print("=");
		System.out.println(r);
	}

}
