package mymain;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyMain_Dung extends JFrame {
	ActionListener acL;
	JPanel gamePan;
	JMenuBar jbar;
	JMenu option;
	JMenuItem start_item;
	JMenuItem restart_item;
	JMenuItem exit_item;
	int key_state;
	BulletManager bulletManager = new BulletManager();

	Bate bate = new Bate(bulletManager);
	ExplosionManager explosionManager = new ExplosionManager();
	DDongManager ddongManager = new DDongManager(explosionManager);
	Timer timer;
	IsGameOver gameOver;

	public MyMain_Dung() {
		super("내가만든 윈도우");
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		init_gamePan();

		init_timer();
		init_mouse_event();
		init_gameOver();
		init_button_pan();
		this.setResizable(false);

		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_button_pan() {
		// TODO Auto-generated method stub
		jbar = new JMenuBar();
		option = new JMenu("옵션");
		start_item = new JMenuItem("시작");
		restart_item = new JMenuItem("재시작");
		exit_item = new JMenuItem("종료");

		option.add(start_item);
		option.add(restart_item);
		option.add(exit_item);

		jbar.add(option);

		this.setJMenuBar(jbar);

		acL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object event = e.getSource();
				String cmd = e.getActionCommand();
				if (event instanceof JMenuItem) {
					if (cmd.equals("시작")) {
						//gameOver.initGame();
						timer.start();
						System.out.println("시작");
						start_item.setEnabled(false);
					}
					if(cmd.equals("재시작")) {
						gameOver.initGame();
						timer.start();
						
					}
					
					if(cmd.equals("종료")) {
						System.exit(0);
					}
				}

			}
		};
		start_item.addActionListener(acL);
		restart_item.addActionListener(acL);
		exit_item.addActionListener(acL);

	}

	private void init_gameOver() {
		// TODO Auto-generated method stub
		gameOver = new IsGameOver(ddongManager, bate, timer, explosionManager);

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub

		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				explosionManager.make_explosion(e.getX(), e.getY());
			}
		};

		gamePan.addMouseListener(adapter);

		KeyListener keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT)
					key_state = key_state | MyConst.Key.LEFT;
				if (key == KeyEvent.VK_RIGHT)
					key_state = key_state | MyConst.Key.RIGHT;
				if (key == KeyEvent.VK_UP)
					key_state = key_state | MyConst.Key.UP;
				if(key == KeyEvent.VK_F)
					key_state = key_state | MyConst.Key.FIRE;
				

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT)
					key_state = key_state ^ MyConst.Key.LEFT;
				if (key == KeyEvent.VK_RIGHT)
					key_state = key_state ^ MyConst.Key.RIGHT;
				if (key == KeyEvent.VK_UP)
					key_state = key_state ^ MyConst.Key.UP;
				if (key == KeyEvent.VK_F)
					key_state = key_state ^ MyConst.Key.FIRE;
				

			}

		};
		this.addKeyListener(keyListener);

	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				// Rectangle rect = new Rectangle(0,0,100,100);
				gamePan.repaint();
			}
		};
		timer = new Timer(10, listener);
		// timer.start();
	}

	protected void process() {
		// TODO Auto-generated method stub
		// 똥생성
		ddongManager.make_ddong();
		// 똥이동
		ddongManager.move();
		explosionManager.move();
		bate.setKey_state(key_state);
		bate.move();
		if (gameOver.isGameOver())
			JOptionPane.showMessageDialog(this, "Game Over");
		bulletManager.move();
		gameOver.collision_bullet_and_ddong();
	}

	private void init_gamePan() {
		// TODO Auto-generated method stub
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				g.clearRect(0, 0, MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H);

				ddongManager.draw(g);
				explosionManager.draw(g);
				bate.draw(g);
				gameOver.draw(g);
				bulletManager.draw(g);

			}
		};

		gamePan.setPreferredSize(new Dimension(MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H));
		this.add(gamePan);

	}

	public static void main(String[] args) {
		new MyMain_Dung();

	}

}