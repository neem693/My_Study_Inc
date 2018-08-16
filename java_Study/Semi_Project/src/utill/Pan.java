package utill;

import java.awt.Point;

import main.MyConst;

public class Pan {
	public static final String OPAN = "O";
	public static final String XPAN = "X";
	public static final int WIDTH = (int)(MyConst.GAME_W*MyConst.XPAN_W);
	public static final int HEIGHT = (int)(MyConst.GAME_H*MyConst.XPAN_H);
	public static final int CH_WIDHT = (int)(MyConst.GAME_W*MyConst.XPAN_W*0.1);
	public static final int GAP_W = (int)(CH_WIDHT * 0.75);
	public static final int CH_HEIGHT = 80;
	public static final int GAP_H = (int)(CH_HEIGHT * 0.5);
	public int count=0;
	public String correctLocation;
	
	Point First_Point = new Point(); // 해당 판이 시작하는 지점 왼쪽 위 부분을 말함

	public Character_pan[][] ch_lo;
	// Character_pan [] ch_lo = new Character_pan[30];//캐릭터 로케이션;
	public Character_pan[] ch_priority_lo;

	public Pan() {
		// TODO Auto-generated constructor stub
		super();
		int count = 0;
		ch_lo = new Character_pan[10][5];
		ch_priority_lo = new Character_pan[10*5];
	}

	public Pan(String correctLocation,int x, int y) {
		// TODO Auto-generated constructor stub
		this();
		this.correctLocation = correctLocation;
		First_Point = new Point(x, y);
		int start_point_w = x + (int) (MyConst.GAME_W * MyConst.XPAN_W * 0.1);
		int start_point_h = y + (int) (MyConst.GAME_H * MyConst.XPAN_H * 0.1);
		

		for (int i = 0; i < ch_lo.length; i++) {
			for (int j = 0; j < ch_lo[i].length; j++) {
				int w = start_point_w + (j*Pan.CH_WIDHT + j*Pan.GAP_W);
				int h = start_point_h + (i*Pan.GAP_H);
				ch_lo[i][j] = new Character_pan(w,h);
				
			}
		}
		setPriority(ch_lo);
	}

	private void setPriority(Character_pan[][] ch_lo) {
		// TODO Auto-generated method stub
		int priority =1;
		int x,y;
		int [] x_sequnce = {2,1,3};
		int [] x_sequnce2 = {0,4};
		int [] y_sequnce = {4,3,5,2,6,1,7,0,8,9};
		for(int i =0; i<y_sequnce.length;i++) {
			y = y_sequnce[i];
			for(int j =0;j<x_sequnce.length;j++	) {
				x = x_sequnce[j];
				ch_lo[y][x].setPriority(priority);
				ch_priority_lo[priority -1] = ch_lo[y][x];
				priority++;
			}
		}
		for(int i =0; i<y_sequnce.length;i++) {
			y=i;
			for(int j=0;j<x_sequnce2.length;j++) {
				x = x_sequnce2[j];
				ch_lo[y][x].setPriority(priority);
				ch_priority_lo[priority -1] = ch_lo[y][x];
				priority++;
			}
		}
	}

	public Point getFirst_Point() {
		return First_Point;
	}
	
	
	

	
//	public void set_ch_lo (Character ch,Character_pan ch_pan) {
//	}
	

}
