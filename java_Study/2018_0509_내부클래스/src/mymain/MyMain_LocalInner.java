package mymain;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyMain_LocalInner extends JFrame {

	public MyMain_LocalInner() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);
		
		class MywindowAdapter extends WindowAdapter
		{
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		}
		this.addWindowListener(new MywindowAdapter());


	}

	public static void main(String[] args) {
		new MyMain_LocalInner();

	}

}