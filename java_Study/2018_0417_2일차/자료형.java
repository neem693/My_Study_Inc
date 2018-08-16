class 자료형
{
	public static void main(String [] args)
	{
		
		//논리형자료형
		//상수: true or false
		//변수: boolean bYes;
		//출력서식: %b or %B
		
		
		//출력방법
		//1.출력만 :
		// 클래스명.객체명,메소드()
		//System.out.print("값");
		//2.출력 + 엔터(line next)
		System.out.println("값");
		System.out.printf("%b  %B \n", true,true);
		
		int a =5;
		int b =3;
		boolean bYes = a>b;
		
		System.out.printf("%d>%d 의 결과는 %b 입니다\n",a,b,bYes);
		
		bYes = (a==b);
		System.out.printf("%d==%d의 결과는 %b 입니다.\n",a,b,bYes);
		

		
		/*
		byte b = 100;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(100));
		System.out.printf("[%32s]\n",Integer.toBinaryString(-100));
		
		float f = 1.234567890123456789f;
		double d = 1.234567890123456789;
		
		System.out.printf("%.20f\n",f);
		System.out.printf("%.20f\n",d);
		*/
	}
}