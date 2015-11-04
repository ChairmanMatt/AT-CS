package worksheet_3;

public class ListNode implements Linkable
{
	private Comparable listNodeValue;
	private ListNode nextListNode;
	private ListNode previousListNode;

	public ListNode()
	{
		listNodeValue = null;
		nextListNode = null;
		previousListNode = null;
	}

	public ListNode(Comparable value, ListNode next, ListNode previous)
	{
		listNodeValue=value;
		nextListNode=next;
		previousListNode = previous;
	}

	public Comparable getValue()
	{
		return listNodeValue;
	}

	public ListNode getNext()
	{
	   return nextListNode;
	}
	
	public ListNode getPrevious(){
		return previousListNode;
	}

	public void setValue(Comparable value)
	{
		listNodeValue = value;
	}

	public void setNext(Linkable next)
	{
		nextListNode = (ListNode)next;
	}
	
	public void setPrevious(Linkable prev){
		previousListNode = (ListNode) prev;
	}
	
}