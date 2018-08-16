class 자료형_double
{
	public static void main(String[] args)
	{
		//실수형: 기본형은 double
		//상수 : 0.0 1.2E+002(지수) E+002는 여기서 10^2 를 말한다.
		//    : 0.0F <= float 상수
		//출력서식: %f %e <= 소숫점 6자리를 출력
		//%g <= 자릿수가 적은쪽으로 출력
		
		double d = 1.2345;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%g\n",d);
		System.out.println();
		d= 424.4589;
		System.out.printf("%f\n",d);
		System.out.printf("%e\n",d);
		System.out.printf("%g\n",d);
		
		System.out.printf("[%10.1f]\n",d);	
		System.out.printf("[%010.1f]\n",d);
		
	}
}