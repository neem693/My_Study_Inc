package mymain.tcp.multichat;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class MyData implements Serializable{

	
	public static final int IN = 1;
	public static final int OUT = 2;
	public static final int LIST = 4;
	public static final int CHAT = 8;
	public static final int GRIM = 16;
	
	
	
	int data_protocol = IN;
	
	String user_name; 	//대화명
	String message; 	//전송메시지
	
	String [] user_list;//접속자 목록
	
	
	//그리기 데이터
	Point pt;
	int thick;
	Color color;

	
	public int getData_protocol() {
		return data_protocol;
	}

	public void setData_protocol(int data_protocol) {
		this.data_protocol = data_protocol;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getUser_list() {
		return user_list;
	}

	public void setUser_list(String[] user_list) {
		this.user_list = user_list;
	}

	public Point getPt() {
		return pt;
	}

	public void setPt(Point pt) {
		this.pt = pt;
	}

	public int getThick() {
		return thick;
	}

	public void setThick(int thick) {
		this.thick = thick;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
	
	
	
}
