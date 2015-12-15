package simulation;

import java.util.ArrayList;

public class MyStackUsingArrayList<Object> implements MyStack<Object> {

	/**
	 * Simulating stacks using ArrayList. 
	 */
	
	private ArrayList<Object> contents;
	
	public MyStackUsingArrayList(){
		contents = new ArrayList<Object>();
	}
	
	public Object push(Object item) {
		contents.add(0,item);
		
		return item;
	}

	public Object pop() {
		return contents.remove(0);
	}

	public Object peek() {
		return contents.get(0);
	}

	public boolean isEmpty() {
		return contents.size() == 0;
	}

	public int size() {
		return contents.size();
	}

	public int search(Object a) {
		for(int x = 0; x < contents.size(); x++){
			if(contents.get(x).equals((String) a))
				return x;
		}
		
		return -1;
	}

	
	
	public String toString(){
		String toReturn = "";
		
		for(int x = 0; x<contents.size(); x++){
			toReturn += (String) contents.get(x) + " ";
		}
		
		return toReturn;
	}
	
}
