import java.util.Scanner;

public class PascalTriangle {
	public static void main(String[] args)
	{
		int[][] value = new int [10][10];
	
		// 파스칼의 삼각형 초기화 부분
		for(int i = 0; i < 10;i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(i == 0 || j == 0)
					value[i][j] = 1;
				else
				value[i][j] = value[i][j-1] + value[i-1][j];  
			}		
		}
		Scanner scanner = new Scanner(System.in);
		// 파스칼의 삼각형 출력부분
		while(true)
		{
			System.out.println("몇번째 줄을 출력할까요? (종료:-1): ");
			
			int input = scanner.nextInt();
			if(input == -1)
			{
				break;
			}
			
			int index = 0;
			int i = input -1;
			int j = 0;
			while(index < input)
			{
				
				System.out.print(value[i][j] + " ");
				i--;
				j++;
				index++;
			}
			System.out.println();
		}
		scanner.close();
		
	}
}
