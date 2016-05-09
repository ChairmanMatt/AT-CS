package graph2;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ShortestPathGraph
{
	private Map<String, String> map;
	private List<String> solutions;

	public ShortestPathGraph(String line, String sec)
	{
		map = new TreeMap<String, String>();

		String[] r = line.split(" ");

		String temp;
		for(int x = 0; x<r.length; x++){
			temp = r[x];

			//adding second to first's connections
			String oldLinks = "";
			if(map.get(temp.substring(0,1)) != null)
				oldLinks = map.get(temp.substring(0,1));
			map.put(temp.substring(0,1), oldLinks+temp.substring(1));

			//adding first to second's connections
			oldLinks = "";
			if(map.get(temp.substring(1)) != null)
				oldLinks = map.get(temp.substring(1));
			map.put(temp.substring(1), oldLinks+temp.substring(0,1));
		}
		System.out.println(map);
		solutions = new ArrayList<String>();
		check(sec.substring(0, 1), sec.substring(1), sec.substring(0,1));

		int shortestLEN = Integer.MAX_VALUE;
		int shortestPathINDEX = -1;
		for(int x = 0; x<solutions.size(); x++)
		{
			if(solutions.get(x).length() < shortestLEN){
				shortestLEN = solutions.get(x).length();
				shortestPathINDEX = x;
			}
		}
		if(shortestPathINDEX>-1){
			System.out.println("CAN BE DONE IN " + (shortestLEN - 1) + " steps");
			System.out.println(solutions.get(shortestPathINDEX));
		}
		System.out.println();
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
			solutions.add(placesUsed);
			return true;
		}

		String connections = map.get(first);
		for(int x = 0; x<connections.length(); x++){
			check(connections.charAt(x)+"", second, placesUsed+connections.charAt(x));
		}


		return false;
	}

	public List<String> getSolutions()
	{
		return solutions;
	}
}