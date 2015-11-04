package worksheet_3;

import worksheet_3.ListNode;


public class ListFunHouseTwo
{
	private ListNode theList;

	public ListFunHouseTwo()
	{

	}

	public void add(Comparable data)
	{

	}

	//this method will return the number of nodes present in theList
	public int nodeCount()
	{
		Comparable value = theList.getValue();
		ListNode next = theList.getNext();
		ListNode prev = theList.getPrevious();

		int count=0;

		if(next!=null){
			count+=1;
			theList = theList.getNext();
		}

		while(!(theList.getValue().equals(value)) 
				&& !(theList.getNext().equals(next)) 
				&& !(theList.getPrevious().equals(prev))){
			count++;
			theList = theList.getNext();
		}

		return count;
	}

	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the theList.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		theList.setNext(new ListNode(theList.getValue(), theList.getNext(), theList));
		theList = theList.getNext();

	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		Comparable value = theList.getValue();
		ListNode next = theList.getNext();
		ListNode prev = theList.getPrevious();
		
		theList = theList.getPrevious();
		
		ListNode newlyAdded = new ListNode(value, next, theList);
		
		
		theList.setNext(newlyAdded);
		theList = theList.getNext();
		theList = theList.getNext();
		theList.setPrevious(newlyAdded);

	}

	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{



	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{




	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{



	}		
	//this method will return a String containing the entire list
	public String toString()
	{
		Comparable value = theList.getValue();
		ListNode next = theList.getNext();
		ListNode prev = theList.getPrevious();
		
		String output="";

		if(next!=null){
			output+=(String)theList.getValue();
			theList = theList.getNext();
		}
		
		while(!(theList.getValue().equals(value)) 
				&& !(theList.getNext().equals(next)) 
				&& !(theList.getPrevious().equals(prev))){
			
			output+=(String)theList.getValue();
			theList = theList.getNext();
		}

		return output;
	}			

}