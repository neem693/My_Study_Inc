import java.util.Scanner;
class Q_star33{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int chasu;
		String yn = "y";
		
		while(true)
		{
			System.out.print("차수:");
			chasu = s.nextInt();
			if(chasu%2==0){
				System.out.println("홀수만 입력하세요");
				continue;
			}
			
			//처리
			int center = chasu/2;
			
			for(int i=0;i<chasu;i++)
			{
				for(int k =0;k<chasu;k++)
				{
					if(i<=center){
						if(k>=center-i && k<=center + i)
							System.out.print("*");
						else
							System.out.print("-");
					}else{
						int a = chasu -i -1;
						if(k>=center -a && k<=center+a)
							System.out.print("*");
						else
							System.out.print("-");
						
					}
				}
				System.out.println();
			}
			
			//또 할래?
			
			System.out.print("또 할래?(y/n)");
			yn = s.next();
			
			if((yn.equals("y")||yn.equals("Y"))==false)
				break;
			
			
		}
		System.out.println("--End--");
	}
}
		
		