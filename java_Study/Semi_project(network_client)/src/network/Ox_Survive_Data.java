package network;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.ArrayList;

import pv.Character_User;
import pv.Character_ox;
import utill.Character_pan;
import utill.Pan;

public class Ox_Survive_Data implements Serializable {
	
	
	public static final int READY_NICKSET = 0;//레디하면 닉네임도 적용됨.
	public static final int USER_IN = 1;
	public static final int USER_OUT = 2;
	public static final int USER_LIST = 4;
	public static final int READY_CANCLE = 8;
	public static final int GAME_START = 16;
	public static final int INITIALIZE_GAME = 32;
	public static final int NEXT_ROUND = 64;//PAN과 chlist, 현재 문제와 답, 번호등이 전송한다.
	public static final int END_ROUND =128;
	public static final int CHARACTER_MOVE = 256;//멀티플레이어의 캐릭터가 움직인다.
	public static final int KILL = 512;
	public static final int REQUEST_NEXTROUND = 1024;
	public static final int INITIAL_COMPLETE = 2048;
	///////프로토콜
	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;
	int protocol;
	String nick_name;
	Pan xpan,opan;
	Character_pan [] ai_move;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_ox> ch_user_list;
	String [] user_list;
	String date;
	String player_go;
	
	int key;
	String message;
	//KeyEvent key;
	
	int message_index;
	int user_index;
	boolean kill_allow;
	
	
	
	
	public boolean isKill_allow() {
		return kill_allow;
	}
	public void setKill_allow(boolean kill_allow) {
		this.kill_allow = kill_allow;
	}
	public ArrayList<String> getQuiz_r_n() {
		return quiz_r_n;
	}
	public void setQuiz_r_n(ArrayList<String> quiz_r_n) {
		this.quiz_r_n = quiz_r_n;
	}
	public ArrayList<String> getQuiz_r_m() {
		return quiz_r_m;
	}
	public void setQuiz_r_m(ArrayList<String> quiz_r_m) {
		this.quiz_r_m = quiz_r_m;
	}
	public ArrayList<String> getQuiz_r_c() {
		return quiz_r_c;
	}
	public void setQuiz_r_c(ArrayList<String> quiz_r_c) {
		this.quiz_r_c = quiz_r_c;
	}
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Pan getXpan() {
		return xpan;
	}
	public void setXpan(Pan xpan) {
		this.xpan = new Pan(xpan);
	}
	public Pan getOpan() {
		return opan;
	}
	public void setOpan(Pan opan) {
		this.opan = new Pan(opan);
	}
	public ArrayList<Character_ox> getCh_list() {
		return ch_list;
	}
	public void setCh_list(ArrayList<Character_ox> ch_list) {
		this.ch_list = new ArrayList<Character_ox>();
		this.ch_list.addAll(ch_list);
	}

	public String[] getUser_list() {
		return user_list;
	}
	public void setUser_list(String[] user_list) {
		this.user_list = user_list;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMessage_index() {
		return message_index;
	}
	public void setMessage_index(int message_index) {
		this.message_index = message_index;
	}
	public int getUser_index() {
		return user_index;
	}
	public void setUser_index(int user_index) {
		this.user_index = user_index;
	}
	public ArrayList<Character_ox> getCh_user_list() {
		return ch_user_list;
	}
	public void setCh_user_list(ArrayList<Character_ox> ch_user_list) {
		this.ch_user_list = new ArrayList<Character_ox>();
		this.ch_user_list.addAll(ch_user_list);
	}
	public Character_pan[] getAi_move() {
		return ai_move;
	}
	public void setAi_move(Character_pan[] ai_move) {
		this.ai_move = ai_move;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlayer_go() {
		return player_go;
	}
	public void setPlayer_go(String player_go) {
		this.player_go = player_go;
	}


	
	
	
	

}
