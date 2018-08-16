package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//  awt ->확장 -> swing
//  Frame         JFrame

public class MyMain_Teacher1 extends JFrame {

	JLabel jlb_date;
	JLabel jlb_time;
	JLabel jlb_stop_watch;
    Font font = new Font("굴림체",Font.BOLD,20);
    
    Thread t_stop_watch;
    int stop_hour,stop_minute,stop_second,stop_mili_sec;
    long start_time;
	
	public MyMain_Teacher1() {
		// TODO Auto-generated constructor stub
		super("쓰레드 Ex1");

		//현재 수행되고 있는 쓰레드 확인
		//System.out.println(Thread.currentThread().getName());
		
		
		JPanel p = new JPanel(new GridLayout(4, 1));
		jlb_date = new JLabel("날짜",JLabel.CENTER);
		jlb_time = new JLabel("시간",JLabel.CENTER);
		jlb_stop_watch = new JLabel("00:00:00 .000",JLabel.CENTER);
		//폰트적용
		jlb_date.setFont(font);
		jlb_time.setFont(font);
		jlb_stop_watch.setFont(font);
		
		p.add(jlb_date);
		p.add(jlb_time);
		p.add(jlb_stop_watch);
		
		
		//4번째줄...
		JPanel p1 = new JPanel();
		JButton jbt_start = new JButton("시작");
		JButton jbt_stop  = new JButton("중지");
		JButton jbt_clear  = new JButton("초기화");
		p1.add(jbt_start);
		p1.add(jbt_stop);
		p1.add(jbt_clear);
		
		p.add(p1);
		
		this.add(p,"Center");
		
		//스탑와치 버튼 이벤트
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object evt_bt = e.getSource();
				
				if(evt_bt==jbt_start) {
					
					start_time = System.currentTimeMillis();//시작(기준)시간
					t_stop_watch.resume();//재가동
					
					
				}else if(evt_bt==jbt_stop) {
					
					t_stop_watch.suspend();//일시정지
					
				}else if(evt_bt==jbt_clear) {
					
					stop_hour=stop_minute=stop_second=stop_mili_sec = 0;
					jlb_stop_watch.setText("00:00:00.000");
					
				} 
			}
		};
		
		jbt_start.addActionListener(listener);
		jbt_stop.addActionListener(listener);
		jbt_clear.addActionListener(listener);
		
		
		
		
		
		//날짜돌리는 쓰레드
		init_date_thread();
		
		//시간돌리는 쓰레드
		init_time_thread();
		
		//stopwatch 돌리는 쓰레드
		init_stopwatch_thread();
		
		
		//위치
		//this.setLocation(200, 100);
		//크기지정
		//this.setSize(400, 300);

		// 위치 + 크기정보
		this.setBounds(200, 100, 400, 200);

		//보여줘라
		this.setVisible(true);

		//종료코드
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_stopwatch_thread() {
		// TODO Auto-generated method stub
		// 익명내부 클래스
		t_stop_watch = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					long end_time = System.currentTimeMillis();
					
					int gap_mili_sec = (int)(end_time - start_time);
					
					//System.out.println(gap_mili_sec);
					stop_mili_sec = gap_mili_sec % 1000;
					
					int total_sec = gap_mili_sec / 1000; //현재까지 경과된 sec
					
					stop_hour = total_sec / 3600;
					total_sec = total_sec % 3600;
					
					stop_minute = total_sec / 60;
					stop_second = total_sec % 60;
					
					String str_stop_watch = 
							String.format("%02d:%02d:%02d.%03d", 
									     stop_hour,stop_minute,stop_second,stop_mili_sec
									);
					jlb_stop_watch.setText(str_stop_watch);
					
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		
		t_stop_watch.start();//대기열추가 runnable
		t_stop_watch.suspend();//일시정지
		
		
	}

	private void init_date_thread() {
		// TODO Auto-generated method stub
		//1.Thread생성방법(상속받아서 생성하는 방법)
		class DateThread extends Thread
		{
			int color = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
				{
					//System.out.printf("현재수행쓰레드  %s\n",currentThread().getName());
					try {
						Calendar c = Calendar.getInstance();//현재 시스템 날짜
						int year 	= c.get(Calendar.YEAR);
						int month 	= c.get(Calendar.MONTH) + 1;
						int day 	= c.get(Calendar.DATE);
						
						String str_date = String.format("%d년 %02d월 %02d일", 
								                       year,month,day 
								);
						
						//날짜기록하는 JLabel에 넣는다
						jlb_date.setForeground(color==0 ? Color.RED : Color.YELLOW);
						jlb_date.setText(str_date);
						
						if(color==0)color = 1;
						else color = 0;
						
						
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		Thread t = new DateThread();//new(생성)
		t.start();                  //구동 => Runnable상태로 진입
		//t.run();
	
	}
	
	private void init_time_thread() {
		// TODO Auto-generated method stub
		//System.out.println(Thread.currentThread().getName());
		//2.Thread생성(사용)방법: Thread수행객체를 독립적으로 생성관리
		
		class TimeRunnable implements Runnable
		{
			@Override
			public void run() { //Thread Procedure(수행코드)
				// TODO Auto-generated method stub
				while(true) {
					
					//System.out.println(Thread.currentThread().getName());
					try {
						
						Calendar c 	= Calendar.getInstance();
						int hour 	= c.get(Calendar.HOUR_OF_DAY);
						int minute 	= c.get(Calendar.MINUTE);
						int second	= c.get(Calendar.SECOND);
						int mili_sec = c.get(Calendar.MILLISECOND);
						
						String str_time = 
								String.format("%02d:%02d:%02d %03d", 
										      hour,minute,second,mili_sec);
						jlb_time.setText(str_time);
												
						
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}//run() 종료되면 해당 쓰레드는 Dead(소멸)
		}
		
		TimeRunnable tr = new TimeRunnable();
		//               //수행객체전달
		Thread t = new Thread(tr);
		t.start();//절대 t.run()직접호출하면 안된다
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_Teacher1();
	}

}