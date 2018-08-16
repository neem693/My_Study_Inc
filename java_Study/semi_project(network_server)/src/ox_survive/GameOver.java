package ox_survive;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import images.Images;
import main.MyConst;
import pv.Character_User;
import pv.Character_ox;
import utill.Character_Manager;
import utill.Character_pan;
import utill.MunJe;
import utill.Pan;

public class GameOver {
	MunJe munje;
	Character_Manager ch_m;
	Timer timer;

	int s;// 캐릭터들을 어레이 리스트로 불러올때, 끊기지 않기 위해서 전역변수를 준것
	int round;
	int remain;
	int w, l; // 오답체크 할시, 해당하는 이미지를 랜덤으로 불러오기 위해 난수를 받아와야 하는데, 그것을 기억해야 할 전역변수가 필요하다.
	// 서버 전역변수
	int noc;// number_of_character
	Character_pan[] ai_move; // ai가 움직여야 할 곳을 미리 정하여서 클라이언트에 전달해줘야 한다.

	Random rand;
	ArrayList<Character_ox> ch_list;
	JPanel full;
	Graphics g;

	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;

	FontMetrics fontmet;

	static final int ALL_COUNT = 500;
	static final int MAX_PERCENT = 10;
	static final int POSITIVE_PERCENT = 6;
	static final int NEGATIVE_PERCENT = 11;
	boolean isRound = false; // 라운드 중일때 다음 라운드가 실행되지 않게
	boolean quetioning = false; // 문제 5초 동안 일 때만
	boolean gameover = false;
	boolean already_killed = false;
	boolean cheating;
	boolean isnt_value_cheating;
	boolean win = false;
	boolean checking = false;

	int round_interval;
	int count = 0;
	String count_str;

	public GameOver() {
		// TODO Auto-generated constructor stub
		super();
		round_interval = 0;
		rand = new Random();
		s = 0;
		round = 0;
		isnt_value_cheating = true;

	}

	public GameOver(MunJe munje, Character_Manager ch_m) {
		this();
		this.munje = munje;
		this.ch_m = ch_m;
		this.ch_list = ch_m.getCh_list();

		quiz_r_n = munje.getQuiz_r_n();
		quiz_r_m = munje.getQuiz_r_m();
		quiz_r_c = munje.getQuiz_r_c();

	}

	public GameOver(Character_Manager ch_m, JPanel full) {
		// TODO Auto-generated constructor stub
		this();

		this.ch_m = ch_m;
		this.ch_list = ch_m.getCh_list();
		this.full = full;

	}

	public void nextRound() {
		// TODO Auto-generated method stub

		// int max_character = ch_list.size();
		// if (isRound)
		// return;
		ai_move = new Character_pan[ch_list.size()];
		int count = 0;
		int r;
		int i = 0;
		int m = 0;
		SKIP: for (; s < ch_list.size(); s++) {
			// System.out.println(ch_m.ch_move_list.size());

			for (Character_ox user : ch_m.ch_user_list) {
				if (ch_list.get(s) == user) {
					ai_move[s] = null;
					continue SKIP;
				}
			}

			if (isnt_value_cheating) {
				// isnt_value_cheating은 라운드가 끝났을시에 바로 true해줘야 한다!!! 이거 꼭 기억하라.
				// round도 ++ 해줘야 한다. 꼭 기억하라.
				we_cheat_player();
			}

			r = rand.nextInt(GameOver.MAX_PERCENT);
			if (quiz_r_c.get(round).equals("O")) // 만약 답이 o라면 60%가 o로 간다. 지금으로선 무조건 O가 60퍼센트라고 하자.
			{
				if (!cheating)
					o_is_correct(r);
				else
					x_is_correct(r);

			} else if (quiz_r_c.get(round).equals("X")) {
				if (!cheating)
					x_is_correct(r);
				else
					o_is_correct(r);
			}

			ai_move[s] = ch_list.get(s).getCurrent_pan();
		}
		System.out.println(ai_move.length + "명 ai 데이터 존재");
		System.out.println("o판 프리오리티");
		for (int z = 0; z < 50; z++) {
			System.out.println(z + " " + ch_m.getOpan().ch_priority_lo[z].isIs_hear());
		}
		System.out.println("x판 프리오리티");
		for (int z = 0; z < 50; z++) {
			System.out.println(z + " " + ch_m.getXpan().ch_priority_lo[z].isIs_hear());
		}

	}

