package numbers;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class HashTableRunner
{
  public static void main ( String[] args )
  {
		try{
			HashTable ht = new HashTable();
			
			File file = new File("C:/Users/16ML0369/Downloads/numbers.dat");
			
			Scanner scan = new Scanner(file);
			
			scan.nextLine();
			
			while(scan.hasNext()){
				int num = Integer.parseInt (scan.nextLine().trim());
				ht.add(new Number(num));
			}
			
			System.out.println(ht.toString());
			
			scan.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
  }
}