import java.util.Scanner;
class 문제입출력{
	public static void main(String[] args){
	
		Scanner s= new Scanner(System.in);
		
		System.out.println("--[신상정보입력]--");
		System.out.print("이름:");
		String name=s.next();
		System.out.print("나이:");
		int age = s.nextInt();
		s.nextLine();
		System.out.print("주소:");
		String addr = s.nextLine();
		System.out.print("키:");
		double ki = s.nextDouble();
		
		s.nextLine();
		System.out.print("전화:");
		String tel = s.nextLine();
		System.out.println("--[출력내용]--");
		System.out.printf("이름: %s 님\n",name);
		System.out.printf("나이: %d(살)\n",age);
		System.out.printf("주소: %s\n",addr);
		System.out.printf("키: %.1f(cm)\n",ki);
		System.out.printf("전화: %s\n",tel);
		
	}
}