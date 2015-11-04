package worksheet_1;

import java.util.LinkedList;
import java.util.ListIterator;

public class JavaLinkedList
{
	private LinkedList<Integer> list;
	private ListIterator<Integer> iter;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
		iter = list.listIterator();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}

		iter = list.listIterator();
	}

	public double getSum()
	{
		iter = list.listIterator();
		double total=0;

		while(iter.hasNext()){
			total += iter.next();
		}

		return total;
	}

	public double getAvg()
	{
		iter = list.listIterator();

		double total=0;


		int runCounter = 0;
		while(iter.hasNext()){
			total += iter.next();
			runCounter++;
		}

		return (total/runCounter);
	}

	public int getLargest()
	{
		iter = list.listIterator();
		
		int largest = Integer.MIN_VALUE;
		int toCompare;

		while(iter.hasNext()){
			toCompare = iter.next();

			if(toCompare > largest)
				largest = toCompare;
		}

		return largest;
	}

	public int getSmallest()
	{
		iter = list.listIterator();
		
		int smallest = Integer.MAX_VALUE;
		int toCompare;

		while(iter.hasNext()){
			toCompare = iter.next();

			if(toCompare < smallest){
				smallest = toCompare;
			}
		}

		return smallest;
	}

	public String toString()
	{
		String output="";
		output+="SUM: "+getSum()+"\n";
		output+="AVG: "+getAvg()+"\n";
		output+="MIN: "+getSmallest()+"\n";
		output+="MAX: "+getLargest()+"\n";
		
		
		return output;
	}
}