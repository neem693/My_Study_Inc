package mymain;

import java.awt.Graphics;

public class Explosion extends Item{
	
	public static int INDEX_INTERVAL = 2;
	int image_index;
	int index_interval= INDEX_INTERVAL;

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		if(index_interval == INDEX_INTERVAL) {
			image_index++;
		}
		index_interval--;
		if(index_interval<0)
			index_interval = INDEX_INTERVAL;
		
		
		return (image_index < MyImages.img_exp.length);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(MyImages.img_exp[image_index],pos.x,pos.y,null);
	}
	

}
