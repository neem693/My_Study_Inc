package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RedPanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		Font font = new Font("±¼¸²Ã¼",Font.BOLD,30);
		g.setFont(font);
		g.clearRect(0, 0, 1000, 1000);
		g.drawString("Red Panel", 10, 30);
		
		g.setColor(Color.RED);
		
		g.drawString("Red Panel", 10-1, 30-1);
		
	}


}
