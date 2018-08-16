package utill;

import java.awt.Graphics;
import java.awt.Rectangle;

import pv.Character_ox;



public class Character_pan {


	int character_start_w;
	int character_start_h;
	int priority;
	boolean is_hear; // 캐릭터가 이 좌표에 없음을 나타냄
	Character_ox ch;
	Character_ox before_ch;
	Rectangle rect;
	
	


	

	
	
	
	
	public Character_pan() {
		// TODO Auto-generated constructor stub
		super();
		this.is_hear = false;
		
	}
	
	public Character_pan(int character_start_w, int character_start_h) {
		this();
		this.character_start_w = character_start_w;
		this.character_start_h = character_start_h;
		this.rect = new Rectangle(character_start_w,character_start_h,Pan.CH_WIDHT,Pan.CH_HEIGHT);
	}
	
	


	
	public int getCharacter_start_w() {
		return character_start_w;
	}
	public void setCharacter_start_w(int character_start_w) {
		this.character_start_w = character_start_w;
	}
	public int getCharacter_start_h() {
		return character_start_h;
	}
	public void setCharacter_start_h(int character_start_h) {
		this.character_start_h = character_start_h;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Character_ox getCh() {
		return ch;
	}

	public void setCh(Character_ox ch) {
		this.ch = ch;
	}
	
	
	
	
	public boolean isIs_hear() {
		return is_hear;
	}

	public void setIs_hear(boolean is_hear) {
		this.is_hear = is_hear;
	}

	public void empty_pan() {
		this.ch =null;
		is_hear = false;
	}

	public Character_ox getBefore_ch() {
		return before_ch;
	}

	public void setBefore_ch(Character_ox before_ch) {
		this.before_ch = before_ch;
	}
	
	

	


	
	
	

}
