package monsters2;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class PQRunner
{
	public static void main ( String[] args )
	{
		YourPQ test = new YourPQ();

		Scanner keyboard = new Scanner(System.in);

		//loop to read in values and instantiate your Objects
		System.out.println("ENTER IN NUMBER OF MONSTERS");
		int x = Integer.parseInt(keyboard.nextLine());
		for(int a = x; a>0; a--){
			System.out.println("ENTER IN WEIGHT");
		}


		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		
		//add more test cases
		
			
	}
}