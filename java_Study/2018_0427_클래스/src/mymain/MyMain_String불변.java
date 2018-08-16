package mymain;

public class MyMain_String불변 {

	public static void main(String[] args) {
		int count =0;
		String msg = ++count + " little," + ++count + " little," + ++count + " little indian";
		System.out.println(msg);
		System.out.println(msg.length());
		StringBuffer sb1 = new StringBuffer(33);
		StringBuffer sb = new StringBuffer("1 little,2 little,3 little indian");
		count =0;
		
		sb1.append(++count);
		sb1.append(" little.");
		sb1.append(++count);
		sb1.append(" little.");
		sb1.append(++count);
		sb1.append(" little Indian");
		msg  = sb1.toString();
		
		System.out.println(msg);
		System.out.println(sb);
		//방법2)
		System.out.printf("%s\n","안녕");
		count=0;
		msg = String.format("%d little, %d little, %d little Indian", ++count,++count,++count);
		System.out.println(msg);
		
		String s1 = "hello";

		String s2 = "hello";
		
		

	}

}
