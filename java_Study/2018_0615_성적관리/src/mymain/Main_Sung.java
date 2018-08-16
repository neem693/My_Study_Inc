package mymain;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import dao.SungTBDao;
import vo.SungVo;

public class Main_Sung extends JFrame {

	// 입,출력필드
	JTextField jtf_no, jtf_name, jtf_kor, jtf_eng, jtf_mat, jtf_tot, jtf_avg, jtf_rank;

	// 작업버튼
	JButton jbt_new, jbt_update, jbt_delete, jbt_prev, jbt_next;

	// 조회
	JTable jtb_display;

	List<SungVo> sung_list;

	boolean bAdd = false;// 추가 or 수정작업여부

	int current_pos = -1;// 현재 출력되는 데이터 인덱스

	public Main_Sung() {
		// TODO Auto-generated constructor stub
		super("성적관리");// 타이틀

		// 입출력필드 및 작업버튼 초기화
		init_inputs();
		// 조회창 초기화
		init_display();

		// 전체데이터 출력
		display_total_list();
		// 데이터가 존재하면

		if (sung_list.size() > 0)
			current_pos = 0;
		display_input_data();

		// 위치 및 크기지정
		// setBounds(200, 100, 400, 300);
		setLocation(300, 100);

		setResizable(false);

		pack();

		// 보여줘라
		setVisible(true);

		// 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void display_input_data() {
		// TODO Auto-generated method stub
		
		if(current_pos>sung_list.size()-1)//성리스트보다 하나적은 값이 현재 커런트 포스라면
			current_pos=sung_list.size()-1;
		check_enable_buttons();
		if (current_pos == -1)
			return;
		
			
			

		SungVo vo = sung_list.get(current_pos);

		jtf_no.setText(String.valueOf(vo.getIdx()));
		jtf_name.setText(vo.getName());
		jtf_kor.setText(String.valueOf(vo.getKor()));
		jtf_eng.setText(String.valueOf(vo.getEng()));
		jtf_mat.setText(String.valueOf(vo.getMat()));
		jtf_tot.setText(String.valueOf(vo.getTot()));
		jtf_avg.setText(String.valueOf(vo.getAvg()));
		jtf_rank.setText(String.valueOf(vo.getRank()));
		
		
		
		check_enable_buttons();
		
		jtb_display.setRowSelectionInterval(current_pos, current_pos);
		

	}

	private void check_enable_buttons() {
		// TODO Auto-generated method stub
		System.out.println(sung_list.size());
		jbt_prev.setEnabled(current_pos > 0 && !(sung_list.size()==0));
		jbt_next.setEnabled(current_pos < sung_list.size() - 1 && !(sung_list.size()==0));
		
		jbt_delete.setEnabled(current_pos != -1);

	}

	// JTable 배치 모델정의

