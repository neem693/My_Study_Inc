package mymain.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_0_객체직렬화 {

	public static void main(String[] args) throws Exception {
		/*// TODO Auto-generated method stub
		PersonVo p1 = new PersonVo("일갈동",30,"서울 구로구 구로3동");
		FileOutputStream fos = new FileOutputStream("person.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p1);
		
		oos.close();
		fos.close();
*/
		//직렬화 데이터 읽어오기
		InputStream fis = new FileInputStream("Person.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		PersonVo p2 = (PersonVo)ois.readObject();
		
		System.out.println(p2);
		
		ois.close();
		fis.close();
		
	}

}
