package mymain;

import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class KeyTest extends JFrame implements KeyListener {
	// 해상도
	int screen_w, screen_h;

	public KeyTest() {
		super("내가만든 윈도우");
		// this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		// 디멘젼이라고 스크린을 관리할 수 있는 클래스
		screen_w = d.width;
		screen_h = d.height;

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		Point pt = this.getLocation();

		if (key == KeyEvent.VK_LEFT) {
			pt.x -= 10;
			if (pt.x < 0 - 400)
				pt.x = screen_w;
		}
		if (key == KeyEvent.VK_RIGHT) {
			pt.x += 10;
			if (pt.x > screen_w)
				pt.x = -400;
		}
		if (key == KeyEvent.VK_DOWN) {
			pt.y += 10;
			if (pt.y > 1080)
				pt.y = -300;
		}
		if (key == KeyEvent.VK_UP) {
			pt.y -= 10;
			if (pt.y < 0-300)
				pt.y = 1080;
		}
		this.setLocation(pt);
		System.out.println(pt.x + " " + pt.y);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		new KeyTest();

	}


}