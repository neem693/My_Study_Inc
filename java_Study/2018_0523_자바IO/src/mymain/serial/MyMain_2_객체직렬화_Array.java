package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import vo.PersonVo3;

public class MyMain_2_객체직렬화_Array {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		PersonVo3 [] p_array= {
				new PersonVo3("일길동",20,"서울 구로구 구로3동"),
				new PersonVo3("이길동",21,"서울 구로구 구로2동"),
				new PersonVo3("삼길동",22,"서울 구로구 구로1동"),
		};
		
		
		//저장(직렬화) : p_array.dat//
		OutputStream ops = new FileOutputStream("p_array.dat");
		ObjectOutputStream oos = new ObjectOutputStream(ops);
		
		oos.writeObject(p_array);
		
		
		oos.close();
		ops.close();
		
		//복원(역직렬화)//
		
		
		InputStream ins = new FileInputStream("p_array.dat");
		ObjectInputStream ois = new ObjectInputStream(ins);
		
//		if(ois.readObject() instanceof PersonVo3[])
//			System.out.println("같다.");
		
		PersonVo3 [] p_array1 = (PersonVo3[])ois.readObject();
		
		for(PersonVo3 array : p_array1)
			System.out.println(array);
		
		ois.close();
		ins.close();
		
		
		
		
		
		
		
		
		
		

	}

}
