package mymain;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_CardLayoutTest extends JFrame {

	JPanel centerP;// 중앙에 넣을 패널
	CardLayout card = new CardLayout();

	public MyMain_CardLayoutTest() {
		super("내가만든 윈도우");

		JPanel menuP = new JPanel();
		this.add(menuP, "North");

		JButton jbt_red = new JButton("Red");
		JButton jbt_green = new JButton("Green");
		JButton jbt_blue = new JButton("Blue");

		menuP.setLayout(new GridLayout(1, 3));

		menuP.add(jbt_red);
		menuP.add(jbt_green);
		menuP.add(jbt_blue);

		centerP = new JPanel();
		this.add(centerP, "Center");
		// centerP의 배치방법을 변경

		card = new CardLayout();
		centerP.setLayout(card);

		RedPanel redP = new RedPanel();
		redP.setBackground(Color.RED);
		GreenPanel greenP = new GreenPanel();
		greenP.setBackground(Color.GREEN);
		BluePanel blueP = new BluePanel();
		blueP.setBackground(Color.BLUE);

		centerP.add(redP, "red");
		centerP.add(greenP, "green");
		centerP.add(blueP, "blue");

		// card.show(centerP, "green");\
		// 카드를 뒤집음
		jbt_green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "green");
				
			}
		});
		jbt_red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "red");
				//MyMain_CardLayoutTest.this.repaint();//메인 윈도우를 다시 그려라
				//여기서 this하면 ActionListener가 선택됨
				//근데 나는 왜 다시 안그려도 잔상이 안남냐
			}
		});
		jbt_blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(centerP, "blue");
			}
		});

		init_button_event();
		// this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_button_event() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MyMain_CardLayoutTest();

	}

}