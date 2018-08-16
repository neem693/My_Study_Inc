import java.util.Scanner;

class 자료형_Scanner
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String name;
		int age;
		double ki;
		System.out.print("이름을 입력하세요:");
		name = scan.next();
		System.out.print("나이를 입력하세요:");
		age = scan.nextInt();
		System.out.print("이제 키를 입력하세요: ");
		ki = scan.nextDouble();
		System.out.printf("당신의 나이는 %d살 이군요!!\n",age);
		System.out.printf("당신의 키는 %.1f 이군요!!\n",ki);
		
	}
}