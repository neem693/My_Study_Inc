package mymain;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_FlowLayoutTest extends JFrame {

	public MyMain_FlowLayoutTest() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		this.setLayout(fl);
		
		for(int i =1; i<30; i++) {
			JButton jbt = new JButton("Bt_" + i);
			this.add(jbt);
		}
		
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_FlowLayoutTest();

	}

}