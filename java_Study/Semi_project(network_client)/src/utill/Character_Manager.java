package utill;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import org.omg.CosNaming.IstringHelper;

import pv.Character_User;
import pv.Character_ox;

public class Character_Manager {

	public static final int HEAVY = 60;
	public static final int MEDIUM = 35;
	public static final int LOW = 20;
	public static final int DIVDE = 20; // 캐릭터가 해당 지점까지 이동하는 횟수
	Random rand;

	static final String OLOCATION = "O";
	static final String XLOCATION = "X";
	public static final int MAX_MOVING = 4;
	Pan opan, xpan;
	int how_many;
	public ArrayList<Character_ox> ch_list;
	public ArrayList<Character_ox> ch_user_list;
	public ArrayList<Character_ox> ch_move_list;
	public Character_ox ch_user;

	public Character_Manager() {
		// TODO Auto-generated constructor stub
		rand = new Random();
		ch_list = new ArrayList<Character_ox>();
		ch_move_list = new ArrayList<Character_ox>();

	}

	public Character_Manager(Pan opan, Pan xpan) {
		this();
		this.opan = opan;
		this.xpan = xpan;
	}

	public Character_Manager(Pan opan, Pan xpan, int how_many, int how_many_user) {
		this();
		this.how_many = how_many;
		this.opan = opan;
		this.xpan = xpan;
		// int x, y;
		// int count_x = 0, count_o = 0;
		// int[] user_count = new int[how_many_user];
		// int count = 0;

		// make_user_count(user_count);
		//
		// Character_ox ch = null;
		//
		// for (int i = 0; i < this.how_many; i++) {
		// if (i % 2 == 0) {
		// x = opan.ch_priority_lo[count_o].getCharacter_start_w();
		// y = opan.ch_priority_lo[count_o].getCharacter_start_h();
		// opan.ch_priority_lo[count_o].is_hear = true;
		//
		// if (user_count[count] == i) {
		// ch = new Character_User(x, y);
		// ch_user = ch;
		// } else {
		// ch = new Character_ox(x, y);
		// }
		// ch.setCurrentLocation(Pan.OPAN);
		// opan.ch_priority_lo[count_o].setCh(ch);
		// opan.ch_priority_lo[count_o].setBefore_ch(ch);
		//
		//// System.out.println(opan.ch_priority_lo[count_o].getBefore_ch());
		// ch.setCurrent_pan(opan.ch_priority_lo[count_o]);
		// count_o++;
		//
		// // 그전 위치 기억
		//
		// } else {
		// x = xpan.ch_priority_lo[count_x].getCharacter_start_w();
		// y = xpan.ch_priority_lo[count_x].getCharacter_start_h();
		// xpan.ch_priority_lo[count_x].is_hear = true;
		//
		// if (user_count[count] == i) {
		// ch = new Character_User(x, y);
		// ch_user = ch;
		// } else {
		// ch = new Character_ox(x, y);
		// }
		// ch.setCurrentLocation(Pan.XPAN);
		// xpan.ch_priority_lo[count_x].setCh(ch);
		// xpan.ch_priority_lo[count_x].setBefore_ch(ch);
		// ch.setCurrent_pan(xpan.ch_priority_lo[count_x]);
		// count_x++;
		// }
		//
		// ch_list.add(ch);
		//
		// }
		// // for(int i =0; )
		// // this.ch_list = new
	}

	// private void make_user_count(int[] user_count) {
	// // TODO Auto-generated method stub
	// // user_count = new int[how_many_user];
	// int check;
	// AGAIN: for (int i = 0; i < user_count.length; i++) {
	// check = rand.nextInt(Character_Manager.HEAVY);
	// for (int j = 0; j < i; j++)
	// if (check == user_count[j]) {
	// i -= 1;
	// continue AGAIN;
	// }
	// user_count[i] = check;
	// }
	// }

	public boolean move() {
		// TODO Auto-generated method stub
		// System.out.println("실행중");
		Point cpoint, npoint;
		double dX, dY;
		int divide = Character_Manager.DIVDE;
		int max_moving = Character_Manager.MAX_MOVING;

		for (Character_ox ch_ox_move : ch_list) {
			if (ch_ox_move.isMoving()) {
				if (!ch_ox_move.isIs_x_y()) {
					cpoint = ch_ox_move.getCurrent_point();
					npoint = ch_ox_move.getNext_point();
					dX = Math.abs((double) (cpoint.x - npoint.x) / (double) divide);
					dY = Math.abs((double) (cpoint.y - npoint.y) / (double) divide);
					ch_ox_move.setDx(dX);
					ch_ox_move.setDy(dY);
					ch_ox_move.setIs_x_y(true);
					if (!ch_ox_move.equals(ch_user))
						ch_move_list.add(ch_ox_move);
				}
			}
		}

		if (max_moving > ch_move_list.size())
			max_moving = ch_move_list.size();

		// System.out.println(String.valueOf(ch_move_list.size()>Character_Manager.MAX_MOVING)
		// + " " + ch_move_list.size() + " " + max_moving);
		// if(ch_move_list.size()==5)
		// System.out.println("here");

		for (int i = 0; i < max_moving; i++) {

			if (move_step(ch_move_list.get(i))) {
				ch_move_list.remove(i);
				max_moving--;
			}

		}
		if (ch_user != null)
			if (ch_user.isMoving()) {
				move_step(ch_user);
			}
		// System.out.println(ch_move_list.size());

		return false;
	}

