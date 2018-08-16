package Question;

public class Q_15 {

	public static void main(String[] args) {
		int i=-1;
		int i_m = -1;
		int count =0;
		while(count<=9) {
			System.out.print(i+" ");
			if(i>0)
				i+=2;
			else
				i-=2;
			i= i*i_m;
			count++;
		}

	}

}
