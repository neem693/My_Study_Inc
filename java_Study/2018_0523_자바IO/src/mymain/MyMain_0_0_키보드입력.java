package mymain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_0_0_키보드입력 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		

		
		
		
		
		System.out.println("내용을 입력하세요");
		
		
		while(true) 
		{
			int ch = is.read();
			if(ch==-1)break;
			System.out.print((char)ch);//여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.
			
		}

	}

}
