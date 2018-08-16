

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {

	// 위치 + 크기 // 똥 위치(X,Y), 크기 설정
	public Rectangle pos = new Rectangle();
	//행동 속성,아이템을 움직이는 속성
	// 추상 메소드를 하나라도 포함되있는 클래스는 추상 클래스를 써야합니다.
	
	public abstract boolean move();
	public abstract void draw(Graphics g);
}
