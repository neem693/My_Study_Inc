class Do_While_Ex1{
	public static void main(String[] args) 
	{
		int sum = 0;
		int i=0;
		
		do
		{
            sum = sum +i;
			i++;
		}while (i<=10);
		
        
		/*
		while (i<=10)
		{
            sum = sum +i;
			i++;
		}
		*/

		System.out.println(sum);
	}
}