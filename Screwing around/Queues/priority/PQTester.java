package priority;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PQTester extends PriorityQueue
{
	private Queue<String> pQueue;

	public PQTester()
	{
		pQueue = new PriorityQueue<String>();
		
	}

	public PQTester(String list)
	{
		this();
		
		String[] splitted = list.split(" ");
		
		for(int x = 0; x< splitted.length; x++){
			pQueue.add(splitted[x]);
		}
	}

	public void setPQ(String list)
	{
		pQueue = new PriorityQueue<String>();
		
		String[] splitted = list.split(" ");
		
		for(int x = 0; x< splitted.length; x++){
			pQueue.add(splitted[x]);
		}
		
	}
	
	public Object getMin()
	{
		return pQueue.peek();
	}
	
	public String getNaturalOrder()
	{
		PriorityQueue<String> thingy = (PriorityQueue<String>) pQueue;
		
		String output="";
		
		while(thingy.peek() != null){
			output+=thingy.remove();
		}
		
	
		return output;		
	}

	public String toString(){
		return pQueue.toString();
		
	}
}