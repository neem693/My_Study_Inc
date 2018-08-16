public class 변수_메소드명명법
{
	static void you_money(){//메소드 정의
	
	System.out.println("너의 돈을 호출해라");
	
	}	
	static void totalMoney(){
		System.out.println("너의 모든 돈을 호출해라");
	}
	
    public static void main(String [] args)
	{
		System.out.println("--[클래스명 명명시 고려사항]--");
		System.out.println("1.시작은 소문자로 지정");
		System.out.println("2.2개이상의 단어의 조합은 매단어 첫글자를 대문자로 지정");
		
		you_money();
		totalMoney();
		
    }
}