	private boolean move_step(Character_ox character_ox) {
		// TODO Auto-generated method stub
		if (character_ox.getCurrent_pan().rect.contains(character_ox.getCurrent_point())) {

			character_ox.setCurrent_point(character_ox.getNext_point());
			character_ox.setMoving(false);
			character_ox.setIs_x_y(false);
			character_ox.setFirst_move(false);
			return true;

		} else
			character_ox.move();
		return false;

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// 멈춰있는것들을 먼저 그린다.

		for (Character_ox ch : ch_list) {
			if (ch.isMoving())
				ch.draw(g);
			// System.out.println("무빙중이다.");

		}
		drawPan(g);

	}

	private void drawPan(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < opan.ch_lo.length; i++) {
			for (int j = 0; j < opan.ch_lo[i].length; j++) {

				// System.out.println(pan.ch_lo[i][j].isIs_hear());
				if (opan.ch_lo[i][j].getCh() != null)
					if (opan.ch_lo[i][j].isIs_hear() && !opan.ch_lo[i][j].getCh().isMoving()) {
						opan.ch_lo[i][j].getCh().draw(g);
					}
				if (xpan.ch_lo[i][j].getCh() != null)
					if (xpan.ch_lo[i][j].isIs_hear() && !xpan.ch_lo[i][j].getCh().isMoving()) {
						xpan.ch_lo[i][j].getCh().draw(g);
					}

				// System.out.println(opan.ch_lo[i][j].getCh().real_moving());

				// else if(opan.ch_lo[i][j].getBefore_ch()!=null) {
				// if(opan.ch_lo[i][j].getBefore_ch().real_moving())
				// opan.ch_lo[i][j].getBefore_ch().draw(g);
				// }
			}

		}

		// for(int i =0;i<pan.ch_lo.length;i++) {
		// for(int j =0;j<pan.ch_lo[i].length;j++) {
		// if(pan.ch_lo[i][j].getBefore_ch()!=null) {
		// g.setColor(new Color(255,255,0));
		// g.setFont(new Font("굴림",1,2));
		// g.drawString(String.valueOf(pan.ch_lo[i][j].getBefore_ch().real_moving()),
		// pan.ch_lo[i][j].character_start_w, pan.ch_lo[i][j].character_start_h);
		// }
		// }
		// }

	}

	public void user_goto(Pan pan, Character_ox ch) {
		// TODO Auto-generated method stub
		if (ch.isMoving())
			return;
		Character_pan ch_pan = null;
		Character_pan ch_pan2 = null;
		int i = 0;
		int r;
		for (; i < 30; i++) {
			if (pan.ch_priority_lo[i].is_hear == false) {
				ch_pan = pan.ch_priority_lo[i];
				if (i != 29 && pan.ch_priority_lo[i + 1].is_hear == false)
					ch_pan2 = pan.ch_priority_lo[i + 1];
				break;
			}
		}

		if (ch_pan == null && ch_pan2 == null) {
			for (; i < 50; i++) {
				if (pan.ch_priority_lo[i].is_hear == false) {
					ch_pan = pan.ch_priority_lo[i];
					break;
				}
			}
		}
		if (ch_pan2 == (null)) {
			go_ox(ch_pan, ch);

		} else {
			r = rand.nextInt(10) + 1;
			if (1 <= r && 5 >= r)
				go_ox(ch_pan, ch);
			else if (6 <= r && 10 >= r)
				go_ox(ch_pan2, ch);

		}

	}

	public void go_ox(Character_pan ch_pan, Character_ox ch) {
		// TODO Auto-generated method stub
		ch.setNext_point(new Point(ch_pan.character_start_w, ch_pan.character_start_h));
		ch.setMoving(true);
		ch.getCurrent_pan().setIs_hear(false);

		// ch.getCurrent_pan().setBefore_ch(ch.getCurrent_pan().getCh());

		ch.getCurrent_pan().setCh(null);

		// ch.setBefore_pan(ch.getCurrent_pan());

		ch.setCurrent_pan(ch_pan);
		ch.getCurrent_pan().setIs_hear(true);
		ch_pan.setCh(ch);
		// System.out.println(ch.getCurrent_point() + " " + ch.getNext_point());
	}

	public ArrayList<Character_ox> getCh_list() {
		return ch_list;
	}

	public Character_ox getCh_user() {
		return ch_user;
	}

	public Pan getOpan() {
		return opan;
	}

	public Pan getXpan() {
		return xpan;
	}

	public void multiplayer_goto(Pan pan, Character_ox ch, Character_pan[] ai_move) {
		// TODO Auto-generated method stub
		// if (ch.isMoving())
		// return;
		Character_pan ch_pan = null;
		Character_pan ch_pan2 = null;
		int i = 0;
		int r;
		boolean[] ai_is_not_hear = new boolean[50];

		for (int j = 0; j < 50; j++) {
			ai_is_not_hear[j] = true;
			for (Character_pan ai_hear : ai_move)
				if (!(ai_hear == null))
					if (pan.ch_priority_lo[j].getPriority() == ai_hear.getPriority()) {
						ai_is_not_hear[j] = false;
						break;
					}
		}

		for (; i < 50; i++) {
			if (pan.ch_priority_lo[i].is_hear == false && ai_is_not_hear[i]) {
				ch_pan = pan.ch_priority_lo[i];
				break;
			}
		}

		go_ox(ch_pan, ch);

	}

	public boolean user_all_move() {
		for (Character_ox ch : ch_list) {
			if (ch.isMoving()) {
				return false;
			}
		}
		return true;

	}

	public void setOpan(Pan opan) {
		this.opan = opan;
	}

	public void setXpan(Pan xpan) {
		this.xpan = xpan;
	}

}
