class Q_star3{
	public static void main(String [] args){
		int h = 2,t=2;
		for(int i =0;i<5;i++){//가로로 별 출력
			
			for(int k =0; k<5; k++)//줄 바꾸기 
			{
				if(k>=h&&k<=t){
					System.out.print("*");
				}
				else
					System.out.print("-");
			}
			if(i<2){
				h--;
				t++;
			}
			else{
				h++;
				t--;	
			}		
			System.out.println();			
		}

	}
}
			