package acronym;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Acronyms
{
	private Map<String,String> acronymTable;
	private String converted = "";
	
	
	public Acronyms() throws FileNotFoundException
	{
		File file = new File("C:/Users/16ML0369/Downloads/acro.dat");
		Scanner scan = new Scanner(file);
		
		acronymTable = new TreeMap<String, String>();
		
		int x = Integer.parseInt(scan.nextLine());
		
		for(int count = 0; count < x; count++){
			putEntry(scan.nextLine());
		}

		System.out.println(acronymTable.toString());
		
		while(scan.hasNext())
			converted += convert(scan.nextLine());
		
	}

	public void putEntry(String entry)
	{
		String[] split = entry.split(" - ");
		//key, value
		
		converted+=entry+"\n";
		
		acronymTable.put(split[0], split[1]);
	}

	public String convert(String sent)
	{
		String[] split = sent.replaceAll("\\.", " . ").split(" ");
		StringBuilder output = new StringBuilder();
		
		for(int x = 0; x < split.length; x++){
			if(acronymTable.containsKey(split[x])){
				output.append(acronymTable.get(split[x]) + " ");
			}
			else output.append(split[x] + " ");
		}
		output.append("\n");

		return output.toString();
	}

	public String toString()
	{
		return converted;
	}
}