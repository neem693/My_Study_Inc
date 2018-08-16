import java.util.Scanner;

class Q4p1{
	public static void main(String [] args){
		int kor,eng,mat,tot;
		double avg;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("국어, 영어, 수학 3개과목을 각각 입력받으세요:");
		kor = s.nextInt();
		eng = s.nextInt();
		mat = s.nextInt();
		tot = kor+eng+mat;
		avg = (double)(tot)/3.0;
		System.out.printf("총점은 다음과 같습니다. %d\n 평균은 다음과 같습니다. %.2f\n",tot,avg);
		
		
		
	}
}