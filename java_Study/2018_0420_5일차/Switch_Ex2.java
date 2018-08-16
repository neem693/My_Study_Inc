import java.util.Scanner;
class Switch_Ex2{
	public static void main(String [] args){
		
		Scanner scan = new Scanner(System.in);
		String grade = "";
		int kor;
		boolean exit = true;
		while(exit){
			kor = scan.nextInt();
			if(kor >=0 && kor<=100){
				switch(kor/5)
				{
					case 19:grade = "A+"; break;
					case 18:grade = "A-"; break;
					case 17:grade = "B+"; break;
					case 16:grade = "B-"; break;
					case 15:grade = "C+"; break;
					case 14:grade = "C-"; break;
					case 13:grade = "D+"; break;
					case 12:grade = "D-"; break;
					case 0: exit = false; break;
					default: grade = "F";
				}
				System.out.printf("[%d]점 등급:[%s]\n",kor,grade);
			}
			else System.out.printf("잘못입력하셨습니다.\n");
		}
	}
}