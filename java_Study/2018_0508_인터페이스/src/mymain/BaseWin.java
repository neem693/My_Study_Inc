package mymain;

import javax.swing.JFrame;

public class BaseWin extends JFrame {

	public BaseWin() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BaseWin();

	}

}
