package worksheet_2;

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
		int count=1;

		while(list != null){
			if(count != x){
				list = list.getNext();
			}
			else{
				list.setValue(value);
				list = list.getNext();
			}
			count++;
		}
	}	

	//TODO
	//this method will remove the xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
		int counter = 1;
		ListNode temp = list;
		ListNode prev = null;

		while(temp.getNext() != null){
			if(counter%x == 0){
				prev.setNext(temp.getNext());
			}
			
			prev = temp;
			temp = temp.getNext();
			counter++;
		}
		
		temp = null;
	}		
}