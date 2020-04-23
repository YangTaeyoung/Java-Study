import java.util.Scanner;

public class RectangleTest {
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("가로 길이를 입력하세요: ");
		int a = scanner.nextInt();
		System.out.print("세로 길이를 입력하세요: ");
		int b = scanner.nextInt();
		RectangleArea rec = new RectangleArea(a,b);
		System.out.println("사각형의 넓이: " + rec.getArea(a, b));
	}
}
