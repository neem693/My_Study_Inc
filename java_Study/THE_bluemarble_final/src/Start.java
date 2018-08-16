

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Handler;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

// awt -> 확장 -> swing
// Frame         JFrame

public class Start extends JFrame implements ActionListener {
	
     JPanel startPan;
     
     AirManager am = new AirManager();
     
     Timer timer;
     
     int flg_timer=0;
 	
     Handler handler;

	 public static Image [] airplane = new Image[34];
    
     static {
    	 
    	 
    	 for(int i = 0; i < airplane.length; i++)
    	 {
    		 String filename = String.format("airplane/exp_%02d.png", i+1);
    		 airplane[i] = new ImageIcon(filename).getImage();
    		 continue;
    	 }
     }

    
	public Start() {
		// TODO Auto-generated constructor stub
		super("투기의 정석");

		/*// 위치
		this.setLocation(200, 100);
		
		// 크기지정
		this.setSize(400,300);*/
		
		init_start_pan();
		
		init_timer();

		// 위치 + 크기 정보
		this.setBounds(400, 200, MyConst.STARTPAN_W, MyConst.STARTPAN_H);
		//this.setBounds(200, 0, 1215, 1040);

		// 보여줘라
		this.setVisible(true);

		// 종료코드
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_timer() {
		// TODO Auto-generated method stub
           ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			    if(am.move()==false) {// 비행기 프레임이 다돌았으면 timer,t 실행
			    
			    	timer.stop();
			    	//t.start();
			    	new Blue_Marble(); // start 버튼 클릭시 blue_marble 실행
					setVisible(false); // Start 클래스 창이 사라지고 blue_marble 클래스가 실행
			    	
			    }
			    startPan.repaint();
			}

		};
		timer = new Timer(10, listener);
		//timer.start();
		
	}

	private void init_start_pan() {
		// TODO Auto-generated method stub
		//JPanel start = new JPanel(new BorderLayout());

		am.air_pos(0, 0);
		
		startPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				
			
				//g.drawImage(start, 0, 0, this);
				am.draw(g);
				
				//g.drawImage(Start.player, 0, 0, this);
		
			}
		};
		
		//startPan.setPreferredSize(new Dimension(1215, 1040));
		startPan.setPreferredSize(new Dimension(MyConst.STARTPAN_W, MyConst.STARTPAN_H));
		this.add(startPan,"Center");
	
		JButton jbt_start = new JButton(new ImageIcon("START.png"));
				
		JButton jbt_exit = new JButton(new ImageIcon("EXIT.png"));
		startPan.add(jbt_start); 
		startPan.add(jbt_exit);
		jbt_start.setContentAreaFilled(false);
		jbt_exit.setContentAreaFilled(false);
		jbt_start.setBounds(40, 270, 121, 50);
		jbt_exit.setBounds(895, 382, 121, 50);
		startPan.setLayout(null);
		
		
		/*t = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				
				//new blue_marble(); // start 버튼 클릭시 blue_marble 실행
				//setVisible(false); // Start 클래스 창이 사라지고 blue_marble 클래스가 실행
				// TODO Auto-generated method stub
				
			}
		});
	     t.setRepeats(false);//타이머가 반복하는지 여부를 설정하거나 가져옵니다.
	     
	     */
		jbt_start.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			       
	
					if(flg_timer==0)
					{

						timer.start();
						//t.start();
						
						flg_timer=1;
						
					    File file_buy = new File("music/비행기1.wav");
						    
						    try {
								AudioInputStream stream = AudioSystem.getAudioInputStream(file_buy);
								Clip clip = AudioSystem.getClip();
								clip.open(stream);
								clip.start();
								//clip.loop(count);
								FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
								gainControl.setValue(-18f); // 볼륨 컨트롤
								} catch (Exception w) {
								// TODO: handle exception
								w.printStackTrace();
							}
						
                        
                 
						
						//new blue_marble(); // start 버튼 클릭시 blue_marble 실행
						//setVisible(false); // blue_marble 닫기 눌르면 play 창까지 종료
						
					}

			}
		});
		
	  
		
		jbt_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0); // exit 버튼 입력시 종료
			}
		});
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

