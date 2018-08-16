package mymain;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_Win2 extends JFrame {
	
	public MyMain_Win2() {
		
		super("처음 만들어본 윈도우");
		super.setTitle("처음 만들어본 윈도우");
		
		Button bt_east = new Button("East Button");
		Button bt_west = new Button("West Button");
		Button bt_south = new Button("South Button");
		Button bt_north = new Button("North Button");
		JButton bt_center = new JButton("Center Button");
		
		
		//현재 프레임의 버튼 추가
		super.add(bt_east, BorderLayout.EAST);
		super.add(bt_west, "West");
		super.add(bt_south, "South");
		super.add(bt_north, "North");
		super.add(bt_center, "Center");
		
		
		
		
		//위치설정
		super.setLocation(100,100);
		
		//크기지정
		super.setSize(400,300);
		
		//화면에 보여주기
		super.setVisible(true);
	
	}
	
	

	public static void main(String[] args) {
		
		new MyMain_Win2();

	}

}
