package acronym;

import java.io.FileNotFoundException;


public class AcroRunner
{
	public static void main( String args[] ) throws FileNotFoundException{
		Acronyms s = new Acronyms();
		System.out.println(s.toString());
	}
}