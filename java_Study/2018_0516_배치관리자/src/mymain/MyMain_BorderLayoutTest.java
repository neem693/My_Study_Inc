package mymain;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MyMain_BorderLayoutTest extends JFrame {

	public MyMain_BorderLayoutTest() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		Timer timer;
		
		
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		JButton jbt_center = new JButton("Center");
		
		
		this.add(jbt_east,"East");
		
		
		
		
		
		
		this.add(jbt_west,BorderLayout.WEST);
		this.add(jbt_south,"South");
		this.add(jbt_north , "North");
		this.add(jbt_center);
		//붙이는 옵션을 생략하면 기본값 center가 적용된다.
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_BorderLayoutTest();

	}

}