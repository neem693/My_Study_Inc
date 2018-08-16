import java.util.Scanner;
class Q5p4{
	public static void main(String [] args){
		System.out.println("숫자를 입력하세요:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result =0;
		
		for(int i = 1; i<=n;i++){
			if(i%2==0) continue;
		result +=i;
		}
	System.out.printf("%d",result);
	}
}