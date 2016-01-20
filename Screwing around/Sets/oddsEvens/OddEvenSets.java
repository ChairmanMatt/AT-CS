package oddsEvens;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets()
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	public OddEvenSets(String line)
	{
		String[] saliva = line.split(" ");
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
		
		
		for(int x = 0; x< saliva.length-1; x++){
			if(saliva[x].equals(""))
				continue;
			
			if(Integer.parseInt(saliva[x]) % 2 == 0){
				evens.add(Integer.parseInt(saliva[x]));
				continue;
			}
			odds.add(Integer.parseInt(saliva[x]));
			continue;
		}
		
	}

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}