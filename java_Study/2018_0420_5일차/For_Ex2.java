class For_Ex2
{
	public static void main(String [] args) throws Exception
	{
		int result=0;
		int n = 10;
		for(int i = 1; i<=n; i++){
			System.out.print(i);
			if(i==n)
				System.out.print("=");
			else
			System.out.print('+');
			
			result += i;
			Thread.sleep(500);
		}
		System.out.print(result + "\n");
	}
}

