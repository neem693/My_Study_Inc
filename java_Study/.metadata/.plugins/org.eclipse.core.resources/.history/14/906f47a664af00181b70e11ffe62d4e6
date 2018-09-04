package mymain;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_4_네트워크입력_버퍼드리더필터 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);

		// 입력(byte)스트림 획득
		InputStream is = url.openStream();

		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		int count =0;

		while (true) {
			String str = br.readLine();
			if (str == null)
				break;
			System.out.println(str);// 여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.
			count ++;

		}
		System.out.println("반복 횟수:" + count);

	}

}
