package network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ox_survive.Ox_Suvive;

public class Ox_survive_Client extends JFrame {

	Ox_Suvive ox_survive;
	JPanel main_panel;
	JPanel north_panel;
	JLabel server_label;
	JLabel nick_label;
	JButton connect_server;
	JButton ready_nick_set;
	boolean connect = false;
	boolean ready = false;

	JTextArea jtext;
	JTextField jserver_addr;
	JTextField jnick_name;
	JScrollPane jscroll;
	JList<String> juser;
	Socket socket;

	ObjectInputStream ios;
	ObjectOutputStream oos;

	public Ox_survive_Client() {
		super("내가만든 윈도우");
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		init_panel_button();
		init_event();
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void connect_socket() {
		// TODO Auto-generated method stub
		if (connect == false) {

			try {

				socket = new Socket(divide_get(0), Integer.parseInt(divide_get(1)));
				connect = true;
				check_view();
				oos = new ObjectOutputStream(socket.getOutputStream());
				ios = new ObjectInputStream(socket.getInputStream());

				Ox_Survive_Data data = new Ox_Survive_Data();
				data.protocol = Ox_Survive_Data.USER_IN;
				data.nick_name = InetAddress.getLocalHost().getHostAddress();
				oos.writeObject(data);
				read_data();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				show_the_message("서버가 죽은거 같다.");
				init_client();

			}
		} else {
			connect = false;
			init_client();

		}

	}

	private void init_client() {
		// TODO Auto-generated method stub
		if (connect)
			connect = false;
		if (ready)
			ready = false;

		try {
			socket = null;
			ios.close();
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();

		}
		check_view();

	}

	private String divide_get(int i) {
		// TODO Auto-generated method stub
		// 0이면 ip 2는 포트이다.

		String[] str;
		try {
			str = jserver_addr.getText().split(":");
			switch (i) {
			case 0:
				return str[0].trim();
			case 1:
				return str[1].trim();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			show_the_message("포트를 입력하라고!! 마지막 네 부분 예)192.168.0.5:7000");
		}

		return null;
	}

	private void show_the_message(String display) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		jtext.append(String.format("%s\n", display));
		int position = jtext.getDocument().getLength();
		jtext.setCaretPosition(position);

	}

	private void check_view() {
		// TODO Auto-generated method stub
		// 서버에 연결하고 레디 하는 클라이언트 정보에 대해서 계속 체크하여 계속해서 view를 변화시킨다.

		if (connect) {
			connect_server.setText("연결끊기");
			ready_nick_set.setEnabled(true);// 연결이 되면 레디가 가능하지만
		} else {
			connect_server.setText("서버연결");
			ready_nick_set.setEnabled(false);// 연결이 안될경우 레디 자체가 가능하지 않도록 함.
		}
		if (!ready) {
			ready_nick_set.setText("닉네임 적용&레디");
		} else
			ready_nick_set.setText("레디해제");

	}

	private void read_data() {
		// TODO Auto-generated method stub

		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					try {
						Ox_Survive_Data data = (Ox_Survive_Data) ios.readObject();
						show_the_message(data.protocol + "번 프로토콜을 받았습니다.");
						switch (data.protocol) {
						case Ox_Survive_Data.USER_IN:
							show_the_message(data.nick_name + "님이 입장하셧습니다. 헤헷");
							
							
							break;
						case Ox_Survive_Data.USER_LIST:
							juser.setListData(data.user_list);
							break;
						case Ox_Survive_Data.USER_OUT:
							show_the_message(data.nick_name + "님이 퇴장하셨습니다. ㅋㅋ");
							break;
						case Ox_Survive_Data.GAME_START:
							ox_survive = new Ox_Suvive();
							ox_survive.setIos(ios);
							ox_survive.setOos(oos);
							
							break;	
						case Ox_Survive_Data.INITIALIZE_GAME:
							ox_survive.send_message(data);
							break;
						case Ox_Survive_Data.NEXT_ROUND:
						
							ox_survive.send_message(data);
							break;
						case Ox_Survive_Data.KILL:
							ox_survive.send_message(data);
						case Ox_Survive_Data.CHARACTER_MOVE:
							ox_survive.send_message(data);
							break;

						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						show_the_message("연결끊김");
						init_client();
						break;
					}
				}

			}

		}.start();

	}

	private void init_event() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (connect_server == e.getSource()) {
					connect_socket();
				}
				if (ready_nick_set == e.getSource()) {
					ready_nick_set();

				}
			}

		};
		connect_server.addActionListener(action);
		ready_nick_set.addActionListener(action);

	}

	protected void ready_nick_set() {
		// TODO Auto-generated method stub
		Ox_Survive_Data data = new Ox_Survive_Data();
		check_view();

		if (ready) {
			data.protocol = Ox_Survive_Data.READY_CANCLE;
			ready = false;

		} else {

			data.protocol = Ox_Survive_Data.READY_NICKSET;
			data.nick_name = jnick_name.getText().trim();
			ready = true;

		}
		try {
			oos.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		check_view();

	}

	private void init_panel_button() {
		// TODO Auto-generated method stub
		main_panel = new JPanel(new BorderLayout());
		main_panel.setPreferredSize(new Dimension(600, 400));

		north_panel = new JPanel(new GridLayout(3, 2));

		connect_server = new JButton("서버연결");
		north_panel.add(connect_server);

		ready_nick_set = new JButton("닉네임 적용&레디");
		north_panel.add(ready_nick_set);
		ready_nick_set.setEnabled(false);

		server_label = new JLabel("서버 ip");
		server_label.setFont(new Font("굴림", 0, 15));
		server_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(server_label);

		nick_label = new JLabel("닉네임");
		nick_label.setFont(new Font("굴림", 0, 15));
		nick_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(nick_label);
		jserver_addr = new JTextField("192.168.0.5:7000");
//		try {
//			jserver_addr = new JTextField(InetAddress.getLocalHost().getHostAddress()+":7000");
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		north_panel.add(jserver_addr);

		jnick_name = new JTextField();
		north_panel.add(jnick_name);

		main_panel.add(north_panel, BorderLayout.NORTH);

		jtext = new JTextArea();
		jscroll = new JScrollPane(jtext);
		jscroll.setPreferredSize(new Dimension(400, 400));
		main_panel.add(jscroll, BorderLayout.WEST);

		juser = new JList<String>();
		juser.setPreferredSize(new Dimension(200, 400));
		main_panel.add(juser, BorderLayout.EAST);
		//
		String[] list_data = { "오라트리", "로라트리", "냠냠냠" };
		//
		juser.setListData(list_data);

		this.add(main_panel);

	}

	public static void main(String[] args) {
		new Ox_survive_Client();
		// new Ox_Suvive();

	}

}