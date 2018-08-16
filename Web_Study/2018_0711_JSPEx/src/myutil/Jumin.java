package myutil;


public class Jumin extends MyInfo {
	private String jumin_no;
	private int current_year;

	// 901212-1234567
	// 01234567890123
	/*
	 * 서울특별시 : 00~08
	 * 
	 * 부산광역시 : 09~12
	 * 
	 * 인천광역시 : 13~15
	 * 
	 * 경기도 : 16~25
	 * 
	 * 강원도 : 26~34
	 * 
	 * 충청북도 : 35~39
	 * 
	 * 대전광역시 : 40
	 * 
	 * 충청남도 : 41~43, 45~47
	 * 
	 * 세종특별자치시 : 44, 96
	 * 
	 * 전라북도 : 48~54
	 * 
	 * 전라남도 : 55~66
	 * 
	 * 광주광역시 : 55, 56
	 * 
	 * 대구광역시 : 67~70
	 * 
	 * 경상북도 : 71~81
	 * 
	 * 경상남도 : 82~84, 86~90
	 * 
	 * 울산광역시 : 85
	 * 
	 * 제주특별자치도 : 91~95
	 */
	public Jumin() {
		super();
	}


	public Jumin(String jumin_no) {
		this();
		this.jumin_no = jumin_no;
		super.setYear(this.getYear());
		this.current_year = super.getCurrent_year();
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
		super.setYear(this.getYear());
		this.current_year = super.getCurrent_year();
	}

	public int getYear() {
		String year = jumin_no.substring(0, 2);
		int year_int = Integer.parseInt(year);
		switch (jumin_no.substring(7, 8)) {
		case "1":
		case "2":
		case "5":
		case "6":
			year_int += 1900;
			break;
		case "3":
		case "4":
		case "7":
		case "8":
			year_int += 2000;
			break;
		}
		return year_int;
	};

	public int getAge() {
		return this.current_year - this.getYear() + 1;
	};

	public String getSex() {
		String sp = this.jumin_no.substring(7, 8);
		String sex = "남자";
		switch (sp) {
		case "1":
		case "3":
		case "5":
		case "7":
			sex = "남자";
			break;
		case "2":
		case "4":
		case "6":
		case "8":
			sex = "여자";
			break;
		}
		return sex;
	}

	public String getLocal() {
		String result = "";
		String local_str = jumin_no.substring(8, 10);
		int local_number = Integer.parseInt(local_str);
		if (local_number >= 0 && local_number <= 8)
			result = "서울특별시";
		else if (local_number >= 9 && local_number <= 12)
			result = "부산광역시";
		else if (local_number >= 13 && local_number <= 15)
			result = "인천광역시";
		else if (local_number >= 16 && local_number <= 25)
			result = "경기도";
		else if (local_number >= 26 && local_number <= 34)
			result = "강원도";
		else if (local_number >= 35 && local_number <= 39)
			result = "충청북도";
		else if (local_number == 40)
			result = "대전광역시";
		else if (local_number >= 41 && local_number <= 43 || local_number >= 45 && local_number <= 47)
			result = "충청남도";
		else if (local_number == 44 || local_number == 96)
			result = "세종특별자치시";
		else if (local_number >= 48 && local_number <= 54)
			result = "전라북도";
		else if (local_number >= 55 && local_number <= 66)
			result = "전라남도";
		else if (local_number == 55 || local_number == 56)
			result = "전라남도 광주광역시";
		else if (local_number >= 55 && local_number <= 66)
			result = "전라남도";
		else if (local_number >= 67 && local_number <= 70)
			result = "대구광역시";
		else if (local_number >= 71 && local_number <= 81)
			result = "경상북도";
		else if (local_number >= 82 && local_number <= 84 || local_number >= 86 && local_number <= 90)
			result = "경상남도";
		else if (local_number == 85)
			result = "울산광역시";
		else if (local_number >= 91 && local_number <= 95)
			result = "경상남도";
		return result;
	}

	public String getSeason() {
		String result = "";
		int sn = Integer.parseInt(jumin_no.substring(2, 4));
		switch (sn / 3) {
		case 1:
			result = "봄";
			break;
		case 2:
			result = "여름";
			break;
		case 3:
			result = "가을";
			break;
		default:
			result = "겨울";

		}
		return result;

	}
	/*
	 * 3~5 :봄 6-8 :여름 9~11 : 가을 12,1,2 : 겨울
	 * 
	 */

}
