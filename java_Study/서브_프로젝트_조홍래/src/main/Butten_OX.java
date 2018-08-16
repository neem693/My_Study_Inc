package main;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//	awt -> 확장 -> swing
// Frame		   JFrame




public class Butten_OX extends JFrame{


	static BufferedImage BACK = null;
	
	static {
		try {
			BACK = ImageIO.read(new File("BACK.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	JButton jbt_start;
	JButton jbt_exit;
	ImageIcon start = new ImageIcon("start.png");
	ImageIcon exit = new ImageIcon("exit.png");

	JPanel main_ox;

	public Butten_OX() {
		// TODO Auto-generated constructor stub
		super("내가만든 윈도우");

		init_Butten_OX();
		init_gamePan();
		init_action();

		// 위치
		// this.setLocation(200, 100);
		// 크기지정
		// this.setSize(1280, 720);

		// 위치 + 크기정보
		this.setBounds(200, 100, 1280, 720);
		// pack();
		// 보여줘라
		this.setVisible(true);

		// 종료코드
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	private void init_action() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jbt_start == e.getSource()) {
					System.out.println("스타트");
					
					
				}
				if(jbt_exit == e.getSource()) {
					System.out.println("끝내기");
					System.exit(0);
					
				}
				
				
			}
		};
		jbt_start.addActionListener(action);
		jbt_exit.addActionListener(action);
		
	}



	private void init_gamePan() {
		// TODO Auto-generated method stub
		main_ox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(BACK, 0, 0, null);

			}
		};
		this.add(main_ox);

	}

	private void init_Butten_OX() {
		// TODO Auto-generated method stub
		jbt_start = new JButton(new ImageIcon(((new ImageIcon("start.png")).getImage())));
		jbt_exit = new JButton(new ImageIcon(((new ImageIcon("exit.png")).getImage())));

		jbt_exit.setFocusPainted(false);
		jbt_exit.setBorderPainted(false);
		jbt_exit.setContentAreaFilled(false);
		// jbt_start.setVisible(false);
		jbt_start.setFocusPainted(false);
		jbt_start.setBorderPainted(false);
		jbt_start.setContentAreaFilled(false);
		
		
		jbt_start.setBounds(0, 285, 250, 350);
		jbt_exit.setBounds(1030, 286, 250, 350);
		this.add(jbt_start);
		this.add(jbt_exit);


		// jbt_start.setBounds(0, 700);
		// jbt_start.setBounds(880, 500, 350, 250);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Butten_OX();
	}

}
