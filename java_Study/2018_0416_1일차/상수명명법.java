public class 상수명명법
{

    public static void main(String [] args)
	{
		int money = 100;
		money = 200;
		
		final int MONEY = 100;
		//MONEY = 200;
		System.out.println("1.모두 대문자로 지정");
		System.out.println("2.2개이상의 단어의 조합은 단어 사이에 _ 주로 사용한다.");
		
		System.out.println(Math.PI);
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
    }
}
