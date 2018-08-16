import java.util.Scanner;
class Qp3{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("키를 입력하시오:");
		double ki = s.nextDouble();
		
		double inch,feet;
		inch=feet=0.0;
		
		inch = ki/2.54;
		feet = inch/12.0;
		inch = inch%12.0;
		
		
		System.out.printf("%.2fcm는 %.0f피트 %.0f인치이다.",ki,Math.floor(inch),feet,Math.floor(inch));
	}
}

	