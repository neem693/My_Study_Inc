import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Blue_Marble extends JFrame {

	Timer timer, t;
	static Player play = new Player("사용자", 1000000); // 유저1 객체 생성( 사용자이름 , 초기자본)

	static Player play2 = new Player("사용자2", 1000000); // 유저2 객체 생성( 사용자이름 , 초기자본)

	public static final int index_interval = 30;
	int interval = 0;

	Contry con = new Contry();
	JPanel BlueGamePan; // 게임판 가즈아!!!!!!!!!!!!!!!
	Buy_Sell_new nbs;
	public JTextArea jta_chat;
	public JTextArea jta_ai_chat;
	JPanel p;

	JButton jbt_buy = new JButton(new ImageIcon(
			((new ImageIcon("Button/구매.png")).getImage()).getScaledInstance(75, 70, java.awt.Image.SCALE_SMOOTH)));
	/*
	 * JButton jbt_sell = new JButton(new ImageIcon( ((new
	 * ImageIcon("판매1.png")).getImage()).getScaledInstance(120, 50,
	 * java.awt.Image.SCALE_SMOOTH)));
	 */
	JButton jbt_pass = new JButton(new ImageIcon(
			((new ImageIcon("Button/턴종료.png")).getImage()).getScaledInstance(75, 70, java.awt.Image.SCALE_SMOOTH)));
	JButton jbt_dice = new JButton(new ImageIcon(
			((new ImageIcon("Button/주사위.png")).getImage()).getScaledInstance(130, 140, java.awt.Image.SCALE_SMOOTH)));// 160,60

	Image pic = Contry_Class.back_img;
	static Image Image_back = new ImageIcon("contry_img/Blue_iF_back.png").getImage();
	static Image boom = new ImageIcon("contry_img/test_back.gif").getImage(); // 주사위 이벤트
	static Image dic_img = new ImageIcon("dice.gif").getImage();

	static Image back = Image_back;
	static Image[] img_exp = new Image[4];
	static {
		for (int i = 0; i < img_exp.length; i++)// i = 0~4
		{
			String filename = String.format("dice/exp_%02d.png", i + 1);
			img_exp[i] = new ImageIcon(filename).getImage();
			continue;
		}
	}

	Random rand = new Random(); // 랜덤함수 설정
	int index = 0;
	int move_count = 0;
	int interval_count = 0;
	int my_index = -1; /// 초기 나의 위치 (my_index+1)부터 시작이므로 0부터 시작하기 위해 -1 대입
	int play2_index = -1; /// 초기 나의 위치 (my_index+1)부터 시작이므로 0부터 시작하기 위해 -1 대입
	int dice_size = 100;
	public double dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // 볼의x좌표
	double dice_y = 500 - dice_size; // 볼의y좌표
	////////////////////////////////////////////////////////////
	public double v = 30; // 초기 볼의 속도
	public final double v_first = 6; // 초기 볼의 속도 고정
	public double vx; // x좌표의 이동변화량 계산
	double vy; // y좌표의 이동변화량 계산
	public double angle = 15; // 볼의 각도
	public double h = 1; // 시간
	public double g = 0.2; // 중력가속도
	public double changh = 1;
	public double changh_buf = 0.1;
	public int dice_effet_count = 0;
	public int round = 0;
	public int round_ai = 0;

	//////////////////////////////////////////////////////////// 주사위의 움직임 계산변수

	public static int dice_num = 0;
	public static int dice_count = 0;
	public static int my_place_stack = 1;
	public static int play2_place_stack = 1;
	static String chat5 = "";
	static String chat6 = "";
	static int fine = 200000;
	int sqr_n = rand.nextInt(11); // 0~11

	public boolean click_check = false;
	public boolean now_moving = true;
	public boolean dice_moving = true;
	public static boolean turn = false; // false가 주인공
	public boolean char_move = true;
	public boolean fail_check_stats = false;

	public int delay_count = 0;

	// 나라 객체 16개 생성

	public static List<Contry> con_col = new ArrayList<Contry>();

	static JButton 독일 = new JButton("독일");
	static JButton 노르웨이 = new JButton("노르웨이");
	static JButton 러시아 = new JButton("러시아");
	static JButton 루마니아 = new JButton("루마니아");
	static JButton 스웨덴 = new JButton("스웨덴");
	static JButton 필란드 = new JButton("필란드");
	static JButton 스페인 = new JButton("스페인");
	static JButton 아일랜드 = new JButton("아일랜드");
	static JButton 이탈리아 = new JButton("이탈리아");
	static JButton 중국 = new JButton("중국");
	static JButton 일본 = new JButton("일본");
	static JButton 헝가리 = new JButton("헝가리");
	static JButton 독일_ai = new JButton("독일");
	static JButton 노르웨이_ai = new JButton("노르웨이");
	static JButton 러시아_ai = new JButton("러시아");
	static JButton 루마니아_ai = new JButton("루마니아");
	static JButton 스웨덴_ai = new JButton("스웨덴");
	static JButton 필란드_ai = new JButton("필란드");
	static JButton 스페인_ai = new JButton("스페인");
	static JButton 아일랜드_ai = new JButton("아일랜드");
	static JButton 이탈리아_ai = new JButton("이탈리아");
	static JButton 중국_ai = new JButton("중국");
	static JButton 일본_ai = new JButton("일본");
	static JButton 헝가리_ai = new JButton("헝가리");

	public Blue_Marble() {

		super("블루마블 공부용");

		init_contry_set(); // 나라 객체를 array_list에 쑤셔넣음 ㅇㅈ?

		
		/*  play.contry_stack[0]=5; play.contry_stack[1]=13;
		 
		  
		  play2.contry_stack[0]=2; play2.contry_stack[1]=3; play2.contry_stack[2]=4;
		  play2.contry_stack[3]=6; play2.contry_stack[4]=7; play2.contry_stack[5]=8;*/
		 

		init_game_pan();

		init_timer();

		init_display();

		init_sound("music/배경1.wav", true);

		nbs.active_button();
		nbs.active_button_ai();
		
		this.setLocation(200, 0);
		setResizable(true);
		pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_sound(String file, boolean Loop) {
		// TODO Auto-generated method stub
		// 배경 음악
		try {
			AudioInputStream bgm = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			// Clip인터페이스는 오디오 데이터를 재생 전에로드 할 수있는 특수한 종류의 데이터 라인을 나타냅니다.
			Clip clip = AudioSystem.getClip();
			clip.open(bgm);
			clip.start();
			if (Loop)
				clip.loop(-1); // 반복 재생

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); // 볼륨 컨트롤

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	static JLabel jlb_price;
	static JLabel jlb_building;
	static JLabel jlb_price_ai;
	static JLabel jlb_building_ai;

	public void init_display() {
		// TODO Auto-generated method stub
		// nbs = new buy_sell(this);
		nbs = new Buy_Sell_new(this);
		
		
		
		
		int count = 0;
		int count1 = 0;
		p = new JPanel(new GridLayout(2, 1));
		JPanel play1 = new JPanel(new BorderLayout());
		JPanel play2 = new JPanel(new GridLayout(9, 1));

		play2.add(new JLabel("Player"));
		play2.add(jlb_price = new JLabel());

		play2.add(new JLabel("총금액 : "));
		play2.add(jlb_price = new JLabel());

		jlb_price.setText(Blue_Marble.play.price + "원");// 초기 총금액 값

		play2.add(new JLabel("건물수 : "));
		play2.add(jlb_building = new JLabel());

		jlb_building.setText(count + "개");// 초기 호텔수 값

		play2.add(독일);
		play2.add(노르웨이);
		play2.add(러시아);
		play2.add(루마니아);
		play2.add(스웨덴);
		play2.add(필란드);
		play2.add(스페인);
		play2.add(아일랜드);
		play2.add(이탈리아);
		play2.add(중국);
		play2.add(일본);
		play2.add(헝가리);

		ActionListener my_play = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// 이벤트를 발생시킨 컨트롤,뭐가눌렸는지 모르기때문에 ob타입으로 받는다.

				if (evt_bt == 독일) {
					nbs.sell(2);
					독일.setEnabled(false);
				}

				else if (evt_bt == 노르웨이) {
					nbs.sell(3);
					노르웨이.setEnabled(false);

				} else if (evt_bt == 러시아) {
					nbs.sell(4);
					러시아.setEnabled(false);

				} else if (evt_bt == 루마니아) {
					nbs.sell(5);
					루마니아.setEnabled(false);

				} else if (evt_bt == 스웨덴) {
					nbs.sell(6);
					스웨덴.setEnabled(false);

				} else if (evt_bt == 필란드) {
					nbs.sell(7);
					필란드.setEnabled(false);

				} else if (evt_bt == 스페인) {
					nbs.sell(9);
					스페인.setEnabled(false);

				} else if (evt_bt == 아일랜드) {
					nbs.sell(10);
					아일랜드.setEnabled(false);

				} else if (evt_bt == 이탈리아) {
					nbs.sell(11);
					이탈리아.setEnabled(false);

				} else if (evt_bt == 중국) {
					nbs.sell(13);
					중국.setEnabled(false);

				} else if (evt_bt == 일본) {
					nbs.sell(14);
					일본.setEnabled(false);

				} else if (evt_bt == 헝가리) {
					nbs.sell(15);
					헝가리.setEnabled(false);

				}

				File file_sell = new File("music/판매.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
					// clip.loop(count);
				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

			}

		};

		독일.addActionListener(my_play);
		노르웨이.addActionListener(my_play);
		러시아.addActionListener(my_play);
		루마니아.addActionListener(my_play);
		스웨덴.addActionListener(my_play);
		필란드.addActionListener(my_play);
		스페인.addActionListener(my_play);
		아일랜드.addActionListener(my_play);
		이탈리아.addActionListener(my_play);
		중국.addActionListener(my_play);
		일본.addActionListener(my_play);
		헝가리.addActionListener(my_play);

		// Player용 채팅창
		jta_chat = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_chat);

		jta_chat.append(nbs.chat + ""); // 로그 내용을 JTextArea 위에 붙여주고
		jta_chat.setCaretPosition(jta_chat.getDocument().getLength()); // 맨아래로 스크롤한다.

		jta_chat.append(nbs.chat1 + ""); // 로그 내용을 JTextArea 위에 붙여주고
		jta_chat.setCaretPosition(jta_chat.getDocument().getLength()); // 맨아래로 스크롤한다.

		play1.add(play2, "North");// 현황판
		// play2.setPreferredSize(new Dimension(200, 100));

		play1.add(jsp, "Center");// 채팅창
		jsp.setPreferredSize(new Dimension(300, 500));

		p.add(play1, "Center");// play1 = BorderLayout 위치및 사이즈
		// play1.setPreferredSize(new Dimension(200, 1200));

		JPanel ai = new JPanel(new BorderLayout());
		JPanel ai2 = new JPanel(new GridLayout(9, 1));

		ai2.add(new JLabel("AI"));
		ai2.add(jlb_price_ai = new JLabel());

		ai2.add(new JLabel("총금액 : "));
		ai2.add(jlb_price_ai = new JLabel());

		jlb_price_ai.setText(Blue_Marble.play.price + "원");// 초기 총금액 값

		ai2.add(new JLabel("건물수 : "));
		ai2.add(jlb_building_ai = new JLabel());

		jlb_building_ai.setText(count1 + "개");// 초기 호텔수 값

		// AI용 채팅창
		jta_ai_chat = new JTextArea();
		JScrollPane jsp1 = new JScrollPane(jta_ai_chat);

		jta_ai_chat.append(nbs.chat_ai + ""); // 로그 내용을 JTextArea 위에 붙여주고
		jta_ai_chat.setCaretPosition(jta_ai_chat.getDocument().getLength()); // 맨아래로 스크롤한다.

		jta_ai_chat.append(nbs.chat_ai1 + ""); // 로그 내용을 JTextArea 위에 붙여주고
		jta_ai_chat.setCaretPosition(jta_ai_chat.getDocument().getLength()); // 맨아래로 스크롤한다.

		ai2.add(독일_ai);
		ai2.add(노르웨이_ai);
		ai2.add(러시아_ai);
		ai2.add(루마니아_ai);
		ai2.add(스웨덴_ai);
		ai2.add(필란드_ai);
		ai2.add(스페인_ai);
		ai2.add(아일랜드_ai);
		ai2.add(이탈리아_ai);
		ai2.add(중국_ai);
		ai2.add(일본_ai);
		ai2.add(헝가리_ai);

		ActionListener ai_play = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// 이벤트를 발생시킨 컨트롤,뭐가눌렸는지 모르기때문에 ob타입으로 받는다.

				if (evt_bt == 독일_ai) {
					//nbs.play2_sell(2);
					//독일_ai.setEnabled(false);
				}

				else if (evt_bt == 노르웨이_ai) {
					//nbs.play2_sell(3);
					//노르웨이_ai.setEnabled(false);

				} else if (evt_bt == 러시아_ai) {
					//nbs.play2_sell(4);
					//러시아_ai.setEnabled(false);

				} else if (evt_bt == 루마니아_ai) {
					//nbs.play2_sell(5);
					//루마니아_ai.setEnabled(false);

				} else if (evt_bt == 스웨덴_ai) {
					//nbs.play2_sell(6);
					//스웨덴_ai.setEnabled(false);

				} else if (evt_bt == 필란드_ai) {
					//nbs.play2_sell(7);
					//필란드_ai.setEnabled(false);

				} else if (evt_bt == 스페인_ai) {
					//nbs.play2_sell(9);
					//스페인_ai.setEnabled(false);

				} else if (evt_bt == 아일랜드_ai) {
					//nbs.play2_sell(10);
					//아일랜드_ai.setEnabled(false);

				} else if (evt_bt == 이탈리아_ai) {
					//nbs.play2_sell(11);
					//이탈리아_ai.setEnabled(false);

				} else if (evt_bt == 중국_ai) {
					//nbs.play2_sell(13);
					//중국_ai.setEnabled(false);

				} else if (evt_bt == 일본_ai) {
					//nbs.play2_sell(14);
					//일본_ai.setEnabled(false);

				} else if (evt_bt == 헝가리_ai) {
					//nbs.play2_sell(15);
					//헝가리_ai.setEnabled(false);

				}

				File file_sell = new File("music/판매.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
					// clip.loop(count);
				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

			}

		};

		독일_ai.addActionListener(ai_play);
		노르웨이_ai.addActionListener(ai_play);
		러시아_ai.addActionListener(ai_play);
		루마니아_ai.addActionListener(ai_play);
		스웨덴_ai.addActionListener(ai_play);
		필란드_ai.addActionListener(ai_play);
		스페인_ai.addActionListener(ai_play);
		아일랜드_ai.addActionListener(ai_play);
		이탈리아_ai.addActionListener(ai_play);
		중국_ai.addActionListener(ai_play);
		일본_ai.addActionListener(ai_play);
		헝가리_ai.addActionListener(ai_play);

		button_defult();

		ai.add(ai2, "North");// ai 현황판
		// ai2.setPreferredSize(new Dimension(200, 100));

		p.add(ai, "Center");// ai 채팅창
		ai.setPreferredSize(new Dimension(200, 1200));

		ai.add(jsp1, "Center"); // ai = BorderLayout 위치및 사이즈
		jsp.setPreferredSize(new Dimension(200, 600));

		this.add(p, "East");// 형황판 GridLayouy 위치 및 사이즈
		p.setPreferredSize(new Dimension(300, 1000));

	}

	private void button_defult() {
		// TODO Auto-generated method stub

		독일.setEnabled(false);
		노르웨이.setEnabled(false);
		러시아.setEnabled(false);
		루마니아.setEnabled(false);
		스웨덴.setEnabled(false);
		필란드.setEnabled(false);
		스페인.setEnabled(false);
		아일랜드.setEnabled(false);
		이탈리아.setEnabled(false);
		중국.setEnabled(false);
		일본.setEnabled(false);
		헝가리.setEnabled(false);

		독일_ai.setEnabled(false);
		노르웨이_ai.setEnabled(false);
		러시아_ai.setEnabled(false);
		루마니아_ai.setEnabled(false);
		스웨덴_ai.setEnabled(false);
		필란드_ai.setEnabled(false);
		스페인_ai.setEnabled(false);
		아일랜드_ai.setEnabled(false);
		이탈리아_ai.setEnabled(false);
		중국_ai.setEnabled(false);
		일본_ai.setEnabled(false);
		헝가리_ai.setEnabled(false);

	}

	private void init_contry_set() {
		// TODO Auto-generated method stub

		con_col.add(Contry_Class.start); // 어레이 리스트에 나라객체를 쑤셔박음
		con_col.add(Contry_Class.독일); // 생성순서가 매우 중요하므로 잘못되면 집이 이상한곳에 생김
		con_col.add(Contry_Class.노루웨이);
		con_col.add(Contry_Class.러시아);
		con_col.add(Contry_Class.루마니아);
		con_col.add(Contry_Class.스웨덴);
		con_col.add(Contry_Class.필란드);
		con_col.add(Contry_Class.스페인);
		con_col.add(Contry_Class.무인도);
		con_col.add(Contry_Class.아일랜드);
		con_col.add(Contry_Class.이탈리아);
		con_col.add(Contry_Class.프랑스);
		con_col.add(Contry_Class.중국);
		con_col.add(Contry_Class.일본);
		con_col.add(Contry_Class.헝가리);
		con_col.add(Contry_Class.대한민국);

	}

	private void init_timer() {

		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click_check) {
					if (dice_y < 630) {
						changh += 1;

						if (g < 1)
							g += 0.01;

						vy = -(v * Math.sin(angle * Math.PI / 180) - g * changh);
						dice_y += vy; // 주사위의 상하운동 y값
						dice_x += 5;

						if (dice_x > MyConst.GAMEPAN_W - 200 - dice_size) {
							dice_x = MyConst.GAMEPAN_W - 200 - dice_size;
						}
						if (dice_y > 610) { // 바닦에 꼬라박으면 상승~
											// 오차범위때문에 감으로 떄려박은 코드

							changh = changh_buf;
							changh_buf = changh_buf + 3;
							h = 1;
							changh -= (v * Math.sin(angle * Math.PI / 180));

						}

					}
				}

				if (dice_moving) { // 주사위 움직임 종료 후에 움직인다.
					if (turn == false)
						move_char(); // turn이 true일 경우 내가 움직인다.
					else
						play2_move_char(); // turn이 false 경우 ai가 움직인다.
				}

				BlueGamePan.repaint(); // 현재패널을 10ms마다 간접호출로 그린다.
										// repaint는 아래의 paint component를 호출한다.
			}

		};

		timer = new Timer(15, listener1);
		timer.start();

	}

	private void play2_move_char() {
		// TODO Auto-generated method stub

		// jbt_buy.setEnabled(play2_index+1 > 0); //start 위치에 건물 건설하지 못하게함

		if (play2_index + 1 > 15)
			play2_index = -1; // 총객체의 수가 16개이기때문에 16+1은 오류가 발생하므로 -1을 주어 16개를 못넘게한다.

		if (click_check) {

			if (play2.pos.x < con_col.get(play2_index + 1).pos.x) {
				play2.pos.x += 10;
			}

			else if (play2.pos.x > con_col.get(play2_index + 1).pos.x) {

				play2.pos.x -= 10;
			}

			if (play2.pos.y < con_col.get(play2_index + 1).pos.y) {
				play2.pos.y += 10;
			}

			else if (play2.pos.y > con_col.get(play2_index + 1).pos.y) {

				play2.pos.y -= 10;
			}

			if (play2.pos.x == con_col.get(play2_place_stack - 1).pos.x
					&& play2.pos.y == con_col.get(play2_place_stack - 1).pos.y && fail_check_stats == true) {

				
				if ((play2_place_stack ) == 9) // 벌금
				{

					Blue_Marble.play2.price -= fine;

					System.out.printf("%d\n", Blue_Marble.play2.price);
					System.out.printf("%d\n", play2_place_stack);
					jlb_price.setText(Blue_Marble.play2.price + "원");

					chat6 = String.format("벌금 200000원입니다");
					jta_ai_chat.append(chat6 + "\r\n");

				}
				
				
		
				
				
				for (int i = 0; i < 15; i++) {

					// 내위치가 상대방이 구입한 위치인지 확인
					if (play2_place_stack == play.contry_stack[i]) { // 상대방 건물인지 확인

						if (0 > (play2.price - con_col.get(play.contry_stack[i] - 1).price)) {
							// 지불하고 난 후 0원 이하이지만 건물을 소유하고 있을경우 판매하는 검사

							ai_pay_check(play.contry_stack[i] - 1);

						}

						play2.price -= con_col.get(play.contry_stack[i] - 1).price; // 가격 지불
						play.price += con_col.get(play.contry_stack[i] - 1).price;

						System.out.printf("AI가 플레이어에게 %d원을 지불했습니다.", con_col.get(play.contry_stack[i] - 1).price);
					}
					jlb_price.setText(play.price + "원");// player 화면에 가격표시
					jlb_price_ai.setText(play2.price + "원");// ai 화면에 가격표시

				}

				////////////////////////////////////////////////////////////////////////////////////

				if (ai_buy_check()) {// 구입할 땅의 금액을 사고 잔액이 30만원 이상이 확인될경우

					int i = rand.nextInt(2);
					System.out.printf("랜덤값은 %d\n", i);

					if (i == 1) {
						nbs.play2_buy();

						File file_buy = new File("music/구매.wav");

						try {
							AudioInputStream stream = AudioSystem.getAudioInputStream(file_buy);
							Clip clip = AudioSystem.getClip();
							clip.open(stream);
							clip.start();
							// clip.loop(count);
						} catch (Exception w) {
							// TODO: handle exception
							w.printStackTrace();
						}

					}

				}

				////////////////////////////////////////////////////////////////////////////////////
				fail_check(); // 게임오버 조건 체크
				fail_check_stats = false;
				jbt_dice.setEnabled(true);
				jbt_pass.setEnabled(true);// 캐릭터 이동 완료 후 버튼 활성화
				jbt_buy.setEnabled(true);

				if (turn) { // ai의 모든 행동을 종료 한후에 턴을 마친다!!!!!!
					turn = false;

				} else {
					// t.start();
					turn = true;

				}

				now_moving = true; // 주사위 버튼 클릭 활성화

			}

		}

		if (index_interval == interval_count) {

			if (dice_count > 0) {

				play2_index++;

			}

			if (dice_count == 0) {
				// 캐릭이 이동중에는 주사위 버튼 클릭이 안된다.

				if (char_move == false) {
					char_move = true;

				}

			}

			dice_count--;

			// 현재 위치값과 다음목표 위치값이 일치할 경우에만 다음칸으로 이동

		}

		interval_count--;
		if (interval_count < 0)
			interval_count = 30;

	}

	public boolean ai_pay_check(int x) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 15; i++) {

			if (play2.contry_stack[i] != 0) { // 앞쪽의 스택부터 차례대로 판매해 나간다.

				if (0 > play2.price - con_col.get(x).price) {
					nbs.play2_sell(play2.contry_stack[i]); // 판매후에 잔액 재검사
					System.out.printf("처분후 현재금액%d 판매스택의 위치%d\n", play2.price, play2.contry_stack[x]);
				} else
					return true;

			}

		}

		return true;

	}

	public boolean ai_buy_check() {
		int n = 0;

		if (play2_place_stack == 9 || play2_place_stack == 1)
			return false; // 스타트 및 무인도 제거

		for (int i = 0; i < 15; i++) {

			if (play2.contry_stack[i] == play2_place_stack)
				return false;

			if (play.contry_stack[i] == play2_place_stack) {

				n = play.contry_stack[i];
				if (n > 0) {
					System.out.println("상대방이 소유중이거나 구입할수없는 땅입니다 ㅇㅋ?.\n");
					return false;
				}
			}

		}

		if (200000 < (play2.price - con_col.get(play2_place_stack - 1).price)) {

			System.out.printf("ai가 현재 금액 %d에서 %d를 뺼샘한 가격이 30만원 이상입니다.\n", play2.price,
					con_col.get(play2_place_stack - 1).price);
			return true;
		} else {

			System.out.println("돈이 모잘라서 못삽니다\n");
			return false;
		}

	}

	public void move_char() {

		// jbt_buy.setEnabled(my_index+1> 0); // start 위치에 건물 건설하지 못하게함

		// my_index = -1; /// 초기 나의 위치부터 시작이므로 0부터 시작하기 위해 -1 대입

		if (my_index + 1 > 15)
			my_index = -1; // 총객체의 수가 16개이기때문에 16+1은 오류가 발생하므로 -1을 주어 16개를 못넘게한다.

		if (click_check) {

			if (play.pos.x < con_col.get(my_index + 1).pos.x) {
				play.pos.x += 10;
			}

			else if (play.pos.x > con_col.get(my_index + 1).pos.x) {

				play.pos.x -= 10;
			}

			if (play.pos.y < con_col.get(my_index + 1).pos.y) {
				play.pos.y += 10;
			}

			else if (play.pos.y > con_col.get(my_index + 1).pos.y) {

				play.pos.y -= 10;
			}

			// System.out.printf("지금 내위치 %d 목표위치%d, 내위치 %d 목표위치
			// %d\n",play.pos.x,con_col.get(my_index + 1).pos.x,play.pos.y,
			// con_col.get(my_index + 1).pos.y);

			if (play.pos.x == con_col.get(my_place_stack - 1).pos.x
					&& play.pos.y == con_col.get(my_place_stack - 1).pos.y && fail_check_stats == true) {

				fail_check_stats = false;

				for (int i = 0; i < 15; i++) { // 내위치가 상대방이 구입한 위치인지 확인
					if (my_place_stack == play2.contry_stack[i]) { // 상대방 건물인지 확인

						play.price -= con_col.get(play2.contry_stack[i] - 1).price; // 가격 지불
						play2.price += con_col.get(play2.contry_stack[i] - 1).price;

						System.out.printf("플레이어가 AI에게 %d원을 지불했습니다.\n", con_col.get(play2.contry_stack[i] - 1).price);
					}
					jlb_price.setText(play.price + "원");// player 화면에 가격표시
					jlb_price_ai.setText(play2.price + "원");// ai 화면에 가격표시
				}

				if ((my_place_stack ) == 9) // 벌금
				{

					Blue_Marble.play.price -= fine;

					System.out.printf("%d\n", Blue_Marble.play.price);
					System.out.printf("%d\n", my_place_stack - 1);
					jlb_price.setText(Blue_Marble.play.price + "원");

					chat5 = String.format("벌금 200000원입니다");
					jta_chat.append(chat5 + "\r\n");

				}

				if ((my_place_stack ) == 5 || (my_place_stack ) == 13||(my_place_stack ) == 8) // 퀴즈
				{

					int result = 0;

					sqr_n = rand.nextInt(11);

					int button = JOptionPane.showOptionDialog(null, Contry_Class.str_quiz[sqr_n], "ox퀴즈!!!",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Contry_Class.str,
							Contry_Class.str[0]);
					// 정답이면 0 오답이면 1

					result = Contry_Class.answer[sqr_n];
					// 0 0
					if (result == button) {
						Blue_Marble.play.price += 200000;
						jlb_price.setText(Blue_Marble.play.price + "원");

						chat5 = String.format("정답! 상금 200000원입니다");
						jta_chat.append(chat5 + "\r\n");
					} else {
						Blue_Marble.play.price -= 200000;
						jlb_price.setText(Blue_Marble.play.price + "원");

						chat5 = String.format("땡! 벌금 200000원입니다");
						jta_chat.append(chat5 + "\r\n");
					}

				}

				fail_check();
				jbt_buy.setEnabled(true);
				jbt_pass.setEnabled(true);// 캐릭터 이동 완료 후 버튼 활성화

			}

		}

		if (index_interval == interval_count) {

			if (dice_count > 0) {

				my_index++;

			}

			if (dice_count == 0) {

				if (char_move == false) {
					char_move = true;

				}

			}
			dice_count--;

			// 현재 위치값과 다음목표 위치값이 일치할 경우에만 다음칸으로 이동

		}

		interval_count--;
		if (interval_count < 0)
			interval_count = 30;

	}

	private void fail_check() {

		if (play2.price < 0) {

			JOptionPane.showMessageDialog(this, "파산!!!!!! ");

			set_defult();

		}

		if (play.price < 0) {

			JOptionPane.showMessageDialog(this, "파산!!!!!! ");

			set_defult();

		} else if (round > 2) {

			JOptionPane.showMessageDialog(this, "플레이어 완주성공!!!");
			System.out.println("게임 종료\n");

			result();

			set_defult();

		} else if (round_ai > 2) {

			JOptionPane.showMessageDialog(this, "AI 완주 성공!!!!");

			result();

			System.out.println("게임 종료\n");
			set_defult();

		}

	}

	private void result() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 15; i++) {

			if (0 != play.contry_stack[i])
				play.price += con_col.get(play.contry_stack[i] - 1).price;

			if (0 != play2.contry_stack[i])
				play2.price += con_col.get(play2.contry_stack[i] - 1).price;

			System.out.printf("플레이어 건물 총값:%d , 컴퓨터 건물 총 값:%d 스택값%d\n", play.price, play2.price, play.contry_stack[i]);

		}

		// System.out.printf("플레이어 건물 총값:%d , 컴퓨터 건물 총 값:%d",play.price,play2.price);

		if (play.price > play2.price)
			JOptionPane.showMessageDialog(this, "플레이어 승!!!");
		else
			JOptionPane.showMessageDialog(this, "플레이어 패배!!!!!!!");

	}

	private void set_defult() {

		dice_num = 0;
		dice_count = 0;
		my_place_stack = 1;
		play2_place_stack = 1;
		index = 0;
		move_count = 0;
		interval_count = 0;
		my_index = -1; /// 초기 나의 위치 (my_index+1)부터 시작이므로 0부터 시작하기 위해 -1 대입
		play2_index = -1; /// 초기 나의 위치 (my_index+1)부터 시작이므로 0부터 시작하기 위해 -1 대입
		click_check = false;
		now_moving = true;
		dice_moving = true;
		turn = false; // false가 주인공
		char_move = true;
		fail_check_stats = false;

		play.price = 1000000; // 가격 초기화
		play.pos.x = 0;
		play.pos.y = 800; // 위치 초기화

		play2.price = 1000000; // 가격 초기화
		play2.pos.x = 0;
		play2.pos.y = 800; // 위치 초기화

		// 위치 초기화
		for (int i = 0; i < 15; i++) { // 스택 초기화

			play.contry_stack[i] = 0;
			button_defult();
		}

	}

	public void init_game_pan() {
		// TODO Auto-generated method stub

		BlueGamePan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) { // Jcomponent에 추상클래스로 상속되어있다.
				// 배경 그리기

				g.drawImage(pic, 200, 200, this);

				for (int i = 0; i < con_col.size(); i++) {

					con_col.get(i).draw(g, con_col.get(i).contry_name);

				}

				for (int k = 0; k < play2.contry_stack.length; k++) {

					if (play2.contry_stack[k] != 0)
						con_col.get((play2.contry_stack[k]) - 1).draw(g, 0, 140, 10);// 건물 위치

				}

				for (int k = 0; k < play.contry_stack.length; k++) {

					if (play.contry_stack[k] != 0)
						con_col.get((play.contry_stack[k]) - 1).draw(g, 0, 140);
				}

				if (click_check) {
					if (dice_y < 630)
						g.drawImage(dic_img, (int) dice_x, (int) dice_y, dice_size, dice_size, this);

					else {

						g.drawImage(img_exp[dice_num - 1], 520 - dice_size, 500 - dice_size, 150, 200, this);

						dice_moving = true; // 주사위가 움직이는동안 캐릭터가 움직이지 않게 체크하는 변수

					}
				}

				play.draw(g); // 유저 캐릭터

			}

		};

		this.add(jbt_buy); // 버튼 프레임에 추가
		// this.add(jbt_sell);
		this.add(jbt_pass);

		jbt_buy.setBorderPainted(false);// Jbutton Borade(외각선)을 없애준다.
		jbt_buy.setContentAreaFilled(false); // jbutton 내용영역 없애기
		// jbt_sell.setBorderPainted(false);
		// jbt_sell.setContentAreaFilled(false);
		jbt_pass.setBorderPainted(false);
		jbt_pass.setContentAreaFilled(false);
		jbt_dice.setBorderPainted(false);
		jbt_dice.setContentAreaFilled(false);

		jbt_buy.setBounds(650, 730, 75, 70); // 버튼 위치, 버튼사이즈
		// jbt_sell.setBounds(360, 730, 120, 50); // 90, 50
		jbt_pass.setBounds(720, 730, 75, 70);
		jbt_dice.setBounds(500, 660, 130, 140);

		BlueGamePan.add(jbt_buy); // 버튼 프레임에 추가
		// BlueGamePan.add(jbt_sell);
		BlueGamePan.add(jbt_pass);
		BlueGamePan.add(jbt_dice);
		BlueGamePan.setLayout(null);
		BlueGamePan.setPreferredSize(new Dimension(MyConst.GAMEPAN_W, MyConst.GAMEPAN_H));
		this.add(BlueGamePan);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// 이벤트를 발생시킨 컨트롤,뭐가눌렸는지 모르기때문에 ob타입으로 받는다.

				if (evt_bt == jbt_buy) {

					nbs.buy();

					File file_buy = new File("music/구매.wav");

					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file_buy);
						Clip clip = AudioSystem.getClip();
						clip.open(stream);
						clip.start();
						// clip.loop(count);
					} catch (Exception w) {
						// TODO: handle exception
						w.printStackTrace();
					}

				}

				/*
				 * else if (evt_bt == jbt_sell) {
				 * 
				 * 
				 * // bs.sell(); // nbs.sell(); if (turn == false) //nbs.sell(); if (turn ==
				 * true) nbs.play2_sell();
				 * 
				 * File file_sell = new File("music/판매.wav");
				 * 
				 * try { AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
				 * Clip clip = AudioSystem.getClip(); clip.open(stream); clip.start(); //
				 * clip.loop(count); } catch (Exception w) { // TODO: handle exception
				 * w.printStackTrace(); }
				 * 
				 * 
				 * }
				 */

				else if (evt_bt == jbt_pass) {

					if (turn) {
						turn = false;

					} else {
						// t.start();
						turn = true;

					}

		/*			File file_pass = new File("music/통과.wav");

					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file_pass);
						Clip clip = AudioSystem.getClip();
						clip.open(stream);
						clip.start();
						// clip.loop(count);
					} catch (Exception w) {
						// TODO: handle exception
						w.printStackTrace();
					}*/

					// now_moving = true;
					// jbt_dice.setEnabled(true);
					play2_dice(); // AI 자동으로 실행

				}

			}

		};

		/*
		 * t = new Timer(2000, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if(turn = true) {
		 * 
		 * }
		 * 
		 * 
		 * //now_moving = true;
		 * 
		 * //new blue_marble(); // start 버튼 클릭시 blue_marble 실행 //setVisible(false); //
		 * Start 클래스 창이 사라지고 blue_marble 클래스가 실행 // TODO Auto-generated method stub
		 * repaint(); } }); t.setRepeats(false);//타이머가 반복하는지 여부를 설정하거나 가져옵니다.
		 */

		jbt_buy.addActionListener(listener); // 버튼객체에 이벤트 리스너 등록
		// jbt_sell.addActionListener(listener);
		jbt_pass.addActionListener(listener);

		jbt_dice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				File file_dice = new File("music/주사위.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_dice);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

					FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(6.0f); // 볼륨 컨트롤

				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

				if (now_moving) { // now_moving으로 체크 캐릭이 이동중일 경우 버튼이 눌리지 않는다.

					dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // 볼의x좌표
					dice_y = 500 - dice_size; // 볼의y좌표
					h = 1;
					g = 0.2;
					changh = 1;
					changh_buf = 0.1;

					dice_num = rand.nextInt(4) + 1; // 주사위 숫자생성
					// dice_num = 4;
					dice_effet_count = 0; // 이펙트 효과 초기화
					dice_count = dice_num;
					click_check = true;
					now_moving = false;
					jbt_dice.setEnabled(false); // 다음턴까지 버튼 비활성화
					jbt_pass.setEnabled(false);
					jbt_buy.setEnabled(false);

					char_move = false; // 캐릭터 이동이 끝날경우

					my_place_stack += dice_num;

					// 한바꾸 돌아서 넘어갈때 초기 위치 지정
					if (my_place_stack > 16) {
						my_place_stack -= 16;// 0

						play.price = play.price + 200000;// 한바퀴 돌면 20000원 입금
						Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "원");
						System.out.println(play.price);
						round++;
					}

					fail_check_stats = true;
					// 실패체크 on상태 이고 now_moving과 char과 true상태일때 조건을 체크한다.
					// 주사위 움직임이 끝난경우 char_move true 상태
					// 움직임이 끝났을때 now_moving false 상태
					// 조건 체크후 fail_check = false로 변경

					dice_moving = false;

				}

			}
		});

	}

	public void play2_dice() {
		
		File file_dice = new File("music/주사위.wav");

		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file_dice);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f); // 볼륨 컨트롤

		} catch (Exception w) {
			// TODO: handle exception
			w.printStackTrace();
		}

		dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // 볼의x좌표
		dice_y = 500 - dice_size; // 볼의y좌표
		h = 1;
		g = 0.2;
		changh = 1;
		changh_buf = 0.1;

		dice_num = rand.nextInt(4) + 1; // 주사위 숫자생성
		 //dice_num = 4;
		dice_effet_count = 0; // 이펙트 효과 초기화
		dice_count = dice_num;

		jbt_dice.setEnabled(false); // 다음턴까지 버튼 비활성화
		jbt_pass.setEnabled(false);
		jbt_buy.setEnabled(false);

		char_move = false; // 캐릭터 이동이 끝날경우

		play2_place_stack += dice_num;

		if (play2_place_stack > 16) {
			play2_place_stack -= 16;
			play2.price = play2.price + 200000;
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "원");
			System.out.println(play2.price);
			round++;
		}
		fail_check_stats = true; // 실패체크 on상태 이고 now_moving과 char과 true상태일때 조건을 체크한다.
		dice_moving = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Contry_Class(); // 나라 객체 생성
		new Blue_Marble(); // 메인 객체 생성
		// new Blue_interFace();

	}

}
