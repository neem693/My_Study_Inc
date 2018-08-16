import java.util.Scanner;
class Qp4{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		boolean exit= true;
		String command;
		do{
		System.out.print("인치를 입력하려면 i, 피트를 입력하려면 f를 끝내려면 e를 입력하시오: ");
		command = s.next();
		double feet,inch,ki;
		feet = inch = ki = 0.0;
		
		if(command.equals("f")){
			System.out.print("피트를 입력하세요:");
			feet = s.nextDouble();
			inch = feet*12.0;
			ki = inch*2.54;
			inch= inch%12.0;
			System.out.printf("%.0f피트 %.0f인치는 %.2fcm이다.\n",Math.floor(feet),Math.floor(inch),ki);
		
			
		}
		else if(command.equals("i")){
			System.out.print("인치를 입력하세요:");
			inch = s.nextDouble();
			feet = inch/12.0;
			ki = inch*2.54;
			inch = inch%12.0;
			System.out.printf("%.0f피트 %.0f인치는 %.2fcm이다.\n",Math.floor(feet),Math.floor(inch),ki);
			
			
		}
		else if(command.equals("e")){
			System.out.printf("종료하겠습니다");
			exit=false;
		}
		else System.out.printf("잘못입력하셨습니다. 다시 입력하시죠.\n");
		}while(exit);
		
	}
}

	