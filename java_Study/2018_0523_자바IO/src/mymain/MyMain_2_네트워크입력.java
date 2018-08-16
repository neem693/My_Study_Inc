package mymain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyMain_2_네트워크입력 {

	public static void main(String[] args) throws MalformedURLException,IOException {
		// TODO Auto-generated method stub
		
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);
		
		//입력(byte)스트림 획득
		InputStream is = url.openStream();
		
		while(true) 
		{
			int ch = is.read();
			if(ch==-1)break;
			System.out.print((char)ch);//여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.
			
		}
		


	}

}
