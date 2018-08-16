package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import myutil.MyConst;

public class Nunal extends JFrame {

	static BufferedImage img;

	static {
		try {
			img = ImageIO.read(new File("¿Õ´«ÀÌ.jpg"));
			MyConst.GAME_W = img.getWidth();
			MyConst.GAME_H = img.getHeight();
		} catch (Exception e) {

		}
	}

	Rectangle ball_rect;
	Rectangle rect_left, rect_right;
	Rectangle ballL, ballR, ballD, ballU;
	Rectangle RballL, RballR, RballD, RballU;
	JPanel gamePan;
	Timer timer;
	int ballsize, ball_x, ball_y;
	boolean bRight = true, bDown = true;
	Point eye_left, eye_right, eyeball_left, eyeball_right;
	int eye_radius, eyeball_radius;

	public Nunal() {

		super("´«¾Ë±¼¸®±â");
		// ±×¸²ÆÇ ÃÊ±âÈ­

		init_gamepan();

		// ´«¾ËÀÇ ÁÂÇ¥ ÃÊ±âÈ­

		init_eye_position();
		init_eyeball_position();

		init_ball();
		init_mouse_event();
		this.setLocation(200, 100);
		this.setResizable(false);
		this.pack();
		// this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init_timer();
	}

	private void init_timer() {

		ActionListener listner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				move_ball();

				Point pt = new Point();
				pt.x = ball_x;
				pt.y = ball_y;
				right_eyeball_position(pt);
				left_eyeball_position(pt);

				gamePan.repaint();

				work_rect(pt);

			}
		};
		timer = new Timer(10, listner);
		timer.start();

	}

	protected void work_rect(Point pt) {
		double x, y;
		x = eye_left.x - eye_radius;
		y = eye_left.y;

		rect_left = new Rectangle(eye_left.x - eye_radius + 5, eye_left.y - eye_radius + 5, eye_radius * 2 - 15,
				eye_radius * 2 - 15);
		rect_right = new Rectangle(eye_right.x - eye_radius + 5, eye_right.y - eye_radius + 5, eye_radius * 2 - 15,
				eye_radius * 2 - 15);

		ball_rect = new Rectangle(ball_x, ball_y, ballsize, ballsize);

		if (ball_rect.intersects(ballL)) {
			System.out.println("left");
			bRight = false;
		}
		if (ball_rect.intersects(ballR)) {
			System.out.println("Right");
			bRight = true;

		}
		if (ball_rect.intersects(ballD)) {
			System.out.println("Down");
			bDown = true;

		}
		if (ball_rect.intersects(ballU)) {
			System.out.println("Up");
			bDown = false;

		}
		
		
		
		if (ball_rect.intersects(RballL)) {
			System.out.println("left");
			bRight = false;
		}
		if (ball_rect.intersects(RballR)) {
			System.out.println("Right");
			bRight = true;

		}
		if (ball_rect.intersects(RballD)) {
			System.out.println("Down");
			bDown = true;

		}
		if (ball_rect.intersects(RballU)) {
			System.out.println("Up");
			bDown = false;

		}
		// boolean left_eye = rect_left.contains(pt);
		// boolean right_eye = rect_right.contains(pt);

		// if(left_eye) {
		// bDown = !bDown;
		// bRight = !bRight;
		// }

		// if(ballR.contains((int)x,(int)y)) {
		// System.out.println("left");
		// bRight = false;
		// }
		// x= eye_left.x+eye_radius;
		// if(ballL.contains((int)x,(int) y)) {
		// System.out.println("right");
		// bRight = true;
		// }
		// x=eye_left.x;
		// y= eye_left.y - eye_radius;
		//
		// if(ballD.contains((int)x,(int) y)) {
		// System.out.println("Up");
		// bDown = false;
		// }
		//
		// y= eye_left.y + eye_radius;
		//
		// if(ballD.contains((int)x,(int) y)) {
		// System.out.println("Down");
		// bDown = true;
		// }

	}

	protected void move_ball() {
		if (bRight) {
			ball_x += 2;
		} else
			ball_x -= 3;
		if (bDown)
			ball_y += 2;
		else
			ball_y -= 3;

		if (ball_x >= (img.getWidth(null) - ballsize)) {

			bRight = false;
			ball_x = MyConst.GAME_W - ballsize;
		} else if (ball_x <= 0)
			bRight = true;
		if (ball_y >= img.getHeight(null) - ballsize) {
			bDown = false;
			ball_y = MyConst.GAME_H - ballsize;
		} else if (ball_y <= 0)
			bDown = true;

	}

	private void init_ball() {
		ballsize = eye_radius / 2;
		ball_x = 185;
		ball_y = 165;

		int rect_xL = eye_left.x - eye_radius + 5;
		int rect_xR = eye_right.x - eye_radius + 5;
		int rect_yL = eye_left.y - eye_radius + 5;
		int rect_yR = eye_right.y - eye_radius + 5;

		// g.drawRect(rect_xL, rect_yL, 5, eye_radius *2 -15);
		// g.drawRect(rect_xL, rect_yL, eye_radius * 2 -15, 5);
		// g.drawRect(rect_xL, rect_yL + eye_radius*2 -15 -5, eye_radius * 2 -15, 5);
		// g.drawRect(rect_xL + eye_radius*2 -15 -5, rect_yL, 5, eye_radius * 2 -15);
		

		

		ballL = new Rectangle(rect_xL, rect_yL, 5, eye_radius * 2 - 15);
		ballR = new Rectangle(rect_xL + eye_radius * 2 - 15 - 5, rect_yL, 5, eye_radius * 2 - 15);

		ballU = new Rectangle(rect_xL, rect_yL, eye_radius * 2 - 15, 5);
		ballD = new Rectangle(rect_xL, rect_yL + eye_radius * 2 - 15 - 5, eye_radius * 2 - 15, 5);
		
		
		
		rect_xL = eye_right.x - eye_radius + 5;
		rect_xR = eye_right.x - eye_radius + 5;
		rect_yL = eye_right.y - eye_radius + 5;
		rect_yR = eye_right.y - eye_radius + 5;
		
		RballL = new Rectangle(rect_xL, rect_yL, 5, eye_radius * 2 - 15);
		RballR = new Rectangle(rect_xL + eye_radius * 2 - 15 - 5, rect_yL, 5, eye_radius * 2 - 15);

		RballU = new Rectangle(rect_xL, rect_yL, eye_radius * 2 - 15, 5);
		RballD = new Rectangle(rect_xL, rect_yL + eye_radius * 2 - 15 - 5, eye_radius * 2 - 15, 5);
		
		
	}

	private void init_mouse_event() {
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				System.out.println(e);
				Point pt = e.getPoint();
				// ¿ÞÂÊ ´«¾Ë Áß½ÉÁÂÇ¥ ±¸ÇÏ±â
				left_eyeball_position(pt);
				// ¿À¸¥ÂÊ ´«¾Ë Áß½ÉÁÂÇ¥ ±¸ÇÏ±â
				right_eyeball_position(pt);
				gamePan.repaint();
				// timer.stop();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				init_eyeball_position();
				gamePan.repaint();
				timer.start();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				System.out.println(e);
				Point pt = e.getPoint();
				// ¿ÞÂÊ ´«¾Ë Áß½ÉÁÂÇ¥ ±¸ÇÏ±â
				left_eyeball_position(pt);
				// ¿À¸¥ÂÊ ´«¾Ë Áß½ÉÁÂÇ¥ ±¸ÇÏ±â
				right_eyeball_position(pt);
				gamePan.repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);

				Point pt = e.getPoint();

				zero_point();

			}
		};
		// gamePan¿¡ ¸¶¿ì½º ÀÌº¥Æ® ¼³Á¤
		gamePan.addMouseListener(adapter);// pressed,released,entered,exited,clicked
		gamePan.addMouseMotionListener(adapter);// draged,moved
	}

	protected void zero_point() {
		// TODO Auto-generated method stub

	}

	protected void right_eyeball_position(Point pt) {
		int xx = pt.x - eye_right.x;
		int yy = pt.y - eye_right.y;
		double r = Math.sqrt(xx * xx + yy * yy);
		double right_rate = eyeball_radius / r;
		eyeball_right.x = (int) (eye_right.x + xx * right_rate);
		eyeball_right.y = (int) (eye_right.y + yy * right_rate);
	}

	protected void left_eyeball_position(Point pt) {
		int xx = pt.x - eye_left.x;
		int yy = pt.y - eye_left.y;
		double r = Math.sqrt(xx * xx + yy * yy);
		double left_rate = eyeball_radius / r;
		eyeball_left.x = (int) (eye_left.x + xx * left_rate);
		eyeball_left.y = (int) (eye_left.y + yy * left_rate);
	}

	private void init_eyeball_position() {
		eyeball_left = new Point(eye_left.x, eye_left.y);
		eyeball_right = new Point(eye_right.x, eye_right.y);
		eyeball_radius = eye_radius / 2;
	}

	private void init_eye_position() {
		// ¿ÞÂÊ ´« Áß½ÉÁÂÇ¥

		eye_left = new Point();
		eye_left.x = 139;
		eye_left.y = 118;
		// ¿À¸¥ÂÊ ´« Áß½ÉÁÂÇ¥
		eye_right = new Point();
		eye_right.x = 248;
		eye_right.y = 116;
		// ´«ÀÇ ¹ÝÁö¸§
		eye_radius = 45;
		rect_left = new Rectangle(eye_left.x - eye_radius + 5, eye_left.y - eye_radius + 5, eye_radius * 2 - 15,
				eye_radius * 2 - 15);
		rect_right = new Rectangle(eye_right.x - eye_radius + 5, eye_right.y - eye_radius + 5, eye_radius * 2 - 15,
				eye_radius * 2 - 15);
	}

	private void init_gamepan() {

		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawString("´«¾Ë±×¸®±â", 10, 60);
				g.clearRect(0, 0, MyConst.GAME_W, MyConst.GAME_H);
				g.drawImage(img, 0, 0, this);
				g.setColor(new Color(255, 255, 0));

				// ball
				g.fillOval(ball_x, ball_y, ballsize, ballsize);

				// g.drawRect(ball_x, ball_y-ballsize, ballsize, ballsize);
				// g.drawRect(ball_x, ball_y+ballsize, ballsize, ballsize);
				// g.drawRect(ball_x+ballsize, ball_y, ballsize, ballsize);
				// g.drawRect(ball_x-ballsize, ball_y, ballsize, ballsize);

				// ball_rect
				// ballU = new Rectangle(ball_x, ball_y-ballsize, ballsize, ballsize);
				// ballD = new Rectangle(ball_x, ball_y+ballsize, ballsize, ballsize);
				// ballR = new Rectangle(ball_x+ballsize, ball_y, ballsize, ballsize);
				// ballL = new Rectangle(ball_x-ballsize, ball_y, ballsize, ballsize);

				g.setColor(new Color(255, 255, 255));
				g.fillOval(eye_left.x - eye_radius, eye_left.y - eye_radius, eye_radius * 2, eye_radius * 2);
				g.fillOval(eye_right.x - eye_radius, eye_right.y - eye_radius, eye_radius * 2, eye_radius * 2);

				g.setColor(new Color(0, 0, 0));
				g.fillOval(eyeball_left.x - eyeball_radius, eyeball_left.y - eyeball_radius, eyeball_radius * 2,
						eyeball_radius * 2);
				g.fillOval(eyeball_right.x - eyeball_radius, eyeball_right.y - eyeball_radius, eyeball_radius * 2,
						eyeball_radius * 2);

				//g.fillOval(eye_left.x - eye_radius, eye_left.y, 5, 5);
				//g.fillOval(eye_left.x, eye_left.y + eye_radius, 5, 5);

				int rect_xL = eye_left.x - eye_radius + 5;
				int rect_xR = eye_right.x - eye_radius + 5;
				int rect_yL = eye_left.y - eye_radius + 5;
				int rect_yR = eye_right.y - eye_radius + 5;

				g.drawRect(rect_xL, rect_yL, 5, eye_radius * 2 - 15);
				g.drawRect(rect_xL, rect_yL, eye_radius * 2 - 15, 5);
				g.drawRect(rect_xL, rect_yL + eye_radius * 2 - 15 - 5, eye_radius * 2 - 15, 5);
				g.drawRect(rect_xL + eye_radius * 2 - 15 - 5, rect_yL, 5, eye_radius * 2 - 15);

				rect_xL = eye_right.x - eye_radius + 5;
				rect_xR = eye_right.x - eye_radius + 5;
				rect_yL = eye_right.y - eye_radius + 5;
				rect_yR = eye_right.y - eye_radius + 5;
				
				g.drawRect(rect_xL, rect_yL, 5, eye_radius * 2 - 15);
				g.drawRect(rect_xL, rect_yL, eye_radius * 2 - 15, 5);
				g.drawRect(rect_xL, rect_yL + eye_radius * 2 - 15 - 5, eye_radius * 2 - 15, 5);
				g.drawRect(rect_xL + eye_radius * 2 - 15 - 5, rect_yL, 5, eye_radius * 2 - 15);

				// ·ºÅÊ±Û
//				g.drawRect(eye_left.x - eye_radius + 5, eye_left.y - eye_radius + 5, eye_radius * 2 - 15,
//						eye_radius * 2 - 15);
//				g.drawRect(eye_right.x - eye_radius + 5, eye_right.y - eye_radius + 5, eye_radius * 2 - 15,
//						eye_radius * 2 - 15);

			}
		};
		// Å©±â¿¹¾à
		gamePan.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		this.add(gamePan, "Center");
	}

	public static void main(String[] args) {
		new Nunal();
	}
}
