import java.util.Random;


class If_Ex22
{
	public static void main(String [] args){
		Random rand = new Random();
		
		int kor = rand.nextInt(41)+60;
		String grade = "";
		
		if(kor>=90 && kor<=100)
			grade = "A";
		else if(kor>=80 && kor<90)
			grade = "B";
		else if(kor>=70 && kor<80)
			grade = "C";
		else if(kor>=60 && kor<70)
			grade = "D";
		else grade = "F";

		System.out.printf("[%d]Á¡ µî±Þ: [%s] \n",kor,grade);
	}
}
		