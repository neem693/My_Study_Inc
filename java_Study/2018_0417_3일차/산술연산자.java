class 산술연산자{
	public static void main(String [] args){
		int x = 10;
		int y =3;
		int z;
		
		z = x+y;
		
		System.out.printf("%d + %d = %d\n",x,y,z);
		
		z = x-y;
		System.out.printf("%d - %d = %d\n",x,y,z);
		
		z= x*y;
		System.out.printf("%d - %d = %d\n",x,y,z);
		
		z= x/y;
		System.out.printf("%d / %d = %d\n",x,y,z);
		
		z= x%y;
		System.out.printf("%d %% %d = %d\n",x,y,z);
		//몫 연산자 사용시 실수/정수
		System.out.println(10/3.0);
		System.out.println(10/(int)3.0);
		System.out.println((int)(10/3.0));
		System.out.println(10%3.0);
		
		
		
		int n = 11;
		
		//홀수냐? 짝수냐?
		if(n%2 == 0)
			System.out.printf("%d는 짝수\n",n);
		else
			System.out.printf("%d는 홀수\n",n);
		
		//3의 배수냐?
		if(n%3 == 0)
			System.out.printf("%d는 3의 배수",n);
		else
			System.out.printf("%d는 3의 배수가 아니다.",n);
		
	}
}