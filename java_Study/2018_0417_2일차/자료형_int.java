class 자료형_int
{
	public static void main(String[] args){
		//정수형: 기본형 int
		//상수: 0 10
		//변수: int n;
		
		int n= 100;
		
		System.out.printf("decimal : %d\n",n);
		System.out.printf("octal : %o\n",n);
		System.out.printf("hexa : %x\n",n);
		
		int octal_n = 0144;
		int hexa_n = 0x64;
		
		System.out.printf("octal_n = %d\n",octal_n);
		System.out.printf("hexa_n = %d\n",hexa_n);
		
		hexa_n = 0xff;
		
		System.out.printf("%d\n",hexa_n);
		
		n=-123;
		
		System.out.printf("[%6d]\n",n);
		System.out.printf("[%06d]\n",n);
		
		System.out.printf("[%-6d]\n",n);
		
		System.out.printf("[%2d]\n",n);
		
		
		
	}
}