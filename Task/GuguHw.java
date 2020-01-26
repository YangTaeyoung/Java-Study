package Task;

public class GuguHw {
	
	int[] evenGugu(int num){
		// 정수하나를 입력받아서
		// 해당정수를 1부터 9까지 곱한 값을 저장하는 1차원 배열을
		// 리턴하는 메서드
		// 1차원 배열을 만들때 for문 사용
		int [] guguEven = new int [9];
		for(int i = 0; i < guguEven.length; i++)
		{
			guguEven[i] = num*(i+1);
		}
		System.out.println("===" + num + "단===");
		return guguEven;
	}
	
	int[] oddGugu(int num){
		// 정수하나를 입력받아서
		// 해당정수를 1부터 9까지 곱한 값을 저장하는 1차원 배열을
		// 리턴하는 메서드
		// 1차원 배열을 만들때 while문 사용	
		int [] guguOdd = new int [9];
		
		int i = 0 ;
		while(i < guguOdd.length)
		{
			guguOdd[i] = num*(i+1);
			i++;
		}
		System.out.println("===" + num + "단===");
		return guguOdd;
	}
	
	void printGugu(int[] gugu)
	{
		// 1차원 배열을 하나 입력 받아서
		// 배열안에 있는 내용들을 출력할건데
		// 짝수 인덱스 값만 역순으로 출력하는 메서드
//		if(gugu[0] % 2 == 0) // 짝수 단을 역순으로인가?
//		{
//			for(int i = gugu.length-1; i > -1; i-- )
//			{
//				System.out.println(gugu[i]/(i+1)+" × " + (i+1) + " = " + gugu[i]);
//			}
//		}
//		else 
//		{
//			for (int i = 0; i < gugu.length; i++)
//			{
//				System.out.println(gugu[i]/(i+1)+" × " + (i+1) + " = " + gugu[i]);
//			}
//		}
		
		for(int i = 0; i < gugu.length; i++) // 아니면 인덱스만 역순으로?
		{
			if(i % 2 == 0)
			{
				System.out.println(gugu[gugu.length-i-1]/(gugu.length-i)+" × " + (gugu.length-i) + " = " + gugu[gugu.length-i-1]);
			}
			else
			{
				System.out.println(gugu[i]/(i+1)+" × " + (i+1) + " = " + gugu[i]);
			}
			
		}
	}
}
