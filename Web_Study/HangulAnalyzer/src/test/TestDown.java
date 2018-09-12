package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL url = new URL("http://yujoonote.tistory.com/27");
		
		URLConnection conn = url.openConnection();
		conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream is = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		
		String readStr="";
		while(true) {
			readStr = br.readLine();
			if(readStr==null)break;
			System.out.println(readStr);
		}
		
		br.close();
		is.close();
		
		
		
	}

}
