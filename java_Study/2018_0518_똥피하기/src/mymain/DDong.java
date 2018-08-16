package mymain;

import java.awt.Graphics;

public class DDong extends Item{
	int x, y;
	
	
	public DDong() {
		// TODO Auto-generated constructor stub
		
		pos.width =MyImages.img_ddong.getWidth(null)/2;
		pos.height = MyImages.img_ddong.getHeight(null)/2;
		
	}
	
	
	public int speed;

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		y += speed;
		pos.x = x + pos.width/2;
		pos.y = y + pos.height/2;
		return y<=MyConst.GamePan.GAMEPAN_H;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(MyImages.img_ddong,x,y,null);//추상화 인터페이스
		//g.drawRect(pos.x ,pos.y,pos.width,pos.height);
		
	}

	
}
