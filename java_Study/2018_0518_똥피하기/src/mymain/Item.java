package mymain;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class  Item {
	
	
	//困摹  + 农扁
	public Rectangle pos = new Rectangle();

	
	//青困 加己
	public abstract boolean move();
	public abstract void draw(Graphics g);
}
