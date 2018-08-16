package mymain.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_화일출력 {

	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("test.txt");

		String msg = "안녕하세요\n";
		os.write(msg.getBytes());
		double pi = 3.14;

		String double_str = String.format("%.2f\n", pi);
		os.write(double_str.getBytes());
		
		//System.out.println("-----------------------");
		
		PrintStream ps = new PrintStream(os);
		
		ps.println("--------------------");
		os.write("--------------------\n".getBytes());
		
		String name = "홍길동";
		
		int age = 20;
		double ki = 180.5;
		
		ps.printf("이름:%s\n", name);
		ps.printf("나이%d\n", age);
		ps.printf("키:%.1f(cm)\n",ki);
		
		ps.flush();//버퍼비우기
		
		ps.close();
		os.close();
		
		
	
		

	}

}
