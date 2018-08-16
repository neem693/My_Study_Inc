import java.util.Scanner;
class Qp5{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("섭씨를 입력하시오:");
		double c = s.nextDouble();
		double cf = (9/5.0)*c + 32;
		System.out.printf("%.1f(C)를 화씨로 변환하면 %.2f(F)가 된다.\n",c,cf);
		
		System.out.print("화씨를 입력하시오:");
		double f = s.nextDouble();
		double fc = (5.0/9.0)*(f-32.0);
		System.out.printf("%.1f(F)를 섭씨로 변환하면 %.2f(C)가 된다.",f,fc);
		
		
	}
}