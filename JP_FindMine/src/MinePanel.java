import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MinePanel extends JPanel implements Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int cols; // 초기 열 설정 수
	int rows; // 초기 행 설정 수
	int mines; // 초기 지뢰 설정 수
	int mineCount; // 남은 마인 개수를 출력하기 위한 int변수, 단 여기서 마인은 총마인 - 사용자가 표시한 마인임 
	int[][] minelocation; // 마인과 숫자의 실제 위치
	JButton[][] mineButton; // 지뢰 버튼
	JLabel restMine; // 마인 남은 개수를 출력 하는 라벨
	static final int MINE = -1; // 마인 표시
	static final int BLANK = 0; // 빈칸 표시
	boolean isEnd; // 진행중이면 true, 끝났으면 false
	
	MinePanel(int rows, int cols, int mines)
	{
		this.cols = cols;
		this.rows = rows;
		this.mines = mines;
		this.mineCount = mines;
		this.restMine = new JLabel("남은지뢰: " + mineCount);
		isEnd = false;
		
		mineButton = new JButton[rows][cols];
		minelocation = new int[rows][cols];
		setLayout(new GridLayout(rows,cols)); // 레이아웃 설정: 그리드
		
		/*초기에 마우스 리스너를 사용하지 않고 액션 리스너만 사용했을 때의 코드. 사용하지 않으므로 주석처리*/
//		ActionListener listener = e ->
//		{
//			for(int i = 0; i < rows; i++)
//			{
//				for(int j = 0; j < cols; j++)
//				{
//					if(e.getSource() == mineButton[i][j] )
//					{
//						mineCheck(i, j);
//					}
//				}
//			}
//		};
		
		
		
		for(int i = 0; i<rows;i++)
		{
			for(int j = 0; j<cols;j++)
			{
				
				mineButton[i][j] = new JButton(); // 버튼 초기화.
				mineButton[i][j].addMouseListener(new MouseListener() {
				
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) // 마우스 누르자 마자 발생하는 이벤트, 클릭으로 했을 때는 마우스 떼는 순간이 누르는 순간과 다를 수 있어서 누르자 마자 발생하는 게 좋을 것 같음.
					{
						for(int i = 0; i < rows; i++)
						{
							for(int j = 0; j < cols; j++)
							{
								if(e.getSource() == mineButton[i][j] && e.getButton() == 3) // 버튼에 대고 오른쪽 클릭을 했을 때
								{
									markMine(i, j); // 해당 버튼에 주석표시를 하겠다.
									restMine.setText("남은 지뢰: " + mineCount);
								}
								else if(e.getSource() == mineButton[i][j] && e.getButton() == 1) // 버튼에 대고 왼쪽 클릭을 했을 때
								{
									mineCheck(i, j); // 해당 버튼을 열어보겠다.
									if(isWin()) // 버튼을 열 때마다 이겼는지 확인. 승리조건: 버튼이 비활성화된 수 = 전체 버튼 수(행x열) - 지뢰 수
									{
										gameWin(); // 게임 승리 출력
									}
								}
							}
						}
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				add(mineButton[i][j]);
				
			}
		}
		startGame();
		setVisible(true);
	}
	MinePanel() // 마인 패널 디폴트 생성자: 첫 시작할때는 초급난이도로 시작함
	{
		this(10, 10, 10);
	}
	
	void startGame() // 처음 게임을 시작했을 때 마인 및 숫자를 부여하는 메서드
	{
		isEnd = false; // 게임 진행여부(false:진행)를 false로 돌림.
		int count = mines; // 초기 지뢰를 설정하기 위해 설정한 변수, 예) 50개면 버튼 50개에 지뢰를 설정
		mineCount = mines; // 
		// 초기 지뢰 설정하는 단계 (숫자 미부여)
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				mineButton[i][j].setEnabled(true);
				mineButton[i][j].setBackground(Color.WHITE);
				mineButton[i][j].setText(null);
				if(count > 0)
				{
					minelocation[i][j] = MINE;
				}
				else
				{
					minelocation[i][j] = BLANK;
				}
				count--;
			}
		}
		
		// 지뢰 섞는 단계 (숫자 미부여)
		int temp = 0;
		for(int i=0; i< rows; i++)
		{
			for(int j=0; j<cols; j++)
			{ 
				int com1 = (int)(Math.random()*rows);
				int com2 = (int)(Math.random()*cols);
				temp = minelocation[i][j];
				minelocation[i][j] = minelocation[com1][com2];
				minelocation[com1][com2] = temp;

			}
		}
		
		// 지뢰 근처 숫자를 부여하는 단계 주변에 있는 지뢰의 개수만큼 카운트
			for(int i = 0; i <rows; i++)
			{
				
				for(int j = 0; j<cols; j++)
				{
					count = 0;
					if(minelocation[i][j] == MINE)
					{
						continue;
					}
					else if(minelocation[i][j] == BLANK)
					{
						try {
							if(minelocation[i][j+1] == MINE)
							{
								count++;
							}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
							if(minelocation[i][j-1] == MINE)
							{
								count++;
							}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
						if(minelocation[i-1][j] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
						if(minelocation[i-1][j+1] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
						if(minelocation[i-1][j-1] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
						if(minelocation[i+1][j] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae){}
						
						try {
						if(minelocation[i+1][j-1] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae) {}
						
						try {
						if(minelocation[i+1][j+1] == MINE)
						{
							count++;
						}
						}catch(ArrayIndexOutOfBoundsException ae) {}
						minelocation[i][j] = count;
					}
				}
			}
	
/* 더이상 사용하지 않음. 지난 과제 제출용 코드 */
//		// 버튼에 지뢰 부여하는 단계
//		for(int i=0; i<rows;i++)
//		{
//			for(int j=0; j<cols; j++)
//			{
//				mineButton[i][j].setText(minelocation[i][j]+"");
//			}
//		}
		
	}
	void gameLose() // 게임 졌을 때 출력하고 초기화하는 메서드
	{
		isEnd = true;
		JOptionPane.showMessageDialog(null,"게임에서 졌습니다.");
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(minelocation[i][j] == -1) // 그외의 버튼 예외처리: 마인일 경우
				{
					if(mineButton[i][j].getBackground().equals(Color.WHITE)) // 마인이면서 색이 하얀색인 경우 
					{
						mineButton[i][j].setBackground(Color.RED); // 빨간색으로 색을 바꿈
						mineButton[i][j].setEnabled(false); // 버튼을 비활성화 시키겠음.
					}
					else if(mineButton[i][j].getBackground().equals(Color.BLUE)) // 그외 실제 마인이면서 사용자가 마킹해서 색이 파란색일 경우
					{
						mineButton[i][j].setBackground(Color.GREEN); // 진건 아쉽지만 잘 찾았기에 초록색 표시
						mineButton[i][j].setEnabled(false);
					}
				}
				else // 그 외: 숫자나 빈칸일 경우의 예외처리
				{
					if(mineButton[i][j].getBackground().equals(Color.WHITE))// 마킹하지 않은 것
					{
						mineButton[i][j].setBackground(Color.LIGHT_GRAY); // 밝은 회색으로 돌리고
						mineButton[i][j].setEnabled(false);	// 비활성화
					}
					if(mineButton[i][j].getBackground().equals(Color.BLUE)) // 사용자가 마킹한 것 즉 실제 마인이 아닌데 잘못 찾은 것.
					{
						mineButton[i][j].setBackground(Color.PINK); // 핑크색으로 돌리고
						mineButton[i][j].setEnabled(false); // 비활성화
					}
				}
				if(minelocation[i][j] != 0 && minelocation[i][j] != -1)
				{
					mineButton[i][j].setText(minelocation[i][j]+"");
				}
			}
		}
	}
	void gameWin() // 게임이 이겼을 때 이겼다는 메세지를 출력함
	{
		isEnd = true;
		JOptionPane.showMessageDialog(getParent(),"게임에서 이겼습니다.");
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				mineButton[i][j].setEnabled(false); // 어차피 다 열려져 있는 상태이니 버튼만 비활성화 시키면 됨.
				if(minelocation[i][j] == -1) // 버튼 처리: 마인일 경우
				{
					if(mineButton[i][j].getBackground().equals(Color.BLUE)) // 그외 실제 마인이면서 사용자가 마킹해서 색이 파란색일 경우
					{
						mineButton[i][j].setBackground(Color.GREEN); // 잘 찾았기에 초록색 표시
					}
				}
			}
		}
	}
	boolean isWin() // 게임에서 이겼는지 조건 확인용 메서드
	{
		int disableCount = 0;
		
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j< cols; j++)
			{
				if(!(mineButton[i][j].isEnabled()))
				{
					disableCount++;
				}
			}
		}
		
		if (disableCount == rows*cols-mines)
			return true;
		else
			return false;
	}
	void mineCheck(int rows, int cols)// 처음 클릭한 마인을 체크하는 메서드
	{
		if(minelocation[rows][cols] == MINE)
		{
			if(mineButton[rows][cols].isEnabled())
			{
				mineButton[rows][cols].setBackground(Color.ORANGE); // 선택한 해서 게임 패배의 원인이 된 마인은 오렌지색으로 표시함.
				gameLose();
			}
		}
		else if(minelocation[rows][cols] == BLANK)
		{
			mineButton[rows][cols].setBackground(Color.LIGHT_GRAY); 
			mineButton[rows][cols].setEnabled(false);
			
			if(cols+1 != this.cols && !mineButton[rows][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows][cols+1].isEnabled())
				doubleCheck(rows,cols+1);
			if(cols-1 != -1 && !mineButton[rows][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows][cols-1].isEnabled())
				doubleCheck(rows,cols-1);
			if(rows+1 != this.rows && cols+1 != this.cols&& !mineButton[rows+1][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols+1].isEnabled())
				doubleCheck(rows+1,cols+1);
			if(rows+1 != this.rows && !mineButton[rows+1][cols].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols].isEnabled())
				doubleCheck(rows+1,cols);
			if(rows+1 != this.rows && cols-1 != -1 && !mineButton[rows+1][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols-1].isEnabled())
				doubleCheck(rows+1,cols-1);
			if(rows-1 != -1 && cols+1 != this.cols && !mineButton[rows-1][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols+1].isEnabled())
				doubleCheck(rows-1,cols+1);
			if(rows-1 != -1 && !mineButton[rows-1][cols].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols].isEnabled())
				doubleCheck(rows-1,cols);
			if(rows-1 != -1 && cols-1 != -1 && !mineButton[rows-1][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols-1].isEnabled())
				doubleCheck(rows-1,cols-1);
			
		}
		else
		{
			mineButton[rows][cols].setBackground(Color.LIGHT_GRAY); 
			mineButton[rows][cols].setText(minelocation[rows][cols]+"");
			mineButton[rows][cols].setEnabled(false);
		}
	}
	void doubleCheck(int rows, int cols) // 클릭한 마인이 아니라 주변부 마인부터 체크하는 메서드, 두번째 탐색부터는 주변에 있는것이 지뢰라 하여도 게임이 종료되어선 안된다.
	{
		if(minelocation[rows][cols] == MINE)
		{
		}
		else if(minelocation[rows][cols] == BLANK ) // 빈칸일 때
		{
			mineButton[rows][cols].setBackground(Color.LIGHT_GRAY); 
			mineButton[rows][cols].setEnabled(false);
			if(cols+1 != this.cols && !mineButton[rows][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows][cols+1].isEnabled())
				doubleCheck(rows,cols+1);
			if(cols-1 != -1 && !mineButton[rows][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows][cols-1].isEnabled())
				doubleCheck(rows,cols-1);
			if(rows+1 != this.rows && cols+1 != this.cols&& !mineButton[rows+1][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols+1].isEnabled())
				doubleCheck(rows+1,cols+1);
			if(rows+1 != this.rows && !mineButton[rows+1][cols].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols].isEnabled())
				doubleCheck(rows+1,cols);
			if(rows+1 != this.rows && cols-1 != -1 && !mineButton[rows+1][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows+1][cols-1].isEnabled())
				doubleCheck(rows+1,cols-1);
			if(rows-1 != -1 && cols+1 != this.cols && !mineButton[rows-1][cols+1].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols+1].isEnabled())
				doubleCheck(rows-1,cols+1);
			if(rows-1 != -1 && !mineButton[rows-1][cols].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols].isEnabled())
				doubleCheck(rows-1,cols);
			if(rows-1 != -1 && cols-1 != -1 && !mineButton[rows-1][cols-1].getBackground().equals(Color.BLUE) && mineButton[rows-1][cols-1].isEnabled())
				doubleCheck(rows-1,cols-1);
		}
		else // 숫자일 때
		{
			mineButton[rows][cols].setBackground(Color.LIGHT_GRAY); 
			mineButton[rows][cols].setText(minelocation[rows][cols]+"");
			mineButton[rows][cols].setEnabled(false);
		}
	}
	void markMine(int rows, int cols) // 해당위치의 마인을 표시하는 메서드
	{
		if(mineButton[rows][cols].isEnabled())
		{
			if(mineButton[rows][cols].getBackground().equals(Color.WHITE))
			{
				mineButton[rows][cols].setBackground(Color.BLUE);
				mineCount--;
				
			}
			else if(mineButton[rows][cols].getBackground().equals(Color.BLUE))
			{
				mineButton[rows][cols].setBackground(Color.WHITE);
				mineCount++;
			}
		}
	}
	
	// getter, setter 메서드
	public int getMineCount()
	{
		return mineCount;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMines() {
		return mines;
	}
	public void setMines(int mines) {
		this.mines = mines;
	}
	public JButton[][] getMineButton() {
		return mineButton;
	}
	public void setMineButton(JButton[][] mineButton) {
		this.mineButton = mineButton;
	}
	public int[][] getMinelocation() {
		return minelocation;
	}
	public void setMinelocation(int[][] minelocation) {
		this.minelocation = minelocation;
	}
	
}
