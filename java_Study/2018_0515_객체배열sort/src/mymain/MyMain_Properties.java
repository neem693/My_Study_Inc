package mymain;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class MyMain_Properties {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader("src/db.properties");
			
			prop.load(reader);
			
			prop.list(System.out);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");

			String user = prop.getProperty("user");

			String pwd = prop.getProperty("pwd");
			System.out.println("---읽어온 속성값---");
			System.out.println(driver);
			System.out.println(url);
			System.out.println(user);
			System.out.println(pwd);
			
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		

	}

}
