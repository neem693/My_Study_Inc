package mymain;

class MyMath
{
	public int plus(int a, int b) {
		int c = a+b;
		return c;
	}
	public int minus(int a, int b) {
		int c = a - b;
		return c;
	}
	public int hap(int n){	
		int sum = 0;
		for(int i =1; i<=n;i++)
			sum +=i;
			
		return sum;
	}
	public int hap_even(int n) {
		int sum =0;
		for(int i = 2;i<=n;i+=2)
			sum +=i;
		return sum;
	}
}

public class Method1 {

	public static void main(String[] args) {
		MyMath mm = new MyMath();
		
		int x = 10, y= 5, res;
		
		res = mm.plus(x, y);
		System.out.println(res);
		
		res = mm.minus(x, y);
		System.out.println(res);
		
		res = mm.hap(10);
		System.out.println("합 출력" + res);
		
		res = mm.hap_even(10);
		System.out.println("짝수 출력:"+res);
	}
}
