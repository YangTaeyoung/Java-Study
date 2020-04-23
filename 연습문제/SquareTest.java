
public class SquareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square[] s = new Square[4];
		
		s[0] = new Square("빨강", 5);
		s[1] = new Square("주황");
		s[2] = new Square(3);
		s[3] = new Square();
		
		for(int i = 0; i < s.length; i++)
		{
			s[i].printSquare();
		}
		
	}

}
