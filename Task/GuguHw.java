package Task;

public class GuguHw {
	
	int[] evenGugu(int num){
		// �����ϳ��� �Է¹޾Ƽ�
		// �ش������� 1���� 9���� ���� ���� �����ϴ� 1���� �迭��
		// �����ϴ� �޼���
		// 1���� �迭�� ���鶧 for�� ���
		int [] guguEven = new int [9];
		for(int i = 0; i < guguEven.length; i++)
		{
			guguEven[i] = num*(i+1);
		}
		System.out.println("===" + num + "��===");
		return guguEven;
	}
	
	int[] oddGugu(int num){
		// �����ϳ��� �Է¹޾Ƽ�
		// �ش������� 1���� 9���� ���� ���� �����ϴ� 1���� �迭��
		// �����ϴ� �޼���
		// 1���� �迭�� ���鶧 while�� ���	
		int [] guguOdd = new int [9];
		
		int i = 0 ;
		while(i < guguOdd.length)
		{
			guguOdd[i] = num*(i+1);
			i++;
		}
		System.out.println("===" + num + "��===");
		return guguOdd;
	}
	
	void printGugu(int[] gugu)
	{
		// 1���� �迭�� �ϳ� �Է� �޾Ƽ�
		// �迭�ȿ� �ִ� ������� ����Ұǵ�
		// ¦�� �ε��� ���� �������� ����ϴ� �޼���
//		if(gugu[0] % 2 == 0) // ¦�� ���� ���������ΰ�?
//		{
//			for(int i = gugu.length-1; i > -1; i-- )
//			{
//				System.out.println(gugu[i]/(i+1)+" �� " + (i+1) + " = " + gugu[i]);
//			}
//		}
//		else 
//		{
//			for (int i = 0; i < gugu.length; i++)
//			{
//				System.out.println(gugu[i]/(i+1)+" �� " + (i+1) + " = " + gugu[i]);
//			}
//		}
		
		for(int i = 0; i < gugu.length; i++) // �ƴϸ� �ε����� ��������?
		{
			if(i % 2 == 0)
			{
				System.out.println(gugu[gugu.length-i-1]/(gugu.length-i)+" �� " + (gugu.length-i) + " = " + gugu[gugu.length-i-1]);
			}
			else
			{
				System.out.println(gugu[i]/(i+1)+" �� " + (i+1) + " = " + gugu[i]);
			}
			
		}
	}
}
