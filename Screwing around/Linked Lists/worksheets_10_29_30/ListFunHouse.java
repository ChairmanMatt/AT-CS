package worksheets_10_29_30;

import static java.lang.System.*;

public class ListFunHouse
{
	//this method will print the entire list on the screen
	public static void print(ListNode list)
	{
		while(list!=null){
			System.out.println(list.getValue());
			list = list.getNext();
		}

	}		
	
	//CONFIRMED WORKS
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
		int count=0;

		while(list!=null){
			count++;
			list = list.getNext();
		}

		return count;
	}

	//CONFIRMED WORKS
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		list.setNext(new ListNode(list.getValue(), list.getNext()));

	}

	//CONFIRMED WORKS
	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
		ListNode prev = new ListNode();
		
		Object value = new Object();
		
		Boolean alreadyRun = false;
		
		while(list != null){
			prev.setNext(new ListNode(list.getValue(), null));
			
			ListNode test = list.getNext();
			if(test == null && ! alreadyRun){
				alreadyRun = true;
				list.setNext(new ListNode(list.getValue(), null));
			}
			list = list.getNext();
		}

		list = prev;
	}

	//CONFIRMED WORKS
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		list.setNext(null);
	}

	//TODO
	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		ListNode prev = new ListNode();
		int count=1;

		while(list != null){
			if(count != x){
				prev.setNext(new ListNode(list.getValue(), null));
			}
			else{
				prev.setNext(new ListNode(value, null));
			}

			list = list.getNext();

			count++;
		}

		list = prev;
	}	

	//TODO
	//this method will remove the xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		ListNode prev = new ListNode();
		int count=1;

		while(list != null){
			if(p54)
			prev.setNext(list.getNext());
			
			count++;
			list = list.getNext();
		}
	}		
}