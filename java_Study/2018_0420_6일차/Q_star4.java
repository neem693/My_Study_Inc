class Q_star4{
	public static void main(String [] args){
		for(int i =0;i<5;i++){//가로로 별 출력
			
			for(int k =0;k<5;k++)//줄 바꾸기 
			{
				if(k<i)
					System.out.print(" ");
				else
					System.out.print("*");
				
				
			}
			System.out.println();
		}
	}
}
			