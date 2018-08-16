package mymain;

public class MyMain_¹è¿­1_1 {
	
	static void setArray(int [] g) {
		for(int i=0;i<g.length;i++)
			g[i] = i+1;
	}
	
	static void displayArray(int [] g) {
		for(int gr : g)
			System.out.println(gr);
	}
	
	public static void main(String[] args) {
		int [] mr = new int[4];
		setArray(mr);
		displayArray(mr);
	}

}
