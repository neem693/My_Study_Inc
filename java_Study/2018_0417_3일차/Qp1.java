import java.util.Scanner;
class Qp1{

	public static void main (String [] args){
		Scanner s = new Scanner(System.in);
		int p_mny;//상품 단가
		int input_m;//지불한 돈
		int items;//수량
		int output_m; //거스름돈
		int comm;//부가세
		int cost=0; //총비용
		
		System.out.print("지불한 돈:");
		input_m = s.nextInt();
		System.out.print("까페 모카 단가:");
		p_mny = s.nextInt();
		System.out.print("수량:");
		items = s.nextInt();
		
		comm = (int)((p_mny * items) *0.1);
		System.out.printf("부가세: %d\n" , cost= comm);
		System.out.printf("상품총액: %d\n", cost +=  items*p_mny);
		System.out.printf("거스름돈: %d\n", input_m - cost);
		
		
		
	
	
		
	}

}
