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
		System.out.print("이름: " + name + "\t총 월급: " + getTotalSalary() + "\t일한 시간: "+ hours + "\t승진여부: ");
		if (promotionCheck())
		{
			System.out.println("정규직 승진");
		}
		else
		{
			System.out.println("비정규직 유지");
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
