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
		
		System.out.print("INTERSECTION: ");
		System.out.println(ms.intersection());
		
		System.out.print("A but not B: ");
		System.out.println(ms.differenceAMinusB());
		
		System.out.print("B but not A: ");
		System.out.println(ms.differenceBMinusA());
		
		System.out.print("Symmetric Difference: ");
		System.out.println(ms.symmetricDifference());
		
		System.out.println();
		ms = new MathSet("10 11 12 13 14 15 16 17", "11 13 15 17 19 21 23");
		
		System.out.println(ms.toString());
		
		System.out.print("INTERSECTION: ");
		System.out.println(ms.intersection());
		
		System.out.print("A but not B: ");
		System.out.println(ms.differenceAMinusB());
		
		System.out.print("B but not A: ");
		System.out.println(ms.differenceBMinusA());
		
		System.out.print("Symmetric Difference: ");
		System.out.println(ms.symmetricDifference());
		
	}
}
