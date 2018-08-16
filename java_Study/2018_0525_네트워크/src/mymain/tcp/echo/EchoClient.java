package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String server_ip = "inca001";//지정된 서버
		String local_ip = "localhost";
		
		
		//서버 접속
		Socket client = new Socket(server_ip,7000);
		
		//1-1:입출력 스트림
		InputStream is = client.getInputStream();//수신
		OutputStream os = client.getOutputStream();//전송
		
		//2.메시지 전송
		String message = "메아리";
		//String->byte [] 전송
		os.write(message.getBytes());
		
		//3.전송메시지 수신
		byte [] buff = new byte[100];
		// len : 수신크기
		// buff : 데이터 저장
		int len = is.read(buff);
		
		String read_message = new String(buff,0,len);
		System.out.printf("되돌아온 메시지: %s\n", read_message);
		

	}

}