	private void we_cheat_player() {
		// TODO Auto-generated method stub
		int r = rand.nextInt(10) + 1;
		if (0 <= r && r <= GameOver.POSITIVE_PERCENT)
			cheating = false;
		else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
			cheating = true;
		}
		isnt_value_cheating = false;// 라운드가 끝났을 시에는 다시 true로 변한다.
									// 즉, 해당 라운드가 cheat인지 아닌지 한라운드에 한번만 결정할 수 있다는 것을 의미한다.

	}

	private void x_is_correct(int r) {
		// TODO Auto-generated method stub
		if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
			ch_m.user_goto(ch_m.getXpan(), ch_list.get(s));
		} else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
			ch_m.user_goto(ch_m.getOpan(), ch_list.get(s));
		}
	}

	private void o_is_correct(int r) {
		// TODO Auto-generated method stub
		if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
			ch_m.user_goto(ch_m.getOpan(), ch_list.get(s));
		} else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
			ch_m.user_goto(ch_m.getXpan(), ch_list.get(s));
		}
	}

	// for (Character_ox ch : ch_list) {
	// if (ch.equals(ch_m.getCh_user()))
	// continue;
	// r = rand.nextInt(10);
	//
	// if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
	// ch_m.user_goto(ch_m.getOpan(), ch);
	// } else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
	// ch_m.user_goto(ch_m.getXpan(), ch);
	// }
	// }
	public void count_up() {
		if (!isRound && s == ch_list.size()) {
			s = 0;
			isRound = true;
		}
		if (!quetioning && count < GameOver.ALL_COUNT) {
			quetioning = true;
			checking = false;

		} else if (count >= GameOver.ALL_COUNT) {
			quetioning = false;
			isnt_value_cheating = true;

		}
		// System.out.println(quetioning);
		count++;
	}

	public boolean count_zero() {
		if (count >= GameOver.ALL_COUNT) {
			if (round_interval < 600) {
				round_interval++;
				count = GameOver.ALL_COUNT;
				already_killed = false;
			} else if (round_interval >= 600) {
				count = 0;// 인터벌이 다 됬을시 다시 초기화 하는 것
				round_interval = 0; // 인터벌도 초기화 해준다.
				isRound = false; // 현재 라운드가 아니고, 갖가지 에니메이션 오답 처리를 하는 과정임을 의미함
				round++;
			}
			return true;
		} else
			return false;
	}

	public int getCount() {
		return count;
	}

	public void draw_count(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("굴림", 1, 20));
		count_str = String.format("%d . %02d", (GameOver.ALL_COUNT - this.getCount()) / 100,
				(GameOver.ALL_COUNT - this.getCount()) % 100);
		g.drawString(count_str, MyConst.GAME_W / 2 - g.getFontMetrics().stringWidth(count_str) / 2, 100);
	}

	public void lets_kill() {
		// TODO Auto-generated method stub
		if (already_killed)
			return;
		else
			remain = ch_list.size();// 플레이어 포함 다 죽을 경우 해당 등수를 보여주기 위해서 변수를 저장한 것이다.
		already_killed = true;

		Pan pan = null;
		if (quiz_r_c.get(round).equals("O")) { // x판이 틀렸을 때
			pan = ch_m.getXpan();
		} else if (quiz_r_c.get(round).equals("X")) {
			pan = ch_m.getOpan();
		}
		for (int i = 0; i < pan.ch_lo.length; i++) {
			for (int j = 0; j < pan.ch_lo[i].length; j++) {

				if (pan.ch_lo[i][j].isIs_hear()) {
					for (int n = 0; n < ch_list.size(); n++) {

						if (ch_list.get(n) == pan.ch_lo[i][j].getCh()) {
							// System.out.println("---same---");
							if (ch_list.get(n) == ch_m.ch_user) {// user가 망가졌을 때
								ch_m.ch_user = null;
								gameover = true;
							}
							ch_list.remove(n);
							pan.ch_lo[i][j].setIs_hear(false);
							pan.ch_lo[i][j].setCh(null);
							break;
						}

					}
				}

			}
		}
		if (ch_list.size() == 1 && ch_list.get(0) == ch_m.ch_user) {
			win = true;
		}

		// System.out.println(ch_list.size());

	}

	public boolean isQuetioning() {
		return quetioning;
	}

	public void munje_show(Graphics g) {
		if (!quetioning)
			return;
		fontmet = g.getFontMetrics();
		g.setColor(new Color(0, 0, 0, 126));
		g.fillRect(640 - fontmet.stringWidth(quiz_r_m.get(round)) / 2, 10,
				fontmet.stringWidth(quiz_r_m.get(round)) + 30, fontmet.getHeight() + 15);
		g.setColor(Color.WHITE);

		g.drawString(quiz_r_m.get(round), 640 - fontmet.stringWidth(quiz_r_m.get(round)) / 2 + 15, 10 + 20);

	}

	public void end_game(Graphics g) {
		Font font1 = new Font("굴림", 1, 60);
		g.setFont(font1);
		String str = null, lol = null;
		if (win) {
			str = "축하합니다. 1등입니다.";
			lol = "ㅎㅎㅎㅎㅎㅎㅎㅎ GG";

		} else if (gameover) {

			if (ch_list.size() == 0)

				str = String.format("당신은 %d등입니다.", remain);
			else
				str = String.format("당신은 %d등입니다.", ch_list.size() + 1);

			lol = "ㅋㅋㅋㅋㅋㅋ";

		}
		fontmet = g.getFontMetrics();
		g.setColor(new Color(0, 0, 0, 126));
		g.fillRect(0, MyConst.GAME_H / 2 - fontmet.getHeight() * 3, MyConst.GAME_W + 15, fontmet.getHeight() * 7);
		g.setColor(Color.WHITE);
		g.drawString(str, MyConst.GAME_W / 2 - fontmet.stringWidth(str) / 2, MyConst.GAME_H / 2);
		g.drawString(lol, MyConst.GAME_W / 2 - fontmet.stringWidth(lol) / 2, MyConst.GAME_H / 2 + fontmet.getHeight());
	}

	public void lets_check_munje(Graphics g) {
		if (this.quetioning)
			return;
		Pan correct_anwser;
		Pan not_co_anwser;
		Point start_point;
		int x, y;
		Image win = null, lose = null;

		if (quiz_r_c.get(round).equals("O")) {
			correct_anwser = ch_m.getOpan();
			not_co_anwser = ch_m.getXpan();
		} else {
			correct_anwser = ch_m.getXpan();
			not_co_anwser = ch_m.getOpan();
		}
		if (!checking) {
			w = rand.nextInt(Images.WIN_L) + 1;
			l = rand.nextInt(Images.LOSE_L) + 1;
		}
		checking = true;

		switch (w) {
		case 1:
			win = Images.WIN1;
			break;
		case 2:
			win = Images.WIN2;
			break;
		case 3:
			win = Images.WIN3;
			break;
		case 4:
			win = Images.WIN4;
			break;
		case 5:
			win = Images.WIN5;
			break;
		case 6:
			win = Images.WIN6;
			break;
		}

		switch (l) {
		case 1:
			lose = Images.LOSE1;
			break;
		case 2:
			lose = Images.LOSE2;
			break;
		case 3:
			lose = Images.LOSE3;
			break;
		}

		start_point = correct_anwser.getFirst_Point();
		x = start_point.x + correct_anwser.WIDTH / 2 - win.getWidth(null) / 2;
		y = start_point.y + correct_anwser.HEIGHT / 2 - win.getHeight(null) / 2;
		g.drawImage(win, x, y, null);

		start_point = not_co_anwser.getFirst_Point();
		x = start_point.x + not_co_anwser.WIDTH / 2 - lose.getWidth(null) / 2;
		y = start_point.y + not_co_anwser.HEIGHT / 2 - lose.getHeight(null) / 2;
		g.drawImage(lose, x, y, null);

	}

	public void gameRestart(Timer timer) {
		gameover = false;
		win = false;
		timer.restart();

	}

	public Character_pan[] getAi_move() {
		return ai_move;
	}

	public void setAi_move(Character_pan[] ai_move) {
		this.ai_move = ai_move;
	}

	public ArrayList<Character_ox> getCh_list() {
		return ch_list;
	}

	public void setCh_list(ArrayList<Character_ox> ch_list) {
		this.ch_list = ch_list;
	}

	public void gameover_server_ready() {
		this.round++;
		this.isnt_value_cheating = true;
		s = 0;
	}

}
