package mymain;

public class MyMain_배열1_0 {

	public static void main(String[] args) {
		int mr[];
		//배열의 정보를 담는 1차원배열의 참조변수
		mr = new int [4];
		
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		System.out.println("---출력---");
		System.out.printf("mr[%d] = %d\n",0,mr[0]);
		System.out.printf("mr[%d] = %d\n",1,mr[1]);
		System.out.printf("mr[%d] = %d\n",2,mr[2]);
		System.out.printf("mr[%d] = %d\n",3,mr[3]);
		System.out.println();
		for(int i =0;i<mr.length;i++)
			System.out.printf("mr[%d] = %d\n",i,mr[i]);
		
		

	}

}
