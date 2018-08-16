import java.util.Scanner;
class Q4p4{
	public static void main(String [] args){
		
		int a,b,c,max;
		System.out.print("정수 3개를 차례대로 입력하세요");
		Scanner s = new Scanner(System.in);
		a= s.nextInt();
		b= s.nextInt();
		c= s.nextInt();
		max=a;
		if(max<b)
			max = b;
		if(max<c)
			max = c;
		System.out.printf("가장 큰 값은 %d",max);
	}
}
		
			
		
		