package mymain;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMain_Menu extends JFrame implements ActionListener {

	public void init_menu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu_color = new JMenu("색상");
		JMenu menu_help = new JMenu("도움말");

		menuBar.add(menu_color);
		menuBar.add(menu_help);

		JMenuItem itemR = new JMenuItem("빨강");
		JMenuItem itemG = new JMenuItem("초록");
		JMenuItem itemB = new JMenuItem("파랑");
		JMenuItem itemExit = new JMenuItem("종료");

		menu_color.add(itemR);
		menu_color.add(itemG);
		menu_color.add(itemB);
		menu_color.addSeparator();
		menu_color.add(itemExit);

		this.setJMenuBar(menuBar);

		// 메뉴(아이템)이벤트 처리 + 버튼 이벤트
		// 엑션리스너 인터페이스 + 타이머이벤트
		// 여기서 this란 ActionListener를 말한다.
		// 그 엑션리스너란 지금 구현상속 했다.
		itemR.addActionListener(this);
		itemG.addActionListener(this);
		itemB.addActionListener(this);
		itemExit.addActionListener(this);
	}

	public MyMain_Menu() {
		super("내가만든 윈도우");

		// 메뉴
		init_menu();

		JButton bt1 = new JButton("빨강");
		this.add(bt1, "East");
		bt1.addActionListener(this);

		// this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Menu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		// System.out.println(new Date(e.getWhen()));

		// ActionEvent e : Event Source정보(이벤트를 발생시킨 객체정보)
		Object evt_ob = e.getSource();
		// 이벤트를 발생시킨 컨트롤의 갭션
		String cmd = e.getActionCommand();
		// System.out.println(cmd);

		if (evt_ob instanceof JMenuItem) {
			System.out.printf("메뉴에서 선택된 : %s\n",cmd);
			if(cmd.equals("빨강"))
				getContentPane().setBackground(Color.RED);
			else if(cmd.equals("초록"))
				getContentPane().setBackground(Color.GREEN);
			else if(cmd.equals("파랑"))
				getContentPane().setBackground(Color.BLUE);
		}
		else if(evt_ob instanceof JButton) {
			System.out.printf("버튼에서 선택된 : %s\n",cmd);
			((Component)evt_ob).setBackground(Color.RED);
			//다운케스팅
		}

	}

}