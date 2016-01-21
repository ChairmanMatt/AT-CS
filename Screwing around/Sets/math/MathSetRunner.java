package math;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.*;

public class MathSetRunner
{
	public static void main(String args[]) throws IOException
	{
		MathSet ms = new MathSet("1 2 3 4 5", "4 5 6 7 8");
		
		System.out.println(ms.toString());
		System.out.println(ms.intersection());
		System.out.println(ms.differenceAMinusB());
		System.out.println(ms.differenceBMinusA());
		System.out.println(ms.symmetricDifference());
		
	}
}
