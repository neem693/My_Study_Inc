package mymain;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MyMain_KeyEvent extends JFrame implements KeyListener,ActionListener {
	
	//왜 값을 줄까?
	//이진논리연산을 잘 정의하기 위해서다.
	//이 점을 잘 알아두자.
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int RIGHT = 4;
	public static final int DOWN = 8;
	public static final int FIRE = 16;
	public static final int LEFTUP = LEFT | UP;
	public static final int LEFTDOWN = LEFT | DOWN;
	public static final int RIGHTUP = RIGHT|UP;
	public static final int RIGHTDOWN = RIGHT | DOWN;
	
	
	public int key_state=0;

	public MyMain_KeyEvent() {
		super("내가만든 윈도우");
		
		this.addKeyListener(this);
		
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init_timer();
	}

	private void init_timer() {
		Timer timer = new Timer(10,this);
		timer.start(); //구동
	
	}

	public static void main(String[] args) {
		new MyMain_KeyEvent();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT)
			key_state = key_state | LEFT;
		else if(key == KeyEvent.VK_RIGHT)
			key_state = key_state | RIGHT;
		else if(key == KeyEvent.VK_DOWN)
			key_state = key_state | DOWN;
		else if(key == KeyEvent.VK_UP)
			key_state = key_state | UP;
		else if(key == KeyEvent.VK_F)
			key_state = key_state | FIRE;
		
		fire();
		move_window();
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT)
			key_state = key_state ^ LEFT;
		else if(key == KeyEvent.VK_RIGHT)
			key_state = key_state ^ RIGHT;
		else if(key == KeyEvent.VK_DOWN)
			key_state = key_state ^ DOWN;
		else if(key == KeyEvent.VK_UP)
			key_state = key_state ^ UP;
		else if(key == KeyEvent.VK_F)
			key_state = key_state ^ FIRE;
		
		fire();
		move_window();
		
	}

	private void move_window() {
		// TODO Auto-generated method stub
		Point pt = getLocation();
		int gan = 10;
		//and 연산 하는 이유를 한번 잘 생각해보자. 
		//사실 이건 방향키다.
		//그러나 게임을 할 떄에도 방향키만 누르지 않는다.
		//다른 키를 같이 누른다.
		//그래서 and연산을 하는 것이다.
		
		if((key_state & LEFTUP) == LEFTUP) {
			pt.x -= gan;
			pt.y -= gan;
		}else if((key_state & LEFTDOWN) == LEFTDOWN) {
			pt.x -= gan;
			pt.y += gan;
			
		}else if((key_state & RIGHTUP) == RIGHTUP) {
			pt.x += gan;
			pt.y -= gan;
			
		}else if((key_state & RIGHTDOWN) == RIGHTDOWN) {
			pt.x += gan;
			pt.y += gan;
		}else if((key_state & RIGHT) == RIGHT) {
			pt.x += gan;
			
		}else if((key_state & LEFT) == LEFT) {
			pt.x -= gan;
			
		}else if((key_state & UP) == UP) {
			pt.y -= gan;
		}else if((key_state & DOWN) == DOWN) {
			
			pt.y += gan;
		}
		setLocation(pt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("------------");//1초당 계속 출력됨.Timer timer = new Timer(1000,this); 이렇게 했을 때.
		move_window(); //100fps 즉, 10ms 즉, 1000/10 ms를 말함.
		
	}

	private void fire() {
		// TODO Auto-generated method stub
		if((key_state & FIRE) == FIRE)
			System.out.println("--FIRE--");
	}


}