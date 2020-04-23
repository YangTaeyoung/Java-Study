import java.util.Scanner;


public class ScannerEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("x:");
		int x = scanner.nextInt();
		System.out.println("y:");
		int y = scanner.nextInt();
		System.out.println(x +"×"+ y + "=" + x*y);
	}

}
