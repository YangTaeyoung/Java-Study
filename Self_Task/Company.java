public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int WORKER_NUM = 5; // worker���� ��. ������ ���� �������� �ʵ��� �ٲܰ�.
		Worker [] myWorker = new Worker[WORKER_NUM]; // worker���� ������ ���� ������ ����.(��ü�迭�� ���� ����� �ʾұ� ������ ����θ� �̸� �߰��صξ����ϴ�.)
		
		myWorker[0] = new FullTimeJob("�豸��", 72, 4500000);
		myWorker[1] = new PartTimeJob("�ڿ���", 254, 2000000, 55);
		myWorker[2] = new PartTimeJob("������", 132, 1500000, 48);
		myWorker[3] = new FullTimeJob("������", 332, 3000000);
		myWorker[4] = new FullTimeJob("������", 552, 2300000);
		
	
		
		for(int i = 0;i<WORKER_NUM; i++)// ��º�
		{
			myWorker[i].printInfo();
		}
	}
}
