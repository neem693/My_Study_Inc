import java.lang.Thread;

class For_Ex1
{
	public static void main(String[] args) throws Exception{
		int su =1;
		
		for(su=1;su<=10;su++){
			System.out.printf("su = %d 조건 : %d<=10 => %b\n",su,su,su<=10);
			Thread.sleep(1000);	//1초를 대기한다.
		}
		System.out.printf("su = %d 조건 : %d<=10 => %b\n",su,su,su<=10);
	}
}