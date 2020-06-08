import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelpFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	HelpFrame() // 도움말을 출력하기 위한 클래스. 출력 외에 기능 없음.
	{
		setTitle("도움말");
		setLayout(new BorderLayout(50,50));
		setSize(500,300);
		JButton exit = new JButton("확인");
		JTextArea text = new JTextArea("환영합니다. 본 게임은 지뢰찾기 입니다. \n"
				+ "버튼에 있는 숫자는 주변에 있는 지뢰의 수를 나타냅니다.\n"
				+ "오른쪽 클릭을 하게 될 시 본인이 생각하는 지뢰 표시를 할 수 있습니다.\n"
				+ "게임 내의 모든 지뢰를 찾을 시 게임이 종료됩니다.\n"
				+ "게임 내의 지뢰를 찾지 못하고, 지뢰를 발견할 시 사용자가 발견한 지뢰는 오렌지색으로 변하며,\n"
				+ "사용자가 발견하여 마킹표시를 남긴 지뢰는 초록색, 사용자가 마킹했으나 잘못 발견한 지뢰는 핑크색\n"
				+ "사용자가 발견하지 못하고, 마킹표시를 하지 못한 지뢰는 빨간색으로 표시됩니다.\n"
				+ "게임 종료를 알리는 메시지와 함께  게임이 종료됩니다.\n"
				+ "초기화를 누를 시 지뢰 정보가 초기화됩니다.\n"
				+ "게임 란의 난이도 설정을 누르면 지뢰의 수와 게임 사이즈를 조정할 수 있습니다.\n");
		ActionListener listener = e->
		{
			if(e.getSource() == exit)
			{
				dispose(); // 확인 버튼을 누를 경우 해당 창 종료.
			}
		};
		exit.addActionListener(listener);
		add(text,BorderLayout.CENTER);
		add(exit, BorderLayout.SOUTH);
		setVisible(true);
	}
}
