import java.util.Scanner;

class For_Ex4
{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int dan;
		
		while( true ){
			
		System.out.print("단(종료는 -1 을 입력하시오) :");
		dan = s.nextInt();
		if(dan == -1)
			break;
		if(dan  < 2 || dan > 9){
			System.out.println("2~9사이의 값을 입력하세요");
			continue;
		}

			for(int j= 1; j<=9; j++){
				System.out.printf("%d x %d = %d\n",dan,j,dan*j);
				if(j==3)
				continue;
			
			}
			System.out.println();
		}
	}
}
			