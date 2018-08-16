package mymain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyMain_1_0_화일입력 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("src/mymain/MyMain_1_0_화일입력.java");
		
		while(true) 
		{
			int ch = is.read();
			if(ch==-1)break;
			System.out.print((char)ch);//여기서 println을 하면 \n이 추가 되가지고 하나씩 계속 밀려진다.
			
		}

	}

}
