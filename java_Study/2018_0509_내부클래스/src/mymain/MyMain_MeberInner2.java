package mymain;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

//  awt ->확장 -> swing
//  Frame         JFrame

public class MyMain_MeberInner2 extends JFrame {

	//윈도우 이벤트 처리객체
	class MyWindowAdapter extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	public MyMain_MeberInner2() {
		// TODO Auto-generated constructor stub
		super("내가만든 윈도우");

		// 위치 + 크기정보
		this.setBounds(200, 100, 400, 300);

		//보여줘라
		this.setVisible(true);

		//종료코드
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowListener listener = new MyWindowAdapter();
		this.addWindowListener(listener);
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_MeberInner2();
	}

}