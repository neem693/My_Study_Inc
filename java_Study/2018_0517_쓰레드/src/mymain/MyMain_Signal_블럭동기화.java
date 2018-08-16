package mymain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_Signal_블럭동기화 extends JFrame {

	JButton jbt_red, jbt_yellow, jbt_green;

	public MyMain_Signal_블럭동기화() {
		super("신호등");
		new FlowLayout();
		this.setLayout(new GridLayout(1, 3));

		jbt_red = new JButton();
		jbt_yellow = new JButton();
		jbt_green = new JButton();

		jbt_red.setBackground(Color.RED);
		jbt_yellow.setBackground(Color.YELLOW);
		jbt_green.setBackground(Color.GREEN);

		// 신호등을 쓰레드
		init_signal_thread();

		this.add(jbt_red);
		this.add(jbt_yellow);
		this.add(jbt_green);

		// this.setLocation(200,100);
		this.setBounds(200, 100, 300, 100);

		this.setResizable(false);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_signal_thread() {
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable() {
			
			Object syncObj = new Object();
			

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String name = Thread.currentThread().getName();// R or Y or G

				while (true) {

					if (name.equals("R")) {
						synchronized (this) {

							jbt_red.setBackground(Color.RED);
							jbt_yellow.setBackground(Color.GRAY);
							jbt_green.setBackground(Color.GRAY);
						}

					} else if (name.equals("Y")) {
						synchronized (this) {

							jbt_red.setBackground(Color.GRAY);
							jbt_yellow.setBackground(Color.YELLOW);
							jbt_green.setBackground(Color.GRAY);
						}
					} else if (name.equals("G")) {
						synchronized (this) {

							jbt_red.setBackground(Color.GRAY);
							jbt_yellow.setBackground(Color.GRAY);
							jbt_green.setBackground(Color.GREEN);
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};

		Thread t_red = new Thread(runnable, "R");
		Thread t_green = new Thread(runnable, "Y");
		Thread t_yellow = new Thread(runnable, "G");

		t_red.start();
		t_yellow.start();
		t_green.start();

	}

	public static void main(String[] args) {
		new MyMain_Signal_블럭동기화();

	}

}