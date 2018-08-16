package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyMain_Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReader fr = null;

		try {
			fr = new FileReader("src/mymain/MyMain_Finally.java");

			// 화일을 읽어서 출력
			int ch;
			while (true) {
				ch = fr.read();

				if (ch == -1)
					break;
				System.out.printf("%c", ch);
				
				if(ch=='\n') throw new IOException("한줄읽고 끝내기\n");
			}

			fr.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				if (fr != null)
					fr.close();
				System.out.println("파일닫기");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
