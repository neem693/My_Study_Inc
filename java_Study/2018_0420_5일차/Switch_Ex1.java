import java.util.Scanner;
class Switch_Ex1
{
	public static void main(String[] args){
		String yoil;
		String job= "";
		boolean ending =true;
		Scanner scan = new Scanner(System.in);
	
		while(ending){nn	
			System.out.print("요일:");
			yoil = scan.next();
		
			switch(yoil)
			{
				case "월" : job ="애국조회"; break;
				case "화" : job ="공부"; break;
				case "수" : job ="운동"; break;
				case "목" : job ="영화"; break;
				case "금" : job ="술먹기"; break;
				case "토" :
				case "일" : job ="잠자기";break;
				case "끝" : ending = false;
			}
			System.out.printf("[%s]요일은 [%s]\n",yoil,job);
		}
	}
}