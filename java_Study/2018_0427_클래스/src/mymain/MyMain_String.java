package mymain;

public class MyMain_String {

	public static void main(String[] args) {
		String str = "우리나라 대한민국";
		System.out.println(str.length());
		int index = str.indexOf('나');
		System.out.println(index);
		System.out.printf("'나'의 위치는 :%d\n",index);
		
		index = str.indexOf("나라");
		System.out.printf("'나라'의 위치는 :%d\n",index);
		
		str = "I am Tom Tom & Tom";
		
		index = str.indexOf("Tom");
		System.out.printf("\"Tom\"의 위치는 :%d\n",index);
		
		index = str.lastIndexOf("Tom");
		System.out.printf("뒤에서부터 검색된 Tom의 위치는 :%d\n",index);

		//추출기능
		String jumin_no = "901212-1234567";
		char gender = jumin_no.charAt(7);
		System.out.println(gender);
		
		/*
           		1900년대생 		2000년대생
		   남자		1(5:외)		3(7)
		   여자		2(6)		4(8)
		 */
		
		String str_year = jumin_no.substring(0, 2);
		int year = Integer.parseInt(str_year);
		
		
		
		if(gender =='1' || gender == '2'||gender =='5' ||gender=='6')
			year += 1900;
		else
			year += 2000;
		
		System.out.println(year);
		
		String str_month = jumin_no.substring(2,4);
		String season = "";
		
		/*
		 * 3~5 :봄
		 * 6-8 :여름
		 * 9~11 : 가을
		 * 12,1,2 : 겨울
		 * 
		 */
		
		switch(str_month)
		{
		case "03":
		case "04":
		case "05": season = "봄";break;
		case "06":
		case "07":
		case "08": season = "여름";break;
		case "09":
		case "10":
		case "11": season = "가을";break;
		default: season = "겨울";
		}
		//더 좋은 방법
		System.out.println(season);
		
		int month = Integer.parseInt(str_month);
		switch(month/3) {
		case 1: season = "봄"; break;
		case 2: season = "여름"; break;
		case 3: season = "가을"; break;
		default: season = "겨울";
		}
		
	
		
		
	}
}
