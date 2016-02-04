package autoparts;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;

public class PartList
{
	private Map<Part, Integer> partsMap;

	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();

	}

	public PartList(String fileName)
	{
		this();
		try
		{
			Scanner scan = new Scanner(new File("C:/Users/16ML0369/Downloads/"+fileName));

			while(scan.hasNext()){
				String info = scan.nextLine();

				String[] split = info.split(" ");

				String make, model, rest;
				int year;
				
				if(split.length == 6){
					make = split[3];
					model = split[4];
					year = Integer.parseInt(split[5]);
					rest = split[0] + " " + split[1] + " " + split[2];
				}
				else{
					make = split[2];
					model = split[3];
					year = Integer.parseInt(split[4]);
					rest = split[0] + " " + split[1];
				}
				
				Part soFar = new Part(make+ " " + model+ " " + year+ " " + rest);

				if(! partsMap.containsKey(soFar)){					
					partsMap.put(soFar, 1);
				}
				else{
					int quantity = partsMap.get(soFar);
					partsMap.put(soFar, quantity+1);
				}
			}

			scan.close();
		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			System.out.println(e);
		}

	}

	public String toString()
	{
		StringBuilder output = new StringBuilder();

		Set<Part> keys = partsMap.keySet();

		for(Part s : keys){
			output.append(s.toString() + " - ");
			output.append(partsMap.get(s) + "");
			output.append("\n");
		}

		return output.toString();
	}
}