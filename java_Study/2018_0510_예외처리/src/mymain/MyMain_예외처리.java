package mymain;

public class MyMain_예외처리 {

	public static void main(String[] args) {
		
		int a =10,b=1,res=0;
		
		try {
			//본코드
			if(b==0) throw new ArithmeticException("0으로 나누지 말라고 했지!?");
			res = a/b;
			res = res + 1;
			
			String name = null;
			if(name ==null) throw new NullPointerException("객체가 없는데 왜 사용하려고 하냐?");
			int len = name.length();
			
			Exception e = new ArithmeticException();
		}catch(ArithmeticException e) {
			//예외코드
			//e.printStackTrace();
		}catch(NullPointerException e) {
			//e.printStackTrace();
		}catch(Exception e) {
			
		}

	}

}
