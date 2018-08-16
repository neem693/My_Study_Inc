package ox_survive;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import images.Images;
import main.MyConst;
import pv.Character_ox;
import utill.Character_Manager;
import utill.Pan;

public class Ox_Suvive extends JFrame {
	public static int gap_w = (int) (MyConst.GAME_W * MyConst.XPAN_W * 0.1 * 0.75);
	JPanel full;
	JPanel main_ox;
	JPanel show_panel;
	Pan xpan;
	Pan opan;
	Character_Manager chManager;
	Random rand = new Random();
	KeyAdapter adapter;
	Timer timer;
	GameOver gameover;

	CardLayout card;

	JButton jbt_start;
	JButton jbt_exit;

	public Ox_Suvive() {
		super("내가만든 윈도우");

		card = new CardLayout();
		show_panel = new JPanel(card);
		show_panel.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));

		init_pan();
		this.setResizable(false);
		init_button();

		init_event();
		init_game();
		init_timer();
		init_sound("music/BGM.wav", true);

		this.setLocation(200, 100);
		// this.setBounds(200, 100, MyConst.GAME_W, MyConst.GAME_H);
		this.pack();
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card.show(show_panel, "main");

	}

	private void init_sound(String file, boolean b) {
		// TODO Auto-generated method stub
		try {

			AudioInputStream bgm = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			Clip clip = AudioSystem.getClip();
			clip.open(bgm);
			clip.start();
			if (b) {
				clip.loop(-1);
			}

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	private void init_button() {
		// TODO Auto-generated method stub
		jbt_start = new JButton(new ImageIcon(Images.START.getImage()));
		jbt_exit = new JButton(new ImageIcon(Images.EXIT.getImage()));

		jbt_exit.setFocusPainted(false);
		jbt_exit.setBorderPainted(false);
		jbt_exit.setContentAreaFilled(false);

		jbt_start.setFocusPainted(false);
		jbt_start.setBorderPainted(false);
		jbt_start.setContentAreaFilled(false);

		jbt_start.setBounds(0, 285, 250, 350);
		jbt_exit.setBounds(1030, 285, 250, 350);

		main_ox.setLayout(null);
		main_ox.add(jbt_start, "West");
		main_ox.add(jbt_exit, "East");

	}

	private void init_game() {
		// TODO Auto-generated method stub
		gameover = new GameOver(chManager, full);
		gameover.nextRound();

	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				full.repaint();

			}
		};

		timer = new Timer(10, listener);
		// timer.start();

	}

	protected void process() {
		// TODO Auto-generated method stub
		chManager.move();
		gameover.count_up();
		if (gameover.count_zero()) {
			gameover.lets_kill();
		}
		if (!gameover.isRound)
			gameover.nextRound();
		if (gameover.gameover || gameover.win)
			timer.stop();

		// gameover.
	}

	private void init_event() {
		// TODO Auto-generated method stub
		adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_UP) {
					System.out.println("업");
				}

				if (chManager.getCh_user() != null && gameover.isQuetioning()) {
					if (key == KeyEvent.VK_RIGHT) {
						chManager.user_goto(xpan, chManager.getCh_user());
						System.out.println("작동중");
					}
					if (key == KeyEvent.VK_LEFT) {
						chManager.user_goto(opan, chManager.getCh_user());
						System.out.println("작동중");
					}

				}
				if (key == KeyEvent.VK_SPACE && (gameover.gameover || gameover.win)) {
					gameover.gameRestart(timer);
					System.out.println("다시시작");
				}

			}
		};
		this.addKeyListener(adapter);

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jbt_start == e.getSource()) {
					card.show(show_panel, "game");
					timer.start();
					Ox_Suvive.this.requestFocusInWindow(true);// 이걸 해야지만 해당하는 프레임이 포커스가 된다. 따라서 키 이벤트가 작동한다.
				}
				if (jbt_exit == e.getSource()) {
					System.exit(0);
				}
			}
		};

		jbt_start.addActionListener(action);
		jbt_exit.addActionListener(action);

	}

	private void init_pan() {
		// TODO Auto-generated method stub
		int border = (int) (MyConst.GAME_W * 0.05);
		int width = Pan.WIDTH;
		int height = Pan.HEIGHT;

		opan = new Pan(Pan.OPAN, 0 + border, 0 + border);
		xpan = new Pan(Pan.XPAN, MyConst.GAME_W - border - width, 0 + border);
		chManager = new Character_Manager(opan, xpan, Character_Manager.HEAVY, 1);

		/////////// 테스트
		// for(int i=0;i<10;i++) {
		// for(int j=0;j<5;j++) {
		// System.out.printf("%02d ",xpan.ch_lo[i][j].getPriority());
		// }
		// System.out.println();
		// }

		// priority 제대로 동작하느냐 테스트
		// for(int i =0;i<50;i++) {
		// System.out.println(xpan.ch_priority_lo[i].getPriority());
		// }
		full = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				//// 이 때 쯤에 배경화면 하나 추가하자.

				g.drawImage(Images.BACKGROUND, 0, 0, null);

//				g.drawRect(0 + border, 0 + border, width, height);
//				g.drawRect(MyConst.GAME_W - border - width, 0 + border, width, height);
				chManager.draw(g);
				gameover.draw_count(g);
				gameover.munje_show(g);
				if (gameover.gameover || gameover.win)
					gameover.end_game(g);
				if (!gameover.quetioning) {
					gameover.lets_check_munje(g);
				}

				// 그리기 테스트 이다.
				// for (int i = 0; i < xpan.ch_lo.length; i++) {
				// for (int j = 0; j < xpan.ch_lo[i].length; j++) {
				// if (rand.nextInt() % 2 == 0)
				// g.drawImage(Images.RYON, xpan.ch_lo[i][j].getCharacter_start_w(),
				// xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT,
				// null);
				// else
				// g.drawImage(Images.APEACHE, xpan.ch_lo[i][j].getCharacter_start_w(),
				// xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT,
				// null);
				//
				// }
				// }
				//
				// for (int i = 0; i < opan.ch_lo.length; i++) {
				// for (int j = 0; j < opan.ch_lo[i].length; j++) {
				// if (rand.nextInt() % 2 == 0)
				// g.drawImage(Images.RYON, opan.ch_lo[i][j].getCharacter_start_w(),
				// opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT,
				// null);
				// else
				// g.drawImage(Images.APEACHE, opan.ch_lo[i][j].getCharacter_start_w(),
				// opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT,
				// null);
				//
				// }
				// }
			}
		};

		full.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		show_panel.add(full, "game");

		main_ox = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(Images.MAIN_BACK.getImage(), 0, 0, null);

			}
		};
		main_ox.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		show_panel.add(main_ox, "main");

		this.add(show_panel);

	}

	public static void main(String[] args) {
		new Ox_Suvive();
	}

}