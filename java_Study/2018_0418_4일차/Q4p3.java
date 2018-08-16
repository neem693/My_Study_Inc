import java.util.Scanner;
class Q4p3{
	public static void main(String [] args){
		double radius, pi = Math.PI;
		Scanner s = new Scanner(System.in);
		System.out.print("원의 반지름을 입력하십시오: ");
		radius = s.nextDouble();
		
		double cife = 2.0*pi*radius; //원둘레
		double area = radius*radius*pi;// 면적
		double vol = 4.0/3.0 * pi *Math.pow(radius,3) ;//부피
		
		System.out.printf("해당 원의 둘레는 %.2f\n해당원의 면적은 %.2f\n해당 원의 부피는 %.2f",cife,area,vol);
		
		
	}
}