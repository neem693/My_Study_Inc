package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_GridLayoutTest extends JFrame {

	public MyMain_GridLayoutTest() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		
		GridLayout gl = new GridLayout(2,3,5,5);
		this.setLayout(gl);
		
		
		for(int i =1; i<=6;i++) {
			String title = String.format("Bt_%02d", i);
			JButton jbt = new JButton(title);
			this.add(jbt);
		}
		
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_GridLayoutTest();

	}

}