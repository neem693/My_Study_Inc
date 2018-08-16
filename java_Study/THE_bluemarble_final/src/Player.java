import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Player extends Set_Contry {

	int x = 0; // 캐릭의 시작위치
	int y = 800;
	int[] contry_stack = new int[15];

	
	
	Player(String play1, int money) {
		contry_name = "play1";
		price = money;

		pos.width = 100; // 크기 설정
		pos.height = 100;
		pos.x = x;
		pos.y = y;

	
	}

	@Override
	public void draw(Graphics g) {
		
	if(Blue_Marble.turn==false)	g.drawImage(Contry_Class.slime_myturn, this.pos.x+110, this.pos.y+70, null);
	else g.drawImage(Contry_Class.다현char, this.pos.x+110, this.pos.y+70, null);
		

	if(Blue_Marble.turn==true)g.drawImage(Contry_Class.play2_turn, Blue_Marble.play2.pos.x+40, Blue_Marble.play2.pos.y+70, null);
	else g.drawImage(Contry_Class.play2, Blue_Marble.play2.pos.x+40, Blue_Marble.play2.pos.y+70, null);
	
	
	

	}

}
