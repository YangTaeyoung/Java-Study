package Task;

public class GuguHwTest 
{

	public static void main(String[] args)
	{
		
		GuguHw myGuguHw = new GuguHw();
		
		

		for( int i = 1; i <= 9 ; i++){
		
			if(i < 2) // 2�ܺ��� 9�ܱ��� ����Ұž�
			{
				continue;
			}
			if(i % 2 == 0)
			{
				// ¦���� �϶�
				// evenGugu �޼��带 Ȱ���Ұ� 
				// �� �ϼ��� �迭����
				// printGugu �̿��ؼ� �������.
				myGuguHw.printGugu(myGuguHw.evenGugu(i));
			}
			else
			{
				// Ȧ���� �϶�
				// oddGugu �޼��带 Ȱ���Ұ�
				// �� �ϼ��� �迭����
				// printGugu �̿��ؼ� �������.
				myGuguHw.printGugu(myGuguHw.oddGugu(i));
			}
			
			
			
			
		}
		
	}

}
