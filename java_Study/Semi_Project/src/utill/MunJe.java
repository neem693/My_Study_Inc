package utill;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class MunJe {
	int file_line;
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	String[][] data;
	Random r1 = new Random();
	ArrayList<String> quiz_n = new ArrayList<String>();
	ArrayList<String> quiz_m = new ArrayList<String>();
	ArrayList<String> quiz_c = new ArrayList<String>();
	ArrayList<String> quiz_r_n = new ArrayList<String>();
	ArrayList<String> quiz_r_m = new ArrayList<String>();
	ArrayList<String> quiz_r_c = new ArrayList<String>();
	
	
	public MunJe() throws IOException {//정방향코딩
		// TODO Auto-generated constructor stub
		try {
			
			String file_path = "c:\\My_study\\OX문제.txt";
			//File f = new File(this.getClass().getResource("util/OX문제.txt").toURI());
			file_line = MunJe.countLines(file_path);
			System.out.println(file_line);
			is = new FileInputStream (file_path);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = new String[file_line+1][3];
		int i = 0;
		while (true) {
		
			String readStr = br.readLine();
			if (readStr == null)
				break;
			data[i] = readStr.split("\\$\\$");

			//System.out.printf("%s번 %s 정답%s\n", data[i][0], data[i][1], data[i][2]);
			i++;
			
		}
		return;
	}


	public void forward() {

		for(int i =0; i<data.length; i++) {
		System.out.printf("%s번 %s 정답%s\n", data[i][0], data[i][1], data[i][2]);
		}
	}
	
	public void random() throws IOException {//랜덤 출력 코딩
		
		for(int i=0;i<data.length;i++) {
			quiz_n.add(data[i][0].trim());
			quiz_m.add(data[i][1].trim());
			quiz_c.add(data[i][2].trim());
		}
		
		int u = quiz_n.size();
		for(int i = 0; i < u-1; i++) {
			int max = quiz_n.size()-1;
			int r = r1.nextInt(max);
			quiz_r_n.add(quiz_n.get(r));
			quiz_r_m.add(quiz_m.get(r));
			quiz_r_c.add(quiz_c.get(r));
			quiz_n.remove(r);
			quiz_m.remove(r);
			quiz_c.remove(r);
			
			
		}
		
		for(String munje : quiz_r_m) {
			System.out.println(munje);
		}
		
		
	}
	
	



	public ArrayList<String> getQuiz_r_n() {
		return quiz_r_n;
	}


	public void setQuiz_r_n(ArrayList<String> quiz_r_n) {
		this.quiz_r_n = quiz_r_n;
	}


	public ArrayList<String> getQuiz_r_m() {
		return quiz_r_m;
	}


	public void setQuiz_r_m(ArrayList<String> quiz_r_m) {
		this.quiz_r_m = quiz_r_m;
	}


	public ArrayList<String> getQuiz_r_c() {
		return quiz_r_c;
	}


	public void setQuiz_r_c(ArrayList<String> quiz_r_c) {
		this.quiz_r_c = quiz_r_c;
	}
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}

}
