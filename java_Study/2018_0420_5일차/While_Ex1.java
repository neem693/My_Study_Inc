class While_Ex1{
	public static void main(String [] args)throws Exception{
		int ch,count=0;
		while(true)
		{
			ch = System.in.read();
			//키보드로 부터 값을 입력받음
			if(ch==-1)break;
			System.out.printf("%c",ch);
			
			count++;
			Thread.sleep(1000);
		}
		
		System.out.printf("반복횟수 %d",count);
	}
}
			