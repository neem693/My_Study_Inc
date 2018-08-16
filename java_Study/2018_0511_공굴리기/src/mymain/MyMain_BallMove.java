package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyMain_BallMove extends JFrame {

	JPanel gamePan;// JPanel이란 테투리가 없는 윈도우
	Timer timer;
	
	int red=255,green =0,blue= 0;
	Color c = new Color(red,green,blue);
	int ball_size = 30;// 크기
	int ball_x = MyConst.GAME_W / 2 - ball_size / 2;
	int ball_y = MyConst.GAME_H / 2 - ball_size / 2;// 위치

	boolean stop = false;
	boolean bDown = true;
	boolean bRight = true; // 오른쪽 이동 여부

	public MyMain_BallMove() {
		super("공 굴리기");

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(d.getWidth() + " " + d.getHeight());
		// this.setLocation(200,100);
		this.init_keyevent();
		this.init_gamepan();
		this.init_timer();
		// this.setBounds(200, 100, 400, 300);//////////이렇게 하면 고정됨 즉, 가로와, 세로는 필요가 없다.
		this.setLocation(200, 100);//////////////// 좌표는 설정함.

		this.setResizable(false);///////////// 사이즈 변경 못하게 함.
		this.pack(); //////// 가로와 세로의 길이를 위임함. 즉, 밑의 코드가 알아서 하게 냅둔다는 의미. 자식윈도우 기준으로 테두리 씌움.

		this.setVisible(true); /// paintComponent도 이 떄 그려진다.

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_timer() {
		// TODO Auto-generated method stub

		//////////////////// 로컬 & 익명 내부클래스
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				process();// 좌표변경등 작업

				gamePan.repaint();

			}

		};

		timer = new Timer(10, listener);
		timer.start();
	}

	protected void process() {
		// TODO Auto-generated method stub
		move_ball();

	}

	int gan = 10;

	private void move_ball() {
		// TODO Auto-generated method stub
		if (bRight)
			ball_x += gan;
		else
			ball_x -= gan;

		if (ball_x + ball_size > MyConst.GAME_W) {
			ball_x = MyConst.GAME_W - ball_size;
			bRight = false;
		} else if (ball_x <= 0) {
			ball_x = 0;
			bRight = true;
		}

		if (bDown)
			ball_y += gan;
		else
			ball_y -= gan;

		if (ball_y + ball_size > MyConst.GAME_H) {
			ball_y = MyConst.GAME_H - ball_size;
			bDown = false;
		} else if (ball_y <= 0) {
			ball_y = 0;
			bDown = true;
		}

	}

	private void init_gamepan() {

		class GamePan extends JPanel {///////////////// 로컬내부클래스

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				// super.paintComponent(g);
				// Dimension d = this.getSize();
				// System.out.println(ball_x);
				// System.out.println(ball_y);

				// test_draw(g);

				// try {
				// int n =2/0;
				// } catch (Exception e) {
				// // TODO: handle exception
				// e.printStackTrace();
				// }
				/////// paintComponent가 어덯게 출력되는지를 의도적으로 오류를 발생시켜 stackTrace한 것.

				g.clearRect(0, 0, MyConst.GAME_W, MyConst.GAME_H);
				
				g.setColor(c);
				
				draw_ball(g);

			}

		}

		gamePan = new GamePan();///////////// 익명내부클래스는 나중에해보자.

		this.add(gamePan, "Center");///////// 현재 프레임의 중앙에 넣는다.

		Dimension dim = new Dimension(MyConst.GAME_W, MyConst.GAME_H);///////////////// 게임판의 크기설정을 하는 것으로 폭 높이를 관리하는
																		///////////////// 자료형이다. 그것을 Dimension이라고 한다.

		gamePan.setPreferredSize(dim);

	}

	public void init_keyevent() {
		// TODO Auto-generated method stub

		KeyListener key_listen = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ESCAPE) {
					if (!stop) {
						stop = true;
						timer.stop();
					} else {
						stop = false;
						timer.restart();
					}
				}

				if (key == KeyEvent.VK_LEFT)
					bRight = false;
				else if (key == KeyEvent.VK_RIGHT)
					bRight = true;
				else if (key == KeyEvent.VK_UP)
					bDown = false;
				else if (key == KeyEvent.VK_DOWN)
					bDown = true;
				else if (key == KeyEvent.VK_ADD) {
					System.out.println(ball_size);
					if (!(ball_size >= 200))
						ball_size++;
				} else if (key == KeyEvent.VK_SUBTRACT) {
					System.out.println(ball_size);
					if (!(ball_size <= 10))
						ball_size--;
				}else if (key == KeyEvent.VK_SPACE) {
					System.out.println(key);
					System.out.println(red);
					System.out.println(green);
					System.out.println(blue);

					if(red> 255)
						red =0;
					else if(red<0)
						red =255;
					if(green > 255)
						green = 0;
					else if(green<0)
						green =255;
					if(blue > 255)
						blue =0;
					else if(blue <0)
						blue= 255;
					c= new Color(red++,green--,blue++);
					System.out.println(c);
				}

			}
		};

		this.addKeyListener(key_listen);

	}

	public void draw_ball(Graphics g) {
		
		//g.setColor(Color(this.red,this.green,this.blue));
		
		g.fillOval(ball_x, ball_y, ball_size, ball_size);

	}

	public void test_draw(Graphics g) {
		int x = 30, y = 50;
		Font font = new Font("굴림체", Font.BOLD, 20);
		g.setFont(font);
		g.drawString("안녕하세요 점심먹고 하죠!!", x, y); /// 지금 현재 기준점이 틀리다.

		g.drawLine(0, y, 100, y); // 처음 시작점 x,y 나중에 끝나는 x,y
		g.drawLine(x, 0, x, 100);

		g.drawString("비쳐?", 260, 130);

		g.drawRect(100, 100, 120, 120);
		Color color = new Color(0, 255, 0, 120);
		g.setColor(color);
		g.fillRect(100 + 150, 100, 120, 120);

		g.drawOval(100, 250, 100, 100);
		g.setColor(Color.MAGENTA);
		g.fillOval(100 + 150, 250, 100, 100);                                                                               

	}

	public static void main(String[] args) {
		new MyMain_BallMove();

	}

}