package mymain;

import java.awt.Graphics;

public class Bullet extends Item{
	
	int speed = 10;

	public Bullet() {
		// TODO Auto-generated constructor stub
		pos.width = MyImages.img_bullet.getWidth(null);
		pos.height = MyImages.img_bullet.getHeight(null);
	}
	
	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		pos.y -= speed;
		
		//총알이 화면 내에 있냐?
		return (pos.y >= -pos.height);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(MyImages.img_bullet, pos.x, pos.y,null);
		
	}
	
	

}
