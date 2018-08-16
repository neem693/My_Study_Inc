package mymain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ImageViewer extends JFrame {
	static Image image_pic1, image_pic2, image_pic3;
	static {
		image_pic1 = new ImageIcon("초이스.jpg").getImage();

		image_pic2 = new ImageIcon("김규민.jpg").getImage();

		image_pic3 = new ImageIcon("김상수.jpg").getImage();
	}
	//화면에 그릴 이미지
	Image pic = image_pic1;
	JPanel grimPan;
	JPanel util_image;
	int red=255,green=0,blue=0,alpha=120;
	int angle =0;
	double scale = 1.0;
	double trans = 0;
	JSlider sliderRed;
	JSlider sliderGreen;
	JSlider sliderBlue;
	JSlider sliderAlpha;
	JSlider sliderAngle;
	JSlider sliderScale;
	JSlider sliderTrans;
	ChangeListener c_listener;
	ChangeListener scale_listener;

	public ImageViewer() {
		super("내가만든 윈도우");

		init_toolbar_menu();
		
		init_grimpan();
		
		init_color_slider();
		
		init_angle_slider();
		
		init_scale_event_slider();
		
		init_scale_slider();
		
		init_trans_slider();
		
		
		
		init_util_image();
		
		this.setLocation(200,100);
		this.setSize(400,300);
		this.setResizable(false);
		//더군다나 사이즈 변경을 못하게 한다.
		this.pack();
		//자식윈도우 주위를 부모가 감싼다. 즉, 실질적으로 안에 있는 콘텐츠가 가로와 세로의 길이를 설정해준다.
		
		
		
		//this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_scale_event_slider() {
		// TODO Auto-generated method stub
		scale_listener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);
				int sv = sliderScale.getValue();
				switch(sv) {
				case -2 : scale = 0.25;
				break;
				case -1 : scale = 0.5;
				break;
				case  0 : scale = 1;
				break;
				case 1 : scale = 1.5;
				break;
				case 2 : scale = 2;
				
				}
				System.out.println(trans);
				trans = 300.0* (1.0-scale)/2.0;
				System.out.println(trans);
				
				grimPan.repaint();
				
				
			}
		};
		
	}

	private void init_trans_slider() {
		// TODO Auto-generated method stub
		sliderTrans = new JSlider(JSlider.VERTICAL,-100,100,(int)trans);
		sliderTrans.setMajorTickSpacing(10);
		sliderTrans.setPaintTicks(true);
		sliderTrans.setPaintLabels(true);
		
		sliderTrans.addChangeListener(scale_listener);
	}

	private void init_util_image() {
		// TODO Auto-generated method stub
		util_image = new JPanel(new GridLayout(1,3));
		util_image.add(sliderAngle,"slider_Angle");
		util_image.add(sliderScale,"slider_Scale");
		util_image.add(sliderTrans,"slider_Trans");
		this.add(util_image,"East");
	}

	private void init_scale_slider() {
		// TODO Auto-generated method stub
		sliderScale = new JSlider(JSlider.VERTICAL,-2,2,0);
		sliderScale.setMajorTickSpacing(1);
		sliderScale.setPaintTicks(true);
		sliderScale.setPaintLabels(true);
		
		sliderScale.addChangeListener(scale_listener);
		
		
		
	}

	private void init_angle_slider() {
		// TODO Auto-generated method stub
		sliderAngle = new JSlider(JSlider.VERTICAL,0,360,angle);
		sliderAngle.setMajorTickSpacing(50);
		//sliderAngle.setMajorTickSpacing(5);
		
		sliderAngle.setPaintTicks(true);
		sliderAngle.setPaintLabels(true);
		
		//this.add(sliderAngle,"East");
		
		sliderAngle.addChangeListener(c_listener);
		
		
		
		
	}

	private void init_color_slider() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(4,1));
		
		sliderRed = new JSlider(0,255,red);
		sliderGreen = new JSlider(0,255,green);
		sliderBlue = new JSlider(0,255,blue);
		sliderAlpha = new JSlider(0,255,alpha);
		
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setMajorTickSpacing(5);
		
		p.add(sliderRed);
		p.add(sliderGreen);
		p.add(sliderBlue);
		p.add(sliderAlpha);
		

		
		this.add(p,"South");
		
		
		c_listener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				red = sliderRed.getValue();
				green = sliderGreen.getValue();
				blue = sliderBlue.getValue();
				alpha  = sliderAlpha.getValue();
				//System.out.println(sliderRed.getValue());
				angle = sliderAngle.getValue();
						
				
				
				grimPan.repaint();
				
				
			}
		};
		
		sliderRed.addChangeListener(c_listener);
		sliderBlue.addChangeListener(c_listener);
		sliderGreen.addChangeListener(c_listener);
		sliderAlpha.addChangeListener(c_listener);
		

		
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		
		
		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				
				Graphics2D g2 = (Graphics2D) g;
				
				
				g2.rotate(angle*(Math.PI/180), 150, 150);
				//맨처음 쎼타 파라미터는 라디안을 의미한다.
				System.out.println(scale);
				g2.translate(trans, trans);
				g2.scale(scale, scale);
				
				g2.drawImage(pic, 0, 0, this);
				
				Color color = new Color(red,green,blue,alpha);
				g2.setColor(color);
				g2.fillRect(0, 0, 300, 300);
			}
			
		};
		grimPan.setPreferredSize(new Dimension(300, 300));
		
		this.add(grimPan,"Center");
		
	}

	private void init_toolbar_menu() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new GridLayout(1, 3));
		JButton jbt_pic1 = new JButton("사진1");
		JButton jbt_pic2 = new JButton("사진2");
		JButton jbt_pic3 = new JButton("사진3");

		p.add(jbt_pic1);
		p.add(jbt_pic2);
		p.add(jbt_pic3);

		this.add(p, "North");

		// 버튼이벤트 처리객체(익명 로컬 내부클래스)
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e);

				Object evt_bt = e.getSource();
				if (evt_bt == jbt_pic1) {
					System.out.println("--사진1--");
					pic = image_pic1;

				} else if (evt_bt == jbt_pic2) {
					System.out.println("--사진2--");
					pic = image_pic2;


				} else if (evt_bt == jbt_pic3) {
					System.out.println("--사진3--");
					pic = image_pic3;


				}
				grimPan.repaint();
			}
		};
		// 버튼이벤트 등록
		jbt_pic1.addActionListener(listener);

		jbt_pic2.addActionListener(listener);

		jbt_pic3.addActionListener(listener);
		
		

	}

	public static void main(String[] args) {
		new ImageViewer();

	}

}
