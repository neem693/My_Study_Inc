package mymain;
import java.io.File;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		File f2 = new File("c:\\My_Study");
		File [] f_array = f2.listFiles();
		//System.out.println(f_array.length);
		//현재 디렉터리에 있는 파일이나 디렉터리 갯수 출력
		
		
		for(File f : f_array) {
				String filename = f.getName();
				//파일명 입력받음
				
				long length = f.length();
				long last_modify = f.lastModified();
				//최근 수정 날짜.
				if(f.isDirectory()) {
					System.out.printf("[D]:%s(%d)-%s-\n",filename,length,new Date(last_modify));
					
				}else if(f.isFile()) {
					System.out.printf("[F]:%s(%d)-%s-\n",filename,length,new Date(last_modify));
				}
				
			
		}

	}

}
