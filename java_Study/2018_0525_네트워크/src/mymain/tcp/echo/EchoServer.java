package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) throws IOException {
		//1.서버소켓생성(port할당, backlog-대기큐갯수)
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("---서버구동중...---");
		
		//2.접속대기
		
		while(true) {
			//1.접속대기->2.요청수락->3.자소켓생성->4.상대방소켓과연결
			Socket child =  server.accept();
			
			//상대방소켓정보(IP)를 획득
			InetAddress ia_you = child.getInetAddress();
			System.out.printf("[%s]님이 접속\n",ia_you.getHostAddress());
			
			//입출력스트림
			
			InputStream is = child.getInputStream();
			OutputStream os = child.getOutputStream();
			
			//2.전송메시지 수신
			byte [] buff = new byte[100];
			// len : 수신크기
			// buff : 데이터 저장
			int len = is.read(buff);
			
			String read_message = new String(buff,0,len);
			System.out.printf("[%s]님이 접속: %s\n",  ia_you.getHostAddress(),read_message);
			
			
			//3.서버에서 수신메시지를 재전송
			os.write(read_message.getBytes());
			
			
		}
	}

}
