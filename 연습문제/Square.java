
public class Square {
	
	private String color;
	private int Area;
	
	public Square(String color, int Area) {
		super();
		this.color = color;
		this.Area = Area;
	}
	public Square(String color)
	{
		this(color,1);
	}
	
	public Square(int Area)
	{
		this("하얀",Area);
	}
	public Square()
	{
		this("하얀",1);
	}
	
	void printSquare()
	{
		System.out.println("이 정사각형은 넓이가 "+Area+"인 "+color+"색 입니다.");
	}
}
