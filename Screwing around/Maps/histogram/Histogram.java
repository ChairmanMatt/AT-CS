package histogram;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Histogram
{
	private TreeMap<String, Integer> histogram;
	//key, value


	public Histogram()
	{
		histogram = new TreeMap<String, Integer>();
	}

	public Histogram(String sent)
	{
		histogram = new TreeMap<String, Integer>();
		setSentence(sent.toLowerCase());
	}

	public void setSentence(String sent)
	{
		histogram.clear();
		String[] separated = sent.split(" ");

		for(int x = 0; x< separated.length; x++){
			
			if(histogram.containsKey(separated[x])){
				int count = histogram.get(separated[x]);
				histogram.put(separated[x], count+1);
			}
			
			else histogram.put(separated[x], 1);
			
		}

	}

	public String toString()
	{
		StringBuilder output = new StringBuilder();
		
		Set<String> keys = histogram.keySet();
		Iterator<String> iter = keys.iterator();
		
		String current;
		while(iter.hasNext()){
			current = iter.next();
			
			output.append("\n"+current + "\t");
			int count = histogram.get(current);
			
			for(int x = 1; x <= count; x++){
				output.append("* ");
			}

		}
		
		return output.toString();
	}

}