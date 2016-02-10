package numbers;

import java.util.LinkedList;

public class HashTable{
	private LinkedList<Number>[] table;

	public HashTable( ){
		table = new LinkedList[10];
		
		for(int x = 0; x < table.length; x++)
			table[x] = new LinkedList<Number>();
	}

	public void add(Number obj){
		int i = obj.hashCode();
		if(! table[i].contains(new Number(obj.getValue())))
			table[i].add(obj);
		
	}

	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append("HASHTABLE\n");

		
		for(int x = 0; x < table.length; x++){
			output.append("bucket " + x + ":\t\t");
			for(Number n : table[x])
				output.append(n.toString() + "  |  ");
			output.append("\n");

		}
		
		return output.toString();
	}
	
}