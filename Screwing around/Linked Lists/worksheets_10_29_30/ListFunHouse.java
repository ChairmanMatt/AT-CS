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

	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
		list = new ListNode(list.getValue(), list.getNext());
		
	}

	//TODO
	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
		ListNode old = list;
		
		ListNode prev=null;
		
		while(list!=null){
			prev = list.getNext();
			list = list.getNext();
		}
		//now prev is the last thing in list
		//but how to add to end of list?
	}

	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
		list = new ListNode(list.getValue(), null);
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count=1;
	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int count=1;
	}		
}