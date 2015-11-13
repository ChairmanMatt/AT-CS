package worksheet_4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;
import static java.lang.System.*;

public class HistoListRunner
{
	public static void main(String[] args)
	{
		//A A A A B V S E A S A A
		HistoList test = new HistoList();
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('V');
		test.addLetter('S');
		test.addLetter('E');
		test.addLetter('A');
		test.addLetter('S');
		test.addLetter('A');
		test.addLetter('A');
		System.out.println("TEST 1 "+test);


		//A B C
		test = new HistoList();
		test.addLetter('A');
		test.addLetter('B');
		test.addLetter('C');
		System.out.println("TEST 2 "+test);


		//A B C A B C A B C A B C A B C
		test = new HistoList();
		test.addLetter('A');//
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');//
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');//
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');//
		test.addLetter('B');
		test.addLetter('C');
		test.addLetter('A');//
		test.addLetter('B');
		test.addLetter('C');
		System.out.println("TEST 3 "+test);
	}
}