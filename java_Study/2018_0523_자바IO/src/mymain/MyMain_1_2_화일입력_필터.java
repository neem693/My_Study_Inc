package mymain;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_2_화일입력_필터 {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("src/mymain/MyMain_1_0_화일입력.java");
		
		InputStreamReader isr = new InputStreamReader(is);

		while (true) {
			int ch = isr.read();
			if (ch == -1)
				break;
			System.out.print((char) ch);// 여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.

		}

	}

}
