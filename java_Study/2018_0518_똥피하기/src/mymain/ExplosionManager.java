package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ExplosionManager {

	public List<Explosion> explosion_list = new ArrayList<Explosion>();

	public void make_explosion(int x, int y) {
		
		Explosion exp = new Explosion();
		//폭발위치 중아에서 그려진 좌표 보정
		exp.pos.x = x - MyImages.img_exp[0].getWidth(null)/2;
		exp.pos.y =y - MyImages.img_exp[0].getWidth(null)/2;
		
		
		explosion_list.add(exp);
		
	}

	public void move() {
		
		for(int i =0;i<explosion_list.size();i++) {
			Explosion exp = explosion_list.get(i);
			if(exp.move() == false) {
				explosion_list.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		
		for (Explosion exp : explosion_list) {
			
			exp.draw(g);
			
		}
		
	}

}
