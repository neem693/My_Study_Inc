import java.util.Scanner;
class Qp2{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("시간초를 입력하세요 :");
		int ts = s.nextInt(); //시간초
		int os = ts; //오리지날 시간초
		int m,h,cs;
		m=h=0;		//분,시간,compare 시간초
		cs=3600;
		if(ts>cs){
			h= ts/cs;
			ts = ts%cs;
		}
		cs = 60;
		if(ts>cs){
			m= ts/cs;
			ts = ts%cs;
		}
		System.out.printf("%d초는 %d시간 %d분 %d초이다",os,h,m,ts);
		
	}
}

	