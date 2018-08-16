import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Set_Contry {
	
	
	String contry_name;
	int price;
	int unique_num;
	boolean city_buy_check;
	
	
	//나라 이미지 크기의 사각형 좌표 생성 (크기 200에 200)
	
	public Rectangle pos = new Rectangle();	
	
	
	public abstract void draw(Graphics g);

	


}
/*
나라별 가격 임시 1000~16000원까지



*/