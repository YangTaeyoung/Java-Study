public class PartTimeJob extends Worker 
{
	int hours;
	public PartTimeJob(String name, int score, double salary, int hours) 
	{
		super(name, score, salary);
		this.hours = hours;
	}

	double getTotalSalary()
	{
		return salary + (score * 2000);
	}

	void printInfo() 
	{
		System.out.print("�̸�: " + name + "\t�� ����: " + getTotalSalary() + "\t���� �ð�: "+ hours + "\t��������: ");
		if (promotionCheck())
		{
			System.out.println("������ ����");
		}
		else
		{
			System.out.println("�������� ����");
		}
	}

	boolean promotionCheck() {
		if (score >= 200 && hours >= 50) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
}
