package mymain;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MyImages {
	
	public static Image img_ddong;
	public static Image img_me;
	public static Image img_bullet;
	public static Image [] img_exp = new Image[27];
	

	
	static{
		img_ddong = new ImageIcon("ddong.png").getImage();
		img_me = new ImageIcon("bate.png").getImage();
		img_bullet = new ImageIcon("bullet.png").getImage();
		
		for(int i =0; i<img_exp.length; i++) {
			String filename = String.format("image_exp/exp_%02d.png", i+1);
			img_exp[i] = new ImageIcon(filename).getImage();
		}

		
		
	}

}
