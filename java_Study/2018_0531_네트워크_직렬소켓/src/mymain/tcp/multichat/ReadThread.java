package mymain.tcp.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//데이타를 읽을 수 있는 리드 쓰레드

public class ReadThread extends Thread {

	MultiChatServer frame;
	// 사실 이것보다는 내부클래스가 좋다.
	// 그래야지만 이 ReadThread 클래스 안에 있는 자원들을 자유롭게 사용할 수 있기 때문이다.
	Socket child;
	//BufferedReader br;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public ReadThread() {
		// TODO Auto-generated constructor stub
	}

	public ReadThread(MultiChatServer frame, Socket child) {
		super();
		this.frame = frame;
		this.child = child;

		try {
			ois = new ObjectInputStream(child.getInputStream());
			oos = new ObjectOutputStream(child.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true) {
			try {
				//String readStr = br.readLine();
				//데이터 수신
				MyData data = (MyData)ois.readObject();
				if (data == null)
					break;
				// 상대방 소켓이 close()되었을 때
				String display = String.format("[%d][%s][%s]", data.data_protocol,data.user_name,data.message);
				frame.my_display_message(display);
				//String[] data = readStr.split("#");
				
				
			

				switch (data.data_protocol) {
				case MyData.IN:
					
					synchronized (frame) {
						frame.userList.add(data.user_name);
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
					break;
				case MyData.CHAT : 
					synchronized (frame) {
						String [] bad_string = {"개놈","나쁜놈","바보"};
						
						for(String bad : bad_string)
							data.message = data.message.replaceAll(bad, "***");
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
					break;
				case MyData.GRIM :
					synchronized (frame) {
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
				
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				break;// 클로즈 안하고 끈경우
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 종료직전(쓰레드가 소멸직전)
		synchronized (frame) {
			int index = frame.socketList.indexOf(this);
			// 현재 객체가 soketList의 몇번째 객체냐?
			frame.socketList.remove(this);

			// 사용자 수 갱신
			frame.my_display_user_count();

			String out_user_name = frame.userList.get(index);

			// 유저퇴장처리
			frame.userList.remove(index);

			frame.my_display_userlist();
			
			frame.my_send_userlist();
			
			//String out_message = String.format("OUT#%s\n", out_user_name);
			
			MyData data = new MyData();
			data.data_protocol = MyData.OUT;
			data.user_name = out_user_name;
			
			frame.my_send_message_all(data);
		}

	}

}
