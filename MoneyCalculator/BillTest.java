package Self_Task;

public class BillTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ���� �Ѿ��� int ������ �ް� �� �ʿ信 ���� 50000��¥��, 10000��¥��, 5000�� ¥�� �� ȭ�� ���� ��� �ʿ����� ����϶�.
		// ���� �ݾ��� �ٲ㵵 ����� �����Ͽ��� ��.
		
		//��� .1: ���� ����ϴ� ������ �����
		int inputCoin = 6912830;
		int bill50000 = inputCoin/50000;
		int bill10000 = inputCoin%50000/10000;
		int bill5000 = inputCoin%50000%10000/5000;
		int bill1000 = inputCoin%50000%10000%5000/1000;
		int coin500 = inputCoin%50000%10000%5000%1000/500;
		int coin100 = inputCoin%50000%10000%5000%1000%500/100;
		int coin50 =  inputCoin%50000%10000%5000%1000%500%100/50;
		int coin10 = inputCoin%50000%10000%5000%1000%500%100%50/10;
		System.out.println("50000�� ����: "+bill50000+" 10000�� ����: " + bill10000 +" 5000�� ����: "+ bill5000 +" 1000�� ����: "
		+ bill1000 +" 500�� ����: " + coin500 +" 100�� ����: "+ coin100 + " 50�� ����: " + coin50 + " 10�� ����: " + coin10);
		System.out.println();
		
		//��� 2: �迭 �̿�
		int[] billType = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int result = inputCoin;
		for(int i = 0; i < billType.length; i++)
		{
			if (billType[i] >= 1000)
				System.out.print(billType[i]+"�� ����: " + result/billType[i] + " ");
			else
				System.out.print(billType[i]+"�� ����: " + result/billType[i] + " ");
			result = result%billType[i];
		}
	}

}
