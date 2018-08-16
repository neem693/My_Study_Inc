package mymain;

import java.awt.Button;
import java.awt.Frame;

public class MyMain_Win1 {
	

	public static void main(String[] args) {
		
		//awt(Abstract Window Toolkit) : 윈도우 내용을 추상화
		//메인윈도우
		
		Frame f = new Frame();
		//위치설정
		f.setLocation(100, 100);
		//크기지정
		f.setSize(400,300);
		//화면에 보여지기
		f.setVisible(true);
		
		
		Button bt = new Button("클릭하세요");
		Button bt1 = new Button("동쪽에 있는 버튼");
		
		f.add(bt,"South");
		f.add(bt1,"East");
		//화면에 보여지기

	}

}
