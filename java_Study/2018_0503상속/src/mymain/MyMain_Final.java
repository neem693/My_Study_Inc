package mymain;

public class MyMain_Final {
	
	class A
	{
		
		protected void sub1() {}
		
		
		void sub() {}
		boolean sub(int a) { return false;}
		final void sub_final() {
			
		}
		
		void sub2() {
			
		}
	}
	
	class AA extends A
	{
		//Method Override : 부모 클래스의 메소드를 다시 정의하는 것.
		//(메소드 재정의)
		
		public void sub1() {
			
		}
		
		void sub() {
			
		}
		
		@Override
		void sub2() {
			super.sub2();
		}
		
		//void sub_final() {
			//에러난다.
			//재정의가 불가하기 때문이다.
		//}
	}
	
	class AAA
	{
		//int plus(int a,int b) { return a+b;}
		double plus(int a,int b) { return a+b;}
		
	}
	
	
	
	
	
	
	
	
	
	//class MyString extends String{
		
	//}//String은 final 클래스이기 때문에 상속이 되지 않는다.
	
	public final static double PI = 3.14;

	public static void main(String[] args) {
		
		final int MY_AGE = 20;
		//MY_AGE  = 21;
		
		
		

	}

}
