package mymain;

import java.util.StringTokenizer;

public class MyMain_StringTokenizer {
	public static void main(String[] args) {
		String str = "서울 경기 인천 대전 대구 광주";
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// 현재토큰가져온 후 다음 토큰으로 이동
			System.out.println(token);
		}
		System.out.println("--------------");
		System.out.println("split 메소드 사용");
		String[] sido_array = str.split(" ");
		// " " 공백이라는 String 값으로 해당 문자열 값을 분리한다.
		for (String s : sido_array)
			// for(int i =0; i<sido_array.length;i++)
			// System.out.println(sido_array[i]);
			// 와 같다.
			System.out.println(s);
	}
}
