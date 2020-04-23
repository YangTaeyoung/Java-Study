
public class RectangleArea {
	int a;
	int b;
	RectangleArea(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	RectangleArea()
	{
		this(0,0);
	}
	int getArea(int a, int b)
	{
		return a*b;
	}
}