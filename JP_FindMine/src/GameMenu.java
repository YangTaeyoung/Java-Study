
import javax.swing.*;

public class GameMenu extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 각 메뉴 선언
	JMenu game;
	JMenu file;
	JMenu help;
	
	// 각 하위 메뉴 선언
	JMenuItem start;
	JMenuItem selectLevel;
	JMenuItem exit;
	JMenuItem save;
	JMenuItem load;
	JMenuItem helpItem;
	
	public GameMenu()
	{
		// TODO Auto-generated constructor stub
		
		// 각 게임 메뉴 초기화
		game = new JMenu("게임");
		file = new JMenu("파일");
		help = new JMenu("도움말");
		start = new JMenuItem("새 게임");
		selectLevel = new JMenuItem("난이도 설정");
		exit = new JMenuItem("게임 종료");
		save = new JMenuItem("저장");
		load = new JMenuItem("불러오기");
		helpItem = new JMenuItem("도움말");
		
		// 각 메뉴 아이템 각 메뉴에 추가
		game.add(start);
		game.add(selectLevel);
		game.add(exit);
		file.add(save);
		file.add(load);
		help.add(helpItem);
		
		// 각 메뉴 게임 바에 추가
		this.add(game);
		this.add(file);
		this.add(help);
	}
	
	// 메뉴 버튼에 대한 getter, setter
	public JMenu getGame() {
		return game;
	}
	public void setGame(JMenu game) {
		this.game = game;
	}
	public JMenu getFile() {
		return file;
	}
	public void setFile(JMenu file) {
		this.file = file;
	}
	public JMenu getHelp() {
		return help;
	}
	public void setHelp(JMenu help) {
		this.help = help;
	}
	public JMenuItem getStart() {
		return start;
	}
	public void setStart(JMenuItem start) {
		this.start = start;
	}
	public JMenuItem getSelectLevel() {
		return selectLevel;
	}
	public void setSelectLevel(JMenuItem selectLevel) {
		this.selectLevel = selectLevel;
	}
	public JMenuItem getExit() {
		return exit;
	}
	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}
	public JMenuItem getSave() {
		return save;
	}
	public void setSave(JMenuItem save) {
		this.save = save;
	}
	public JMenuItem getLoad() {
		return load;
	}
	public void setLoad(JMenuItem load) {
		this.load = load;
	}
	public JMenuItem getHelpItem() {
		return helpItem;
	}
	public void setHelpItem(JMenuItem helpItem) {
		this.helpItem = helpItem;
	}
	
}
