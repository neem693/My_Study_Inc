package utill;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import images.Images;

public class TEST extends JFrame {
	JPanel test;

	public TEST() {
		super("내가만든 윈도우");
		this.setLocation(200,100);
		
		init_pan();
		this.pack();
		
		//this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	private void init_pan() {
		// TODO Auto-generated method stub
		test =  new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(Images.LOSE1, 0, 0,this);
				g.drawImage(Images.LOSE2, 0, 200, this);
				g.drawImage(Images.WIN2, 0, 400, this);
				
			}
		};
		test.setPreferredSize(new Dimension(1280, 720));
		this.add(test);
		
		
		
	}


	public static void main(String[] args) {
		new TEST();

	}

}
