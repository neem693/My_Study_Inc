package Question;



public class Q_8 {
	public static int sum(int n) {
		int result =0;
		for(int i =0; i<=n; i++)
			result +=i;
		return result;
		
	}

	public static void main(String[] args) {
		System.out.println("정수값\t1부터 n까지의 합");
		System.out.println("-----------------------");
		for(int i =1; i<=5; i++) {
			System.out.println(i+"\t"+sum(i));
		}
	}

}
