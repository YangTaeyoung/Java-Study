package Task;

public class GuguHwTest 
{

	public static void main(String[] args)
	{
		
		GuguHw myGuguHw = new GuguHw();
		
		

		for( int i = 1; i <= 9 ; i++){
		
			if(i < 2) // 2단부터 9단까지 출력할거야
			{
				continue;
			}
			if(i % 2 == 0)
			{
				// 짝수단 일때
				// evenGugu 메서드를 활용할것 
				// 이 완성된 배열단을
				// printGugu 이용해서 출력하자.
				myGuguHw.printGugu(myGuguHw.evenGugu(i));
			}
			else
			{
				// 홀수단 일때
				// oddGugu 메서드를 활용할것
				// 이 완성된 배열단을
				// printGugu 이용해서 출력하자.
				myGuguHw.printGugu(myGuguHw.oddGugu(i));
			}
			
			
			
			
		}
		
	}

}
