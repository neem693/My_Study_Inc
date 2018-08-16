import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class Buy_Sell_new {

	int my_count = 0;
	int play2_count = 0;

	static String chat = "";
	static String chat1 = "";
	
	static String chat_ai = "";
	static String chat_ai1 = "";
	Blue_Marble frame;

	public Buy_Sell_new(Blue_Marble frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	public Buy_Sell_new() {
		
	
	}
		
	public void buy() {

		if (check_my_stack_buy()) {
			
			
			Blue_Marble.play.price -= Blue_Marble.con_col.get(Blue_Marble.my_place_stack-1).price;

			
			//System.out.printf("구매 완료된 위치%d   내가 가진금액%d\n", blue_marble.my_place_stack, blue_marble.play.price);
			Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "원"); // 현재 총 금액 표시

			my_count++;
			
			Blue_Marble.jlb_building.setText(my_count + "개"); // 건물수 표시

			chat = String.format("%s 구매했습니다", Blue_Marble.con_col.get(Blue_Marble.my_place_stack - 1).contry_name);

			frame.jta_chat.append(chat + "\r\n");
			
			active_button();		//구매한 버튼 활성화 
		
		
			

		}

		else {
			chat1 = String.format("이미 구입했거나 구입할수없는 땅입니다.");
			frame.jta_chat.append(chat1 + "\r\n");
			
		}

	}

	public void active_button() {
		// TODO Auto-generated method stub
		 
		
		for(int i =0 ; i<15; i++) {
	
		
		switch(Blue_Marble.play.contry_stack[i]){
     
		case 2:Blue_Marble.독일.setEnabled(true);
        		break;
		case 3:Blue_Marble.노르웨이.setEnabled(true);
		break;
		case 4:Blue_Marble.러시아.setEnabled(true);
		break;
		case 5:Blue_Marble.루마니아.setEnabled(true);
		break;
		case 6:Blue_Marble.스웨덴.setEnabled(true);
		break;
		case 7:Blue_Marble.필란드.setEnabled(true);
		break;
		case 9:Blue_Marble.스페인.setEnabled(true);
		break;
		case 10:Blue_Marble.아일랜드.setEnabled(true);
		break;
		case 11:Blue_Marble.이탈리아.setEnabled(true);
		break;
		case 13:Blue_Marble.중국.setEnabled(true);
		break;
		case 14:Blue_Marble.일본.setEnabled(true);
		break;
		case 15:Blue_Marble.헝가리.setEnabled(true);
		break;
		
		
	
       
        default :
          //  System.out.println("구입할 수 없는 위치");

		
		}
		
	}
	
	
	}

	
	
	public void active_button_ai() {
		// TODO Auto-generated method stub
		 
		
		for(int i =0 ; i<15; i++) {
	
		
		switch(Blue_Marble.play2.contry_stack[i]){
     
		case 2:Blue_Marble.독일_ai.setEnabled(true);
        		break;
		case 3:Blue_Marble.노르웨이_ai.setEnabled(true);
		break;
		case 4:Blue_Marble.러시아_ai.setEnabled(true);
		break;
		case 5:Blue_Marble.루마니아_ai.setEnabled(true);
		break;
		case 6:Blue_Marble.스웨덴_ai.setEnabled(true);
		break;
		case 7:Blue_Marble.필란드_ai.setEnabled(true);
		break;
		case 9:Blue_Marble.스페인_ai.setEnabled(true);
		break;
		case 10:Blue_Marble.아일랜드_ai.setEnabled(true);
		break;
		case 11:Blue_Marble.이탈리아_ai.setEnabled(true);
		break;
		case 13:Blue_Marble.중국_ai.setEnabled(true);
		break;
		case 14:Blue_Marble.일본_ai.setEnabled(true);
		break;
		case 15:Blue_Marble.헝가리_ai.setEnabled(true);
		break;
	
       
        default :
           // System.out.println("구입할 수 없는 위치");
    
		
		}
		
	}
	
	
	}
	
	
	
	
	
	
	
	public void play2_buy() {

		if (check_my_stack_buy_play()) {

			Blue_Marble.play2.price -= Blue_Marble.con_col.get(Blue_Marble.play2_place_stack-1).price;

			System.out.printf("플레이어2:구매 완료된 위치%d   플레이어2금액%d\n", Blue_Marble.play2_place_stack,
					Blue_Marble.play2.price);
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "원"); // 현재 총 금액 표시

				
			/*play2_count++;
			blue_marble.jlb_building.setText(my_count + "개"); // 건물수 표시

			chat = String.format("플레이어2가%s 구매했습니다",
					blue_marble.con_col.get(blue_marble.my_place_stack - 1).contry_name);

			frame.jta_chat.append(chat + "\r\n");*/
			
            play2_count++;
			
			Blue_Marble.jlb_building_ai.setText(play2_count + "개"); // 건물수 표시

			chat_ai = String.format("%s AI가 구매했습니다", Blue_Marble.con_col.get(Blue_Marble.play2_place_stack - 1).contry_name);

			frame.jta_ai_chat.append(chat_ai + "\r\n");

			active_button_ai();
			
		
		}

		else {
			chat_ai1 = String.format(" 이미 구입했거나 구입할수없는 땅입니다ㅇㅋ?");
			frame.jta_ai_chat.append(chat_ai1 + "\r\n");
		}

	}

	private void deactive_button_ai(int x) {
		
		switch(x){
	     
		case 2:Blue_Marble.독일_ai.setEnabled(false);
        		break;
		case 3:Blue_Marble.노르웨이_ai.setEnabled(false);
		break;
		case 4:Blue_Marble.러시아_ai.setEnabled(false);
		break;
		case 5:Blue_Marble.루마니아_ai.setEnabled(false);
		break;
		case 6:Blue_Marble.스웨덴_ai.setEnabled(false);
		break;
		case 7:Blue_Marble.필란드_ai.setEnabled(false);
		break;
		case 9:Blue_Marble.스페인_ai.setEnabled(false);
		break;
		case 10:Blue_Marble.아일랜드_ai.setEnabled(false);
		break;
		case 11:Blue_Marble.이탈리아_ai.setEnabled(false);
		break;
		case 13:Blue_Marble.중국_ai.setEnabled(false);
		break;
		case 14:Blue_Marble.일본_ai.setEnabled(false);
		break;
		case 15:Blue_Marble.헝가리_ai.setEnabled(false);
		break;
	
       
        default :
           // System.out.println("구입할 수 없는 위치");
    
		
		}
		
		
		
	}

	public void sell(int uniq_num) {

		if (check_my_stack_sell(uniq_num)) {

			Blue_Marble.play.price += (int) (Blue_Marble.con_col.get(uniq_num-1).price * 0.7);
			// 판매시 70%만 환급됩니다.
			Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "원");

			my_count--;
			chat = String.format("%s 판매했습니다", Blue_Marble.con_col.get(uniq_num-1).contry_name);
			Blue_Marble.jlb_building.setText(my_count + "개"); // 건물수 표시
			frame.jta_chat.append(chat + "\r\n");

			for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우
				if (Blue_Marble.play.contry_stack[i] == uniq_num)
					Blue_Marble.play.contry_stack[i] = 0;
				// 이미 구입한 곳 위치에 0을 넣어서 초기화를 시킴

			}
			
		}

	

	}
	public void play2_sell(int uniq_num) {
		if (check_my_stack_sell_play(uniq_num)) {

			Blue_Marble.play2.price += (int) (Blue_Marble.con_col.get(uniq_num).price * 0.7);
			// 판매시 70%만 환급됩니다.
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "원");

			play2_count--;
			chat_ai = String.format("%s 판매했습니다", Blue_Marble.con_col.get(uniq_num - 1).contry_name);
			Blue_Marble.jlb_building_ai.setText(play2_count + "개"); // 건물수 표시
			frame.jta_ai_chat.append(chat_ai + "\r\n");

			for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우
				if (Blue_Marble.play2.contry_stack[i] == uniq_num)
					Blue_Marble.play2.contry_stack[i] = 0;
				// 이미 구입한 곳 위치에 0을 넣어서 초기화를 시킴

			}
			deactive_button_ai(uniq_num);
		
		
		
		
		
		}

	
	}

	private boolean check_my_stack_sell(int uniq_num) {

		// 판매하기위해 내가 소유하고있는지 확인
		for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우

			if (Blue_Marble.play.contry_stack[i] == uniq_num)
				return true;

		}

		return false;

	}
	
	private boolean check_my_stack_sell_play(int uniq_num) {
		
		// 판매하기위해 내가 소유하고있는지 확인
				for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우

					if (Blue_Marble.play2.contry_stack[i] == uniq_num)
						return true;

				}

				return false;
		
	}

	private boolean check_my_stack_buy() {//플레이어

		// 주인공의 경우 값 비교

		int n = 0;
		
		if(Blue_Marble.my_place_stack==9||Blue_Marble.my_place_stack==1)return false; //스타트 및 무인도 제거
		
		for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우,play2가 나라를 소유하고있는경우

			if (Blue_Marble.play.contry_stack[i] == Blue_Marble.my_place_stack)
				return false;
			// 내스택과 플레이어 2의 스택을 비교한후에 같은 값이 0 이상일 경우 누군가 소유하고있는경우이므로 살수없다.

			if (Blue_Marble.my_place_stack == Blue_Marble.play2.contry_stack[i]) {
				n = Blue_Marble.play2.contry_stack[i];
				if (n > 0) {
					System.out.println("상대방이 소유중이거나 구입할수없는 땅입니다ㅇㅋ?.");
					return false;
				}
			}

		}

		for (int k = 0; k < 15; k++) { // 구입하지 않는 경우 스택의 빈곳에 데이터를 넣음

			//System.out.printf("내가 가진 스택 %d\n", blue_marble.play.contry_stack[k]);
			if (Blue_Marble.play.contry_stack[k] == 0) {
				Blue_Marble.play.contry_stack[k] = Blue_Marble.my_place_stack;

				break;
			}

		}

		return true;

	}

	private boolean check_my_stack_buy_play() { //ai

		// 주인공의 경우 값 비교

		if(Blue_Marble.play2_place_stack==9||Blue_Marble.play2_place_stack==1)return false; //스타트 및 무인도 제거
		
		int n = 0;
		for (int i = 0; i < 15; i++) { // 이미 구입해서 스택을 갖고있는경우,play2가 나라를 소유하고있는경우

			if (Blue_Marble.play2.contry_stack[i] == Blue_Marble.play2_place_stack)
				return false;
			// 내스택과 플레이어 2의 스택을 비교한후에 같은 값이 0 이상일 경우 누군가 소유하고있는경우이므로 살수없다.

		/*	System.out.printf("내가 가진 스택 %d, 플레이어2의 위치%d\n", blue_marble.play.contry_stack[i],
					blue_marble.play2_place_stack);
*/
			if (Blue_Marble.play.contry_stack[i] == Blue_Marble.play2_place_stack) {

				n = Blue_Marble.play.contry_stack[i];
				System.out.printf("스택값 %d", n);
				if (n > 0) {
					System.out.println("상대방이 소유중이거나 구입할수없는 땅입니다 ㅇㅋ?.");
					return false;
				}
			}

		}

		for (int k = 0; k < 15; k++) { // 구입하지 않는 경우 스택의 빈곳에 데이터를 넣음
			if (Blue_Marble.play2.contry_stack[k] == 0) {
				Blue_Marble.play2.contry_stack[k] = Blue_Marble.play2_place_stack;
					
				break;
			}

		}

		return true;

	}

}
