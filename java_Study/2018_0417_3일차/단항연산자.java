class 단항연산자
{
	public static void main(String[] args){
		int n =10;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));
		System.out.println(" ");
		n = 0xf0f0f0f0;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));
		
		n=-1;
		System.out.printf("[%32s]\n",Integer.toBinaryString(n));
		System.out.printf("[%32s]\n",Integer.toBinaryString(~n));
		
		
		boolean bYes = !(3>2);
		System.out.printf("bYes=%b\n",bYes);

		int m =10;
		System.out.printf("m=%d\n",m);
		m++;
		System.out.printf("m=%d\n",m);
		m--;
		System.out.printf("m=%d\n",m);
		
		
		int z;
		int x= 10;
		int y =5;
		z = ++x + y ++;
		System.out.printf("x=%d y=%d z= %d\n",x,y,z);
		x= -10;
		System.out.printf("|%d| = %d\n",x,-x);
		
		x=-x;
		
		double b = 10;
		float f= 10.0f;
		
		byte b1 = 1;
		byte b2 = 2;
		byte b3;
		b3= b1 + b2;
	}
}
