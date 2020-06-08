import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MinePanel mp;
	JPanel tp;
	JButton initButton;
	GameMenu gm;
	Timer timer;
	JLabel timeText;
	int sec;
	ActionListener listener;
	MainFrame()
	{
		setTitle("지뢰찾기");
		setLayout(new BorderLayout());
		mp = new MinePanel();
		gm = new GameMenu();
		tp = new JPanel(new GridLayout(1,3));
		initButton = new JButton("초기화");
		setSize(mp.getCols()*45, mp.getRows()*45+50);
		timeText = new JLabel("경과시간: 0");
		
		// timer기능 1초가 지날 때마다 sec 변수를 1만큼 올린다.
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!mp.isEnd) // 게임이 진행중일 때만 올리게끔 설정
				{
				timeText.setText("경과시간: "+sec);
				sec++;
				setVisible(true);
				}
				else // 진행중이 아닌 경우(지거나, 이긴경우)는 멈춤
				{
					sec = 0;
					timer.stop();
				}
			}
		});
		timer.start(); // 타이머 시작
		listener = e-> // 버튼 이벤트에 대한 처리.
		{
			// 각 메뉴에 대한 이벤트 처리
			//초기화 버튼을 눌렀을 때
			if(e.getSource() == initButton)
			{
				mp.startGame();
				sec = 0;
				timer.start();
				mp.restMine.setText("남은 지뢰: "+ mp.getMineCount());
				setVisible(true);
			}
			// 새 게임 버튼을 눌렀을 때
			if(e.getSource() == gm.getStart())
			{
				mp.startGame();
				sec = 0;
				timer.start();
				mp.restMine.setText("남은 지뢰: "+ mp.getMineCount());
				setVisible(true);
			}
			// 난이도 설정 버튼을 눌렀을 때
			if(e.getSource() == gm.getSelectLevel())
			{
				int level = 0;
				remove(mp);
				remove(tp);
				tp = new JPanel(new GridLayout(1,3));
				do
				{
					try
					{
						level = Integer.parseInt(JOptionPane.showInputDialog("난이도를 설정합니다.\n1.초급  2.중급  3.고급  4.사용자 지정"));
						switch(level)
						{
						case 1:
							mp = new MinePanel(10,10,10); 
							break;
						case 2:
							mp = new MinePanel(10,20,40);
							break;
						case 3:
							mp = new MinePanel(20,30,99);
							break;
						case 4:
							int icols = Integer.parseInt(JOptionPane.showInputDialog("가로를 입력하세요."));
							int irows = Integer.parseInt(JOptionPane.showInputDialog("세로를 입력하세요."));
							int imines = Integer.parseInt(JOptionPane.showInputDialog("지뢰 수를 입력하세요.")); 
							mp = new MinePanel(irows,icols,imines);
							break;
						default:
							JOptionPane.showMessageDialog(this, "1~4 이외의 수를 입력하셨습니다. 다시 입력합니다.");
							break;
						}
					}catch(NumberFormatException ne)
					{
						JOptionPane.showMessageDialog(this, "숫자 이외의 문자를 입력하셨습니다. 다시 입력합니다.");
					}
				}while(level <1 || level > 4);
				tp.add(initButton);
				tp.add(mp.restMine);
				tp.add(timeText);
				add(tp, BorderLayout.NORTH);
				add(mp,BorderLayout.CENTER);
				setSize(mp.getCols()*45, mp.getRows()*45+50);
				mp.startGame();
				// 새게임이 시작되면 타이머도 초기화 되어야 함.
				mp.isEnd = false;
				sec = 0;
				timer.start();
				
				mp.restMine.setText("남은 지뢰: "+ mp.getMineCount());
				setVisible(true);
			}
			// 종료하기 버튼을 눌렀을 때
			if(e.getSource() == gm.getExit())
			{
				System.exit(0); // 모든 프로그램을 종료
			}
			
			// 저장 버튼을 눌렀을 때
			if (e.getSource() == gm.getSave())
			{
				try
				{
					DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("data.txt")));  // data.txt 로 숫자 정보를 내보낼 것임.
					for(int i = 0; i < mp.getRows(); i++)
					{
						for(int j = 0; j < mp.getCols();j++)
						{
							dos.writeInt(mp.getMinelocation()[i][j]);
						}
					}
					dos.close();
				}
				catch(IOException ie)
				{
					System.out.println(ie.getMessage());
				}
			}
			
			// 불러오기 버튼을 눌렀을 때
			if(e.getSource() == gm.getLoad())
			{
				sec = 0;
				timer.start();
				int[][] temp = new int[mp.getRows()][mp.getCols()];
				try {
					DataInputStream dis = new DataInputStream(new FileInputStream(new File("data.txt"))); // data.txt 에서 숫자 정보를 얻어올 것임.
					for(int i = 0; i < mp.getRows(); i++)
					{
						for(int j = 0; j < mp.getCols(); j++)
						{
							temp[i][j] = dis.readInt();
						}
					}
					mp.setMinelocation(temp);
					dis.close();
				}
				catch(IOException ie){}
			}
			// 도움말 메뉴를 클릭했을 때
			if(e.getSource() == gm.getHelpItem())
			{
				new HelpFrame();
			}
		};// 이벤트 처리 종료
		initButton.addActionListener(listener);
		gm.getSave().addActionListener(listener);
		gm.getLoad().addActionListener(listener);
		gm.getSelectLevel().addActionListener(listener);
		gm.getStart().addActionListener(listener);
		gm.getExit().addActionListener(listener);
		gm.getHelpItem().addActionListener(listener);
		tp.add(initButton);
		tp.add(mp.restMine);
		tp.add(timeText);
		add(tp, BorderLayout.NORTH);
		add(mp,BorderLayout.CENTER);
		setJMenuBar(gm);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
