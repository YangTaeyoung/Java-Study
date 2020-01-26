
public abstract class Worker 
{
	String name; // 이름
	int score; // 성과(판매량)
	double salary; // 기본급
	
	abstract void printInfo(); // 객체 안에 담겨있는 모든 변수 정보를 출력,  
	abstract double getTotalSalary(); // 총 인센티브를 포함한 월급을 반환
	abstract boolean promotionCheck(); // 승진 대상자임을 확인하는 메서드 각 조건에 맞으면 true 그렇지 않으면 false를 반환, 클래스 내 조건을 확인하여 만들 것
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
