package myutil;

public class MyMath {
	
	private MyMath() {
		// TODO Auto-generated constructor stub
	}
	static public int plus(int a, int b) {
		return a+b;
	}
	
	public static void sosu(int n) {
		
		for(int i = 2; i<=n; i++) {
			for(int j = 2; j<=i; j++) {
				if(j==i)
					System.out.printf("%d ",j);
				else if(i%j == 0)
					break;
			}
		}
		System.out.println();
	}
	public static int max(int a,int b, int c) {
		int max=a>(b>c?b:c)?a:(b>c?b:c);
		
		return max;
		
	}

}
