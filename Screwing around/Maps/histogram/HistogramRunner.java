package histogram;

import java.io.File;
import java.io.IOException;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		Histogram test = new Histogram("a b c d e f g h i a c d e g h i h k");
		System.out.println(test);

		test.setSentence("1 2 3 4 5 6 1 2 3 4 5 1 3 1 2 3 4");
		System.out.println(test);

		test.setSentence("Y U I O Q W E R T Y");
		System.out.println(test);

		test.setSentence("4 T # @ ^ # # #");
		System.out.println(test);	
	}
}