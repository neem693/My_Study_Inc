package mymain;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class MyMain_Anoymous extends JFrame {

	public MyMain_Anoymous() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowListener listen = new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		};
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		new MyMain_Anoymous();

	}

}
