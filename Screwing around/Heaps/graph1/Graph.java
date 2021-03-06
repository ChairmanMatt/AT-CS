package graph1;

import java.util.Map;
import java.util.TreeMap;

public class Graph
{
	private TreeMap<String, String> map;
	private boolean yahOrNay;

	public Graph(String line, String sec)
	{
		map = new TreeMap<String, String>();

		String[] r = line.split(" ");

		String temp;
		for(int x = 0; x<r.length; x++){
			temp = r[x];

			String oldLinks = "";
			if(map.get(temp.substring(0,1)) != null)
				oldLinks = map.get(temp.substring(0,1));
			map.put(temp.substring(0,1), oldLinks+temp.substring(1));

			oldLinks = "";
			if(map.get(temp.substring(1)) != null)
				oldLinks = map.get(temp.substring(1));
			map.put(temp.substring(1), oldLinks+temp.substring(0,1));
		}
		System.out.println(map);

		check(sec.substring(0, 1), sec.substring(1), sec.substring(0,1));
		System.out.println("\n");
	}

	public boolean contains(String letter)
	{
		return map.containsKey(letter);
	}

	public boolean check(String first, String second, String placesUsed)
	{
		//base case
		//		if(! contains(first) && ! contains(second)){
		//			System.out.println("NOT CONTAINED");
		//			return false;
		//		}
		if(placesUsed.indexOf(first) != placesUsed.lastIndexOf(first))
			return false;

		if(first.equals(second)){
			System.out.println("ROUTE FOUND: "+placesUsed);
			return true;
		}

		String connections = map.get(first);
		for(int x = 0; x<connections.length(); x++){
			check(connections.charAt(x)+"", second, placesUsed+connections.charAt(x));
		}


		return false;
	}

	public String toString()
	{
		return "";
	}
}