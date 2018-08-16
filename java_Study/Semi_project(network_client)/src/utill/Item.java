package utill;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class Item implements Serializable {
	
	public abstract boolean move();
	public abstract void draw (Graphics g);
	
}
