package relatives;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;

public class Relatives
{
	private Map<String,Set<String>> map;

	public Relatives() throws FileNotFoundException
	{
		map = new TreeMap<String, Set<String>>();

		File file = new File("C:/Users/16ML0369/Downloads/relatives.dat");
		Scanner read = new Scanner(file);
		
		int numLines = Integer.parseInt(read.nextLine());
		
		for(int x = 0; x<numLines; x++){
			setPersonRelative(read.nextLine());
		}
		
		System.out.println(toString());
		
		while(read.hasNext()){
			String nam = read.nextLine();
			System.out.print(nam + ": ");
			System.out.println(getRelatives(nam));
		}
	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		String firstName = personRelative[0];

		if(map.containsKey(firstName)){
			TreeSet<String> newList = (TreeSet<String>) map.get(firstName);
			
			for(int x = 1; x < personRelative.length; x++)
				newList.add(personRelative[x]);
			
			map.put(firstName, newList);
			
		}

		
		else{
			TreeSet<String> newList = new TreeSet<String>();
			for(int x = 1; x < personRelative.length; x++)
				newList.add(personRelative[x]);
			map.put(firstName, newList);
		}
		
	}


	public String getRelatives(String person)
	{
		if(map.containsKey(person)){
			Set<String> list = map.get(person);
			StringBuilder rels = new StringBuilder();
			for(String r : list)
				rels.append(r + " ");

			return rels.toString();
		}
		return "";
	}


	public String toString()
	{
		StringBuilder output = new StringBuilder();

		Set<String> people = map.keySet();

		for(String name : people){
			output.append("\n" + name + " is related to: ");
			
			output.append(getRelatives(name));
		}

		output.append("\n");
		
		return output.toString();
	}
}