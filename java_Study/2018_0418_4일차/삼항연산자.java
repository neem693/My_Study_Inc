class 삼항연산자{
	public static void main(String [] args){
		int a =10, b=5, c;
	//2 수 중에서 큰수구하기
		c = (a>b)? a:b;
		
		System.out.printf("%d와 %d중 큰 수는 %d\n",a,b,c);
	//절대값 구하기 
	int n = -100;
	int m;
	
	m=(n<0)? -n:n;
	
	System.out.printf("|%d| = %d\n",n,m);
		
		
	}
}
