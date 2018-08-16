package mymain.tcp.multichat;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatServer extends JFrame {

	JTextArea jta_display; // 출력창
	JTextField jtf_count; // 접속자수
	JList<String> jlist_user; // 접속자목록
	ServerSocket server;
	// 접속할 자소켓 목록을 저장관리할 객체
	List<ReadThread> socketList = new ArrayList<ReadThread>();
	Font font = new Font("굴림체",Font.BOLD,30);
	List<String> userList = new ArrayList<String>();

	public MultiChatServer() {
		super("멀티채팅 서버");

		// 조회창 초기화
		init_display();

		// 접속자목록 초기화
		init_userlist();

		// 접속자수 초기화
		init_usercount();

		// 서버소켓 초기화
		init_server();

		this.pack();
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void my_display_userlist() {
		//userList=>배열로 얻어낸다.
		String []  user_array = new String[userList.size()];
		userList.toArray(user_array);
		
		jlist_user.setListData(user_array);
	}

	private void init_server() {
		// TODO Auto-generated method stub

		// 서버 대기 쓰레드
		new Thread() {
			public void run() {

				try {
					// 서버 객체 생성
					server = new ServerSocket(9500);
					my_display_message("---서버 구동중---");

					while (true) {
						Socket child = server.accept();
						// 엡섹트가 실패할 경우를 대비해서 여기에 try catch
						ReadThread rt = new ReadThread(MultiChatServer.this, child);
						socketList.add(rt);
						rt.start();

						// 접속자수 갱신
						my_display_user_count();

					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					my_display_message("--서버 구동 실패--");
				}

			};
		}.start();

	}

	protected void my_display_user_count() {
		// TODO Auto-generated method stub
		jtf_count.setText(socketList.size() + " ");

	}

	protected void my_display_message(String message) {
		// TODO Auto-generated method stub
		jta_display.append(message + "\r\n");

		// 최근메시지가 밑으로 내려가는 것 방지
		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	private void init_usercount() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb_title1 = new JLabel("접속자수: ", JLabel.RIGHT);
		
		jtf_count = new JTextField("0");
		
		JLabel jlb_title2 = new JLabel("(명)", JLabel.LEFT);

		p.add(jlb_title1);
		p.add(jtf_count);
		p.add(jlb_title2);
	
		this.add(p, "South");
		jtf_count.setFont(font);
		jtf_count.setHorizontalAlignment(JTextField.CENTER);

	}

	private void init_userlist() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user);

		this.add(jsp, "East");

		jsp.setPreferredSize(new Dimension(150, 400));

//		String[] user_array = { "길동1", "길동2", "삼식이", "길동3" };
//		jlist_user.setListData(user_array);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);

		this.add(jsp, "Center");

		jsp.setPreferredSize(new Dimension(400, 400));

		// 읽기전용
		jta_display.setEditable(false);

	}

	public static void main(String[] args) {
		new MultiChatServer();

	}

	public void my_send_userlist() {
		// TODO Auto-generated method stub
		// 전송데이터 패키징
		//StringBuffer sb = new StringBuffer("LIST#");
		String [] user_list = new String[userList.size()];
		userList.toArray(user_list);
		MyData data = new MyData();
		data.data_protocol = MyData.LIST;
		data.user_list = user_list;
		
		
		my_send_message_all(data);

		
		
		
	}

	void my_send_message_all(MyData data) {
		// TODO Auto-generated method stub
		for(int i=0;i<socketList.size();i++) {
			
			try {
				ReadThread rt = socketList.get(i);
				//rt.child.getOutputStream().write(message.getBytes());
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}