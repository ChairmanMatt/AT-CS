package monsters;

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class MonsterPQ  
{
	private Queue<Monster> pQueue;

	public MonsterPQ()
	{
		pQueue = new PriorityQueue<Monster>();
	}

	public void add(Monster obj)
	{
		pQueue.offer(obj);
	}

	public Object getMin()
	{
		return pQueue.peek();
	}

	public Object removeMin()
	{
		return pQueue.poll();
	}

	public String getNaturalOrder()
	{
		Queue<Monster> temp = new PriorityQueue<Monster>();

		String retStr = "[";

		while(pQueue.peek() != null){
			temp.offer((Monster)(pQueue.peek().clone()));
			retStr += pQueue.remove().toString();
		}
		retStr = retStr.substring(0,(retStr.length()-3))+"]";
		pQueue = temp;

		return retStr;
	}

	public String toString(){
		return pQueue.toString();
	}
}