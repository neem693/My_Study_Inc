package mymain;

import myutil.고등학생;
import myutil.중학생;
import myutil.초등학생;
import myutil.학생;

public class MyMain_학생 {
	
	
	static void 어머님_왈(학생 [] student_array) {
		for(학생 s : student_array)
			s.공부한다();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*학생 [] student_array = {
				new 초등학생(),
				new 중학생(),
				new 고등학생()
		};*/
		//이 말은 곧 아랫말과 같다.
		
		학생 [] student_array = new 학생[3];
		student_array[0] = new 초등학생();
		student_array[1] = new 중학생();
		student_array[2] = new 고등학생();
		
		//학생 s = new 학생(); 이건 안된다.
		//추상클래스는 객체생성 못한다.
		//응? 배열은 왜 되냐?
		//배열이 왜 되겠냐? 어차피 그건 배열이고 그건 방을 의미하기 때문에 추상클래스도 가능하다.
		//그러나 쌩 객체를 만드는 것은 불가능 하다.
		
		
		어머님_왈(student_array);

	}

}
