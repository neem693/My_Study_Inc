package mymain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_네트워크_문자스트림필터 {
	public static void main(String[] args) throws IOException {
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);

		// 입력(byte)스트림 획득
		InputStream is = url.openStream();

		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		int count =0;

		while (true) {
			int ch = isr.read();
			if (ch == -1)
				break;
			System.out.print((char) ch);// 여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.
			count ++;

		}
		System.out.println("총 문자 수 :" + count);
	}

}
