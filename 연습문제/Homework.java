import javax.swing.JOptionPane;

interface Grade{
	void setScore();
	void printScore();
}

class MiddeGrade implements Grade{
	char math;
	char english;
	char science;
	public void setScore()
	{
		math = JOptionPane.showInputDialog(null,"수학 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		english = JOptionPane.showInputDialog(null,"영어 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
		science = JOptionPane.showInputDialog(null,"과학 등급을 입력하세요.","중학교", JOptionPane.INFORMATION_MESSAGE).charAt(0);
	}
	
	public void printScore()
	{
		System.out.println("MiddleGrade "+this);
	}
	public String toString()
	{
		return "[수학="+math+", "+"영어="+english+", "+"과학="+science+"]";
	}
}

class HighGrade implements Grade{
	int math1;
	int math2;
	int english;
	int physics;
	public void setScore()
	{
		math1 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학1 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		math2 = Integer.parseInt(JOptionPane.showInputDialog(null,"수학2 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));		
		english = Integer.parseInt(JOptionPane.showInputDialog(null,"영어 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
		physics = Integer.parseInt(JOptionPane.showInputDialog(null,"물리 점수를 입력하세요.","고등학교", JOptionPane.INFORMATION_MESSAGE));
	}
	public void printScore()
	{
		System.out.println("HighGrade "+this);
	}
	public String toString()
	{
		return "[수학1=" + math1 + ", 수학2=" + math2 + ", 영어=" + english + ", 물리=" + physics + "]";
	}
}


class UnivGrade implements Grade{
	String java;
	String univEng;
	String oOP;
	String dS;
	public void setScore()
	{
		java = JOptionPane.showInputDialog(null,"자바 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		univEng = JOptionPane.showInputDialog(null,"대학영어 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		oOP = JOptionPane.showInputDialog(null,"객체지향 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
		dS = JOptionPane.showInputDialog(null,"자료구조 학점을 입력하세요.","대학점수", JOptionPane.INFORMATION_MESSAGE);
	}
	public void printScore()
	{
		System.out.println("univGrade "+this);
	}
	public String toString()
	{
		return "[자바=" + java + ", 대학영어=" + univEng + ", 객체지향=" + oOP + ", 자료구조=" + dS + "]";
	}
}

public class Homework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grade grade[] = {new MiddeGrade(), new HighGrade(), new UnivGrade()};
		for (Grade g : grade) {
			g.setScore();
		}
		for (Grade g : grade) {
			g.printScore();
		}
	}

}