package Question;

public class Q_10 {
	

	public static void main(String[] args) {
		System.out.print("1부터 10까지의 짝수의 곱 : ");
		int result=1;
		for(int i=1; i<=10;i++) {
			if(i%2==0)
				result*=i;
			else
				continue;
		}
		System.out.println(result);
		
				
			

	}

}
