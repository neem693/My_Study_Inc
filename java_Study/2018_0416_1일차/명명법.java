//저장 화일명 : Hello.java
public class 명명법
{
    public static void main(String [] args)
	{
		System.out.println("--[식별자 이름 명명시 고려사항]--");
		System.out.println("-->식별자: 클래스명,변수명,상수명,메소드명");
		System.out.println("1.맨앞에 숫자오면 안된다");
		int kor = 100;
		System.out.println("2.중간공백 띄우면 안된다.");
		int eng_jumsu =90;
		System.out.println("3.특수문자 사용못함__오직 영문자 숫자 외엔 사용못함(단, _ $ 예외)");
		int pay = 20;
		System.out.println("Hello World!");
		//아래는 상징성이 결여 되었다.
		
		//int _____ = 10;
		//int $$$$$$ = 20;
		System.out.println("4.예약어는 사용못한다.");
		//int static = 2000;
		//int public = 3000;
		
    }
}
