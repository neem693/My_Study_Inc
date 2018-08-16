package mymain;

class MyUtil{
	public static void draw_line() 
	{
		System.out.println("--------------------------------");
	}
	
	public static void draw_line(int line_size,char line_style) 
	{
		for(int i =0;i<line_size;i++)
			System.out.printf("%c",line_style);
		System.out.println();
	}
	public static void draw_line(int line_size,String line_style_str) {
		for(int i =0;i<line_size;i+=line_style_str.length())
			System.out.printf("%s",line_style_str);
		int space = line_size%line_style_str.length();
		if(space != 0 ) {
			
		}
		System.out.println();
	}
}


public class Method2 {
	public static void main(String[] args) {
		MyUtil.draw_line();
		System.out.println("            성적관리\n");
		
		int line_size =50;
		char line_style ='=';
		String line_style_str = "+-";
		
		MyUtil.draw_line(line_size, line_style);
		System.out.println(" 번호     	이름       국어     영어      수학       총점");
		MyUtil.draw_line(line_size, line_style_str);
		System.out.println("  1    홍길동      99   98   88   278");
		System.out.println("  2    이길동      99   98   88   278");
		MyUtil.draw_line(line_size,'-');
		
	}
}
