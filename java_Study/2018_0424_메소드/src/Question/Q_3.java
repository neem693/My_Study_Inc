package Question;

public class Q_3 {

	public static void main(String[] args)throws Exception {
		
		System.out.print("문자 한 개를 입력하세요>>");
		int r = System.in.read();
		if(r>='A' && r<='Z' || r>='a' && r<='z')
			System.out.println("이 문자는 알파벳이다.");

		else if(r>='0' && r<='9')
			System.out.println("이 문자는 숫자이다.");
		else
			System.out.println("이 문자는 특수문자이다.");
		
		
		
		
		

	}

}
