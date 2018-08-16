package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

import inter.MyWindowEventListener;

public class MyWin extends JFrame {
	public MyWin() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowListener listener = new MyWindowEventListener();
		this.addWindowListener(listener);
		//현재 윈도우에서 발생되는 모든 이벤트 listener에게 위임함.
		
	}

	public static void main(String[] args) {
		new MyWin();

	}
}
