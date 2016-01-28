package spanish;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class SpanishToEnglish
{
	private Map<String,String> pairs;
	//key, value

	public SpanishToEnglish()
	{
		//initialize map
		pairs = new TreeMap<String, String>();

		//read file
		File file = new File("C:/Users/16ML0369/Downloads/spantoeng.dat");
		Scanner sc;
		try {
			sc = new Scanner(file);
			
			for(int x = 0; x < 47; x++){
				putEntry(sc.nextLine());
			}

			while(sc.hasNext())
				System.out.println(translate(sc.nextLine()));
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("err file not found");
			e.printStackTrace();
		}
		
		System.out.println(pairs.toString());
	}

	private void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		
		if(list.length ==2)
			pairs.put(list[0], list[1]);

	}

	public String translate(String sent)
	{
		String[] contents = sent.split(" ");
		StringBuilder translated = new StringBuilder();

		for(String s : contents){
			if(pairs.containsKey(s)){
				translated.append(pairs.get(s) + " ");
			}
		}

		return translated.toString();
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}