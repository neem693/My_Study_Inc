package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class BulletManager {
	
	public static final int MAKE_BULLET_INTERVAL = 5;
	
	int make_bullet_interval = MAKE_BULLET_INTERVAL;
	
	public List<Bullet> bullet_list = new ArrayList<Bullet>();
	
	public void move() {
		
		for(int i =0;i<bullet_list.size();i++) {
			Bullet bullet = bullet_list.get(i);
			if(bullet.move()==false) { //화면밖으로 나간경우
				bullet_list.remove(i);
			}
		}
	}
	
	public void make_bullet(int x, int y) {
		
		if(make_bullet_interval == MAKE_BULLET_INTERVAL) {
			
			//5번에 1번씩 실행(발사)
			Bullet bullet = new Bullet();
			bullet.pos.x = x - bullet.pos.width/2;
			bullet.pos.y = y- bullet.pos.height;
			
			bullet_list.add(bullet);
			
		}
		
		make_bullet_interval--;
		if(make_bullet_interval<0)
			make_bullet_interval = MAKE_BULLET_INTERVAL;
		
		
	}
	
	public void draw(Graphics g) {
		
		for(Bullet bullet : bullet_list) {
			bullet.draw(g);
		}
		
	}

}
