class 자료형_char
{
	public static void main(String[] args)
	{
		
		
		System.out.printf("%c %c %c %c\n",'A','1','한','韓');
		System.out.printf("개행기능%c\n%c\n",'A','B');
		System.out.printf("tab기능%c\t%c\n",'A','B');
		System.out.printf("%c\b%c\n",'A','B');
		
		char ch = 65; // 'A' <= 65
		
		System.out.printf("%c %c %c\n",ch,ch+1,ch+2);
		
		ch = '가';
		
		System.out.printf("[%c]의 코드값은 (%d) (%x)\n",ch,(int)ch,(int)ch);
		
		char ch1=0xac00;
		System.out.printf("ch1 = %c\n",ch1);
		
		System.out.printf("홍길동의 코드값 : %x %x %x\n",(int)'홍',(int)'길',(int)'동');
		
		
	}
}