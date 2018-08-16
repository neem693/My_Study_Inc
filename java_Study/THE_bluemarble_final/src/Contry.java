import java.awt.Graphics;

public class Contry extends Set_Contry {

	public Contry() {
	};

	public Contry(String name, int x, int y, int money, Boolean check, int unin) { // 객체 생성시 생성자를 통해 사진의 위치 및 이름설정

		pos.width = 200; // 크기 설정
		pos.height = 200;
		pos.x = x;
		pos.y = y;
		contry_name = name; // 나라 이름 설정
		price = money; // 나라 초기 가격을 객체로 생성하면서 생성자로 초기화
		city_buy_check = check;
		unique_num = unin; // 각 나라의 고유번호를 초기화시 같는다.

	}

	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

		g.drawImage(Contry_Class.bulding, pos.x, pos.y + y, null);

	}

	public void draw(Graphics g, int x, int y, int j) {
		// TODO Auto-generated method stub

		g.drawImage(Contry_Class.play2_bulding, pos.x, pos.y + y, null);

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g, String name) {
		// TODO Auto-generated method stub

		/*
		 * if(name=="독일") {g.drawImage(blue_marble.헝가리img,pos.x,pos.y,null);
		 * System.out.println( "이미지" ); }
		 */

		switch (name) {

		case "start":
			g.drawImage(Contry_Class.startimg, pos.x, pos.y, null);
			break;
		case "독일":
			g.drawImage(Contry_Class.독일img, pos.x, pos.y, null);
			break;
		case "스웨덴":
			g.drawImage(Contry_Class.스웨덴img, pos.x, pos.y, null);
			break;
		case "프랑스":
			g.drawImage(Contry_Class.프랑스img, pos.x, pos.y, null);
			break;
		case "일본":
			g.drawImage(Contry_Class.일본img, pos.x, pos.y, null);
			break;
		case "이탈리아":
			g.drawImage(Contry_Class.이탈리아img, pos.x, pos.y, null);
			break;
		case "아일랜드":
			g.drawImage(Contry_Class.아일랜드img, pos.x, pos.y, null);
			break;
		case "스페인":
			g.drawImage(Contry_Class.스페인img, pos.x, pos.y, null);
			break;
		case "필란드":
			g.drawImage(Contry_Class.필란드img, pos.x, pos.y, null);
			break;
		case "헝가리":
			g.drawImage(Contry_Class.헝가리img, pos.x, pos.y, null);
			break;
		case "루마니아":
			g.drawImage(Contry_Class.루마니아img, pos.x, pos.y, null);
			break;
		case "대한민국":
			g.drawImage(Contry_Class.대한민국img, pos.x, pos.y, null);
			break;
		case "노르웨이":
			g.drawImage(Contry_Class.노루웨이img, pos.x, pos.y, null);
			break;
		case "무인도":
			g.drawImage(Contry_Class.무인도img, pos.x, pos.y, null);
			break;
		case "중국":
			g.drawImage(Contry_Class.중국img, pos.x, pos.y, null);
			break;
		case "러시아":
			g.drawImage(Contry_Class.러시아img, pos.x, pos.y, null);
			break;

		default:
			System.out.println("제대로 넣어라 잘못됬다.");

		}

	}

}
