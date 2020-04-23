import java.util.Scanner;

public class StringGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "";
		Scanner scanner = new Scanner(System.in);
		while(input != null && !input.equals("exit"))
		{
			System.out.print("문: ");
			input = scanner.nextLine();
			if(input.equals("안녕?"))
			{
				System.out.println("응 ㅎㅇ");
			}
			else if(input.equals("이름이뭐니"))
			{
				System.out.println("양태영");
			}
			else if(input.equals("오늘날씨는어때?"))
			{
				System.out.println("창 밖을 봐 눈이없니");
			}
			else if(input.equals("자바기반응용프로그래밍수업어떠니"))
			{
				System.out.println("정말 유익하고 재미있는 수업, 교수님이 정말 친절하게 잘 설명해주셔");
			}
			else if(input.equals("지금기분은어때?"))
			{
				System.out.println("자바 기반응용프로그래밍 수업을 듣고 있어서 너무 신나");
			}
			else if(input.equals("exit"))
			{
				System.out.println("날 끄다니, 실망이야.");
			}
			else
			{
				System.out.println("이상한걸 입력했어 친구");
			}
		}
	}
}
