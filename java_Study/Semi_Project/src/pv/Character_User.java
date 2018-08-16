package pv;

import java.awt.Font;
import java.awt.Graphics;

import images.Images;
import utill.Pan;

public class Character_User extends Character_ox {
	String name = "싱글플레이 유저";

	public Character_User() {
		// TODO Auto-generated constructor stub

	}

	public Character_User(int x, int y) {
		super(x, y);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("굴림", 1, 11));
		g.drawImage(Images.Back_user.getImage(), current_point.x - Pan.CH_WIDHT * 5 / 2, current_point.y - Pan.CH_WIDHT * 5 / 2,
				Pan.CH_WIDHT * 6, Pan.CH_WIDHT * 6, null);
		g.drawString(name, current_point.x + Pan.CH_WIDHT / 2 - g.getFontMetrics().stringWidth(name)/2, current_point.y);
		// g.fillOval(current_point.x, current_point.y, 10, 10); 테스트
		// g.drawImage(Images.Back_user,current_point.x-Pan.CH_WIDHT*2,current_point.y-Pan.CH_HEIGHT*2,Pan.CH_WIDHT*6,Pan.CH_WIDHT*6,null);
		super.draw(g);
	}

}
