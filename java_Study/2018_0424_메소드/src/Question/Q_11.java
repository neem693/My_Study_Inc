package Question;

public class Q_11 {

	public static void main(String[] args) {
		double mf = 1.0;
		double result =0.0;
		for(int i =1; i<=100000000;i++) {
			result += mf*(4.0/(2*i-1));
			mf*=-1.0;
		}
		System.out.println(result);

	}

}
