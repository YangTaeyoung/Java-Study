
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
		System.out.print("ÀÌ¸§: "+ name + "\tÃÑ ¿ù±Ş: " + getTotalSalary() + "\t½ÂÁø¿©ºÎ: "  );
		if(promotionCheck())
		{
			System.out.println("½ÂÁø ´ë»óÀÚ");
		}
		else
		{
			System.out.println("½ÂÁø ´ë»óÀÚ Á¦¿Ü");
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
