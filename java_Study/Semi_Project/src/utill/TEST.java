package utill;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import images.Images;

public class TEST extends JFrame {
	JPanel test;
	Timer timer;
	boolean round=true;
	boolean rest =false;
	boolean reset = true;
	Second sec_out = new Second();
	int sec;

	public TEST() {
		super("내가만든 윈도우");
		this.setLocation(200,100);

		init_pan();
		init_timer();
		this.pack();
		
		//this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listner = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				test.repaint();
				
			}
		};
		timer = new Timer(10,listner);
		timer.start();
		
	}


	protected void process() {
		// TODO Auto-generated method stub
		if(reset) {
			sec_out.reset();
			reset = false;
		}
		if(round) {
			sec = sec_out.out_second();
			if(sec>=500) {
				round = false;
				rest = true;
				reset = true;
			}
		
		}else if(rest)
			sec = sec_out.out_second();
			if(sec>=600) {
				round= true;
				rest = false;
				reset = true;
			}
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
				g.drawString(String.valueOf(sec), 500, 200);
				
			}
		};
		test.setPreferredSize(new Dimension(1280, 720));
		this.add(test);
		
	}


	public static void main(String[] args) {
		new TEST();

	}

}
