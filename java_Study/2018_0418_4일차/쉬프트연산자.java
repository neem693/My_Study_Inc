class 쉬프트연산자
{
	public static void main(String [] args)
	{
		int n= 0xf0f0f0f0;
		int m = n >> 4;
		int k = n>>>4; 
		System.out.printf("n=%08x\n",n);
		System.out.printf("m=%08x\n",m);
		System.out.printf("k=%08d\n",k);
		
	}
}