import java.util.Scanner;
class Q4p2{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("당신의 가지고 있는 돈을 입력하세요 :");
		int money = s.nextInt();
		int com_m= 50000;
		int count_50000;
		int count_10000;
		int count_5000;
		int count_1000;
		int count_500;
		int count_100;
		int count_50;
		int count_10;
		int count_1;
		count_50000=count_10000=count_5000=count_1000=count_500=count_100=count_50=count_10=count_1=0;
		if(money >com_m){
			count_50000 = money/com_m;
			money %=com_m;
		}
		com_m =10000;
		if(money>com_m){
			count_10000 = money/com_m;
			money %= com_m;
		}
		com_m=5000;
		if(money>com_m){
			count_5000 = money/com_m;
			money %= com_m;
		}
		com_m = 1000;
		if(money>com_m){
			count_1000 = money/com_m;
			money %= com_m;
		}
		com_m = 500;
		if(money>com_m){
			count_500 = money/com_m;
			money %= com_m;
		}
		com_m = 100;
		if(money>com_m){
			count_100 = money/com_m;
			money %= com_m;
		}
		com_m = 50;
		if(money>com_m){
			count_50 = money/com_m;
			money %= com_m;
		}
		com_m =10;
		if(money>com_m){
			count_10 = money/com_m;
			money %= com_m;
		}
		com_m =1;
		if(money>com_m){
			count_1 = money/com_m;
			money %= com_m;
		}
		/*
		if(count_10000 = money/10000)
			count_10000 = money/10000;
		*/
		System.out.println(money);
		System.out.println("5만원 권" + count_50000);
		System.out.println("만원 권 " + count_10000);
		System.out.println("5000원 권 " + count_5000);
		System.out.println("1000원 권 " + count_1000);
		System.out.println("500원 " +count_500);
		System.out.println("100원 " + count_100);
		System.out.println("50원 " +count_50);
		System.out.println("10원 " +count_10);
		System.out.println("1원 " +count_1);
		int all = count_50000 * 50000+count_10000 * 10000 +count_5000 * 5000 +count_1000 * 1000 +count_500* 500+count_100 * 100+count_50 * 50 +count_10 * 10 + count_1;
		System.out.println(all);
	}
}
		