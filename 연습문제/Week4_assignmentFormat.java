import java.util.Scanner;

public class Week4_assignmentFormat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
		System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
		System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
		System.out.println("이외의 입력인 경우 종료.");
		int type = scanner.nextInt(), line;
		
		while(type>=1 && type<=3){
			System.out.print("출력할 줄의 개수를 입력하세요 : ");	line=scanner.nextInt();
			printStar(type,line);
			
			System.out.println("*을 이용하여 출력할 모양을 입력하세요.");
			System.out.println("1: 왼쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("2: 오른쪽으로 치우친 아래쪽이 큰 삼각형");
			System.out.println("3: 우상단에서 좌하단 부분이 비어있는 정사각형");
			System.out.println("이외의 입력인 경우 종료.");
			type = scanner.nextInt();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}
	static void star()
	{
		System.out.print("*");
	}
	static void blank()
	{
		System.out.print(" ");
	}
	public static void printStar(int type, int line){
		switch(type){
		case 1:
			for(int i = 0; i < line; i++)
			{
				for(int j = 0; j <= i; j++)
				{
					star();
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 2:
			for(int i = 0; i< line;i++)
			{
				for(int j = line; j >= 0; j--)
				{
					if(j > i)
					{
						blank();
					}
					else
					{
						star();
					}
				}
				System.out.println();
			}
			System.out.println();
			break;
		case 3:
			for(int i = 0; i < line; i++)
			{
				for(int j = line; j >= 0; j--)
				{
					if(j == i)
					{
						blank();
					}
					else
					{
						star();
					}
				}
				System.out.println();
			}
			System.out.println();
			break;
		default:
			System.out.println("잘못 입력했슈. 프로그램 종료!");
		}
	}
}