import java.awt.Image;

import javax.swing.ImageIcon;

public class Contry_Class {
	//나라 객체 생성	
	static Contry start = new Contry("start", 0, 800, 1000, true,1); // 이름 ,위치x,위치y,나라별 가격,구매가능여부,고유번호
	static Contry 독일 = new Contry("독일", 200, 800, 70000, true,2);
	static Contry 노루웨이 = new Contry("노르웨이", 400, 800, 100000, true,3);
	static Contry 러시아 = new Contry("러시아", 600, 800, 120000, true,4);
	static Contry 루마니아 = new Contry("루마니아", 800, 800, 150000, true,5);
	static Contry 스웨덴 = new Contry("스웨덴", 800, 600, 170000, true,6);
	static Contry 필란드 = new Contry("필란드", 800, 400, 210000, true,7);
	static Contry 스페인 = new Contry("스페인", 800, 200, 240000, true,8);
	static Contry 무인도 = new Contry("무인도", 800, 0, -200000, true,9);
	static Contry 아일랜드 = new Contry("아일랜드", 600, 0, 260000, true,10);
	static Contry 이탈리아 = new Contry("이탈리아", 400, 0, 290000, true,11);
	static Contry 프랑스 = new Contry("프랑스", 200, 0, 310000, true,12);
	static Contry 중국 = new Contry("중국", 0, 0, 330000, true,13);
	static Contry 일본 = new Contry("일본", 0, 200, 350000, true,14);
	static Contry 헝가리 = new Contry("헝가리", 0, 400, 380000, true,15);
	static Contry 대한민국 = new Contry("대한민국", 0, 600, 500000, true,16);
	
	
	//이미지 변수 생성
	static Image 다현char = new ImageIcon("character/player10.gif").getImage();
	static Image play2 = new ImageIcon("character/player20.gif").getImage();
	
	static Image slime_myturn = new ImageIcon("character/player11.gif").getImage();
	static Image play2_turn = new ImageIcon("character/player21.gif").getImage();
	
	
	 
	
	
	static Image back_img, 헝가리img, startimg, 프랑스img, 일본img, 이탈리아img, 아일랜드img, 대한민국img, 스페인img, 무인도img, 필란드img, 스웨덴img, 루마니아img,
			독일img, 노루웨이img, 중국img, 러시아img,bulding,play2_bulding;
	
	
	static {
		bulding =  new ImageIcon("contry_img/빌딩.png").getImage();
		play2_bulding =  new ImageIcon("contry_img/play2_빌딩.png").getImage();
		back_img = new ImageIcon("contry_img/blue_back_ground.png").getImage();
		노루웨이img = new ImageIcon("contry_img/노르웨이.png").getImage();
		startimg = new ImageIcon("contry_img/시작1.png").getImage();
		대한민국img = new ImageIcon("contry_img/대한민국.png").getImage();
		헝가리img = new ImageIcon("contry_img/헝가리.png").getImage();
		프랑스img = new ImageIcon("contry_img/프랑스.png").getImage();
		일본img = new ImageIcon("contry_img/일본.png").getImage();
		이탈리아img = new ImageIcon("contry_img/이탈리아.png").getImage();
		아일랜드img = new ImageIcon("contry_img/아일랜드.png").getImage();
		스페인img = new ImageIcon("contry_img/스페인.png").getImage();
		무인도img = new ImageIcon("contry_img/무인도.png").getImage();
		필란드img = new ImageIcon("contry_img/필란드.png").getImage();
		스웨덴img = new ImageIcon("contry_img/스웨덴.png").getImage();
		루마니아img = new ImageIcon("contry_img/루마니아.png").getImage();
		독일img = new ImageIcon("contry_img/독일.png").getImage();
		중국img = new ImageIcon("contry_img/중국.png").getImage();
		러시아img = new ImageIcon("contry_img/러시아.png").getImage();

	}


static	int[] answer = {0,1,1,0,0,1,0,1,0,1,1,0}; 
	
	static String [] str= {"O" , "X"};
	
	static	String [] str_quiz = {  "원숭이는 지문이 있다", 
									"비행기 블랙박스는 검은색이다",
									"벼룩은 간을 가지고 있다",
									"물고기도 기침을 한다",
									"낙지의 심장의 3개 이다",
									"박지성은 심장이 2개 이다",
									"세계에서 가장 긴 강은 나일강이다",
									"북극이 남극보다 더 춥다",
									"탱고의 고장은 아르헨티나다",
									"시소는 우리말이다",
									"맥주를 많이 마시면 배가 나온다",
									"TV 소리를 크게하면 전기요금이 약간 더 나온다"}; //[0~11]








}
