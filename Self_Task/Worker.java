
public abstract class Worker 
{
	String name; // �̸�
	int score; // ����(�Ǹŷ�)
	double salary; // �⺻��
	
	abstract void printInfo(); // ��ü �ȿ� ����ִ� ��� ���� ������ ���,  
	abstract double getTotalSalary(); // �� �μ�Ƽ�긦 ������ ������ ��ȯ
	abstract boolean promotionCheck(); // ���� ��������� Ȯ���ϴ� �޼��� �� ���ǿ� ������ true �׷��� ������ false�� ��ȯ, Ŭ���� �� ������ Ȯ���Ͽ� ���� ��
	public Worker(String name, int score, double salary) 
	{
		this.name = name;
		this.score = score;
		this.salary = salary;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getScore() 
	{
		return score;
	}
	public void setScore(int score) 
	{
		this.score = score;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary) 
	{
		this.salary = salary;
	}
	
	
}
