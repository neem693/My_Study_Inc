package pv;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

import images.Images;
import main.MyConst;
import utill.Character_Manager;
import utill.Character_pan;
import utill.Item;
import utill.Pan;

public class Character_ox extends Item  implements Serializable {

	final static int CHARACTER_COUNT = 4;
	String currentLocation;
	int ch_count;
	ImageIcon character_Image;
	Character_pan current_pan;
	Character_pan before_pan;

	Point current_point;
	Point next_point;
	boolean moving;
	boolean is_x_y;
	boolean first_move;
	boolean drawing;

	double dx, dy;
	Random rand;

	public Character_ox() {
		// TODO Auto-generated constructor stub
		super();
		first_move = false;
		moving = false;
		is_x_y = false;
		rand = new Random();
		ch_count = rand.nextInt(CHARACTER_COUNT) + 1;
		switch (ch_count) {
		case 1:
			character_Image = Images.RYON;
			break;
		case 2:
			character_Image = Images.APEACHE;
			break;
		case 3:
			character_Image = Images.TUBE;
			break;
		case 4:
			character_Image = Images.MUZI;
			break;

		}
	}

	public Character_ox(int x, int y) {
		this();
		this.current_point = new Point(x, y);

	}

	public Point getCurrent_point() {
		return current_point;
	}

	public void setCurrent_point(Point current_point) {
		this.current_point = current_point;
	}

	public Point getNext_point() {
		return next_point;
	}

	public void setNext_point(Point next_point) {
		this.next_point = next_point;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {

		this.moving = moving;
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		if (!first_move)
			first_move = true;
		if (current_point.x < next_point.x)
			current_point.x += (int) dx;
		else if (current_point.x > next_point.x)
			current_point.x -= (int) dx;

		if (current_point.y < next_point.y)
			current_point.y += (int) dy;
		else if (current_point.y > next_point.y)
			current_point.y -= (int) dy;

		return false;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(character_Image.getImage(), current_point.x, current_point.y, Pan.CH_WIDHT, Pan.CH_HEIGHT, null);
	//	g.drawString(String.valueOf(current_pan.getPriority()), current_point.x, current_point.y);// 테스트 용

	}

	public Character_pan getCurrent_pan() {
		return current_pan;
	}

	public void setCurrent_pan(Character_pan current_pan) {
		this.current_pan = current_pan;
	}

	public boolean isIs_x_y() {
		return is_x_y;
	}

	public void setIs_x_y(boolean is_x_y) {
		this.is_x_y = is_x_y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public void setFirst_move(boolean first_move) {
		this.first_move = first_move;
	}

	public boolean isFirst_move() {
		return first_move;
	}

	public Character_pan getBefore_pan() {
		return before_pan;
	}

	public void setBefore_pan(Character_pan next_pan) {
		this.before_pan = next_pan;
	}
	public boolean real_moving() {
		if(this.moving && !first_move)
			return true;
		else return false;
	}

	public boolean isDrawing() {
		return drawing;
	}

	public void setDrawing(boolean drawing) {
		this.drawing = drawing;
	}
	
	

}
