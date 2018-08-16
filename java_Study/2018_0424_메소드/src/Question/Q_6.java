package Question;

public class Q_6 {

	public static void main(String[] args) {
		System.out.println("정상가격\t세일가격");
		System.out.println("--------------------------------------");
		int normal = 10000;
		double sale=0.0;
		
		for(int i = 0; i<(int)20000/normal *11;i++) {
			sale = (double)normal * 0.7;
			System.out.printf("%d\t%.1f\n",normal,sale);
			normal += 1000;
			
			
		}
	}

}
