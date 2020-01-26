
public class FullTimeJob extends Worker{
	
	public FullTimeJob(String name, int score, double salary) 
	{
		super(name, score, salary);
	}
	
	double getTotalSalary() 
	{
		return salary + (score*4000);
	}
	void printInfo() 
	{
		System.out.print("�̸�: "+ name + "\t�� ����: " + getTotalSalary() + "\t��������: "  );
		if(promotionCheck())
		{
			System.out.println("���� �����");
		}
		else
		{
			System.out.println("���� ����� ����");
		}
	}
	boolean promotionCheck() { 
		if(score >= 400)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