	private void display_total_list() {
		// TODO Auto-generated method stub
		sung_list = SungTBDao.getInstance().selectList();

		class MyTableModel extends AbstractTableModel {

			// 타이틀
			String[] title = { "번호", "이름", "국어", "영어", "수학", "총점", "평균", "등수" };

			@Override
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return title[column];
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return sung_list.size();
			}

			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return title.length;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				Object ob = null;
				switch (columnIndex) {
				case 0:
					ob = sung_list.get(rowIndex).getIdx();
					break;
				case 1:
					ob = sung_list.get(rowIndex).getName();
					break;
				case 2:
					ob = sung_list.get(rowIndex).getKor();
					break;
				case 3:
					ob = sung_list.get(rowIndex).getEng();
					break;
				case 4:
					ob = sung_list.get(rowIndex).getMat();
					break;
				case 5:
					ob = sung_list.get(rowIndex).getTot();
					break;
				case 6:
					ob = sung_list.get(rowIndex).getAvg();
					break;
				case 7:
					ob = sung_list.get(rowIndex).getRank();
					break;

				}

				return ob;
			}

		}

		// JTable에 가져온 데이터 세팅
		jtb_display.setModel(new MyTableModel());

	}

	private void init_inputs() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());
		// 입력창
		JPanel p1 = new JPanel(new GridLayout(4, 2));
		p1.add(new JLabel("번호:"));
		p1.add(jtf_no = new JTextField());

		p1.add(new JLabel("이름:"));
		p1.add(jtf_name = new JTextField());

		p1.add(new JLabel("국어:"));
		p1.add(jtf_kor = new JTextField());

		p1.add(new JLabel("총점:"));
		p1.add(jtf_tot = new JTextField());

		p1.add(new JLabel("영어:"));
		p1.add(jtf_eng = new JTextField());

		p1.add(new JLabel("평균:"));
		p1.add(jtf_avg = new JTextField());

		p1.add(new JLabel("수학:"));
		p1.add(jtf_mat = new JTextField());

		p1.add(new JLabel("등수:"));
		p1.add(jtf_rank = new JTextField());

		// 출력창
		JPanel p2 = new JPanel(new GridLayout(1, 5));
		p2.add(jbt_prev = new JButton("이전"));
		p2.add(jbt_new = new JButton("추가"));
		p2.add(jbt_update = new JButton("수정"));
		p2.add(jbt_delete = new JButton("삭제"));
		p2.add(jbt_next = new JButton("다음"));

		p.add(p1, "Center");
		p.add(p2, "South");

		this.add(p, "Center");

		// 버튼이벤트 초기화
		init_button_event();

		// 읽기전용속성
		jtf_no.setEditable(false);

		jtf_avg.setEditable(false);
		jtf_rank.setEditable(false);
		jtf_tot.setEditable(false);

	}

	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 이벤트를 발생시킨 버튼
				Object evt_src = e.getSource();

				if (evt_src == jbt_new)
					on_new();
				else if (evt_src == jbt_update)
					on_update();
				else if (evt_src == jbt_delete)
					on_delete();
				else if (evt_src == jbt_prev)
					on_prev();
				else if (evt_src == jbt_next)
					on_next();

			}
		};

		jbt_new.addActionListener(listener);
		jbt_update.addActionListener(listener);
		jbt_delete.addActionListener(listener);
		jbt_prev.addActionListener(listener);
		jbt_next.addActionListener(listener);

	}

	protected void on_next() {
		// TODO Auto-generated method stub
		if (current_pos == sung_list.size() - 1) {
			current_pos = 0;
		} else
			current_pos++;

		display_input_data();

	}

	protected void on_prev() {
		// TODO Auto-generated method stub
		if (current_pos == 0) {
			current_pos = sung_list.size() - 1;

		} else
			current_pos--;
		display_input_data();

	}

	protected void on_delete() {
		// TODO Auto-generated method stub
		int res = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?" + sung_list.get(current_pos).getIdx() + "번", "삭제", JOptionPane.YES_NO_CANCEL_OPTION);
		if(res != JOptionPane.YES_OPTION) {
			return;
		}
		sung_delete();
		
		//1. 데이터가 1개만 남았을 경우
		
		
		
		//2.마지막 데이터 삭제시

	}

	private void sung_delete() {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(jtf_no.getText());
		SungVo vo = new SungVo();
		vo.setIdx(idx);
		
		int res = SungTBDao.getInstance().delete(vo);
		display_total_list();
		display_input_data();
		
	}

	protected void on_update() {
		// TODO Auto-generated method stub
		if (bAdd) {
			// 등록작업
			sung_insert();
		} else {
			// 수정작업
			sung_update();

		}

	}

	private void sung_update() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(this, "정말 수정하시겠습니까?","수정",JOptionPane.YES_NO_OPTION);
		if(result != JOptionPane.YES_OPTION) {
			display_input_data();
			return;
		}
		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();
		String str_idx = jtf_no.getText().trim();

		if (name.isEmpty()) {// 이름항목이 비어있으면

			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
			jtf_name.requestFocus();
			return;

		}
		if (str_kor.isEmpty()) {// 국어항목이 비어있으면

			JOptionPane.showMessageDialog(this, "국어점수를 입력하세요");
			jtf_kor.requestFocus();
			return;

		}
		if (str_eng.isEmpty()) {// 영어항목이 비어있으면

			JOptionPane.showMessageDialog(this, "영어점수를 입력하세요");
			jtf_eng.requestFocus();
			return;

		}
		if (str_mat.isEmpty()) {// 수학항목이 비어있으면

			JOptionPane.showMessageDialog(this, "수학점수를 입력하세요");
			jtf_mat.requestFocus();
			return;

		}
		System.out.println("업데이트 잘 작동중....");
		int idx = Integer.parseInt(str_idx);
		int kor = Integer.parseInt(str_kor);
		int eng = Integer.parseInt(str_eng);
		int mat = Integer.parseInt(str_mat);
		
		
		
		SungVo vo = new SungVo();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		
		//SungTBDao 에게 DB insert요청
		int res = SungTBDao.getInstance().update(vo);
		
		
		display_total_list();
		display_input_data();
		

	}

	private void sung_insert() {
		// TODO Auto-generated method stub
		String name = jtf_name.getText().trim();
		String str_kor = jtf_kor.getText().trim();
		String str_eng = jtf_eng.getText().trim();
		String str_mat = jtf_mat.getText().trim();

		if (name.isEmpty()) {// 이름항목이 비어있으면

			JOptionPane.showMessageDialog(this, "이름을 입력하세요");
			jtf_name.requestFocus();
			return;

		}
		if (str_kor.isEmpty()) {// 국어항목이 비어있으면

			JOptionPane.showMessageDialog(this, "국어점수를 입력하세요");
			jtf_kor.requestFocus();
			return;

		}
		if (str_eng.isEmpty()) {// 영어항목이 비어있으면

			JOptionPane.showMessageDialog(this, "영어점수를 입력하세요");
			jtf_eng.requestFocus();
			return;

		}
		if (str_mat.isEmpty()) {// 수학항목이 비어있으면

			JOptionPane.showMessageDialog(this, "수학점수를 입력하세요");
			jtf_mat.requestFocus();
			return;

		}
		
		int kor = Integer.parseInt(str_kor);

		int eng = Integer.parseInt(str_eng);
		int mat = Integer.parseInt(str_mat);
		
		SungVo vo = new SungVo();
		vo.setName(name);
		vo.setKor(kor);
		vo.setEng(eng);
		vo.setMat(mat);
		
		//SungTBDao 에게 DB insert요청
		int res = SungTBDao.getInstance().insert(vo);
		
		//Db에서 변경된상태의 모든 데이터 가져오기
		display_total_list();
		//현재 등록된 데이터 정보 출력
		current_pos = sung_list.size()-1;
		display_input_data();
		
		//작업상태 초기상태로 전환
		bAdd = false;
		jbt_new.setText("추가");
		jbt_update.setText("수정");
		
		


	}

	protected void on_new() {
		// TODO Auto-generated method stub
		bAdd = !bAdd;

		if (bAdd) {
			// 입력준비
			clear_input();
			jbt_next.setEnabled(false);
			jbt_prev.setEnabled(false);
			
		} else {
			// 입력취소
			jbt_next.setEnabled(true);
			jbt_prev.setEnabled(true);
			
			if (sung_list.size() == 0)
				clear_input();
			else
				display_input_data();

		}

		jbt_new.setText(bAdd ? "취소" : "추가");
		jbt_update.setText(bAdd ? "등록" : "수정");

	}

	private void display_input() {
		// TODO Auto-generated method stub

	}

	private void clear_input() {
		// TODO Auto-generated method stub
		jtf_no.setText("");
		jtf_name.setText("");
		jtf_kor.setText("");
		jtf_eng.setText("");
		jtf_mat.setText("");
		jtf_tot.setText("");
		jtf_avg.setText("");
		jtf_rank.setText("");
		// 입력포커스 이름 항목에 가져다 놓는다.
		jtf_name.requestFocus();

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jtb_display = new JTable();
		JScrollPane jsp = new JScrollPane(jtb_display);

		jsp.setPreferredSize(new Dimension(400, 200));

		this.add(jsp, "South");
		
		jtb_display.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				current_pos = jtb_display.getSelectedRow();
				display_input_data();
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main_Sung();
	}

}