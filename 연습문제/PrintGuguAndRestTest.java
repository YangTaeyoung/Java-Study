import java.util.Scanner;

public class PrintGuguAndRestTest {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("수행할 작업을 선택하십시오: ");
		int x = scanner.nextInt();
		
		if(x == 2)
		{
			System.out.print("정수 x를 입력하세요: ");
			x = scanner.nextInt();
			System.out.print("정수 y를 입력하세요: ");
			int y = scanner.nextInt();
			System.out.println("x를 y로 나눈 나머지는: " + (x%y)+"입니다");
		}
		else if (x == 1)
		{
			System.out.print("몇단을 출력하실건가요: ");
			
			int y = scanner.nextInt();
			
			System.out.println(y + " × " + 1 + " = " + (y*1));
			System.out.println(y + " × " + 2 + " = " + (y*2));
			System.out.println(y + " × " + 3 + " = " + (y*3));
			System.out.println(y + " × " + 4 + " = " + (y*4));
			System.out.println(y + " × " + 5 + " = " + (y*5));
			System.out.println(y + " × " + 6 + " = " + (y*6));
			System.out.println(y + " × " + 7 + " = " + (y*7));
			System.out.println(y + " × " + 8 + " = " + (y*8));
			System.out.println(y + " × " + 9 + " = " + (y*9));	
		}
		else
		{
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		}
		
	}
}
