package oddsEvens;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		final String FILENAME = "C:/Users/16ML0369/Downloads/oddevendata.dat";
		File fll = new File(FILENAME);
		Scanner sc = new Scanner(fll);
		
		OddEvenSets s;
		
		while(sc.hasNext()){
			s = new OddEvenSets(sc.nextLine());
			System.out.println(s.toString());
		}
		sc.close();
	
	}
}