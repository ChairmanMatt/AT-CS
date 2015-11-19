package doubly;

public class DList {

	private DListNode firstNode;
	private DListNode lastNode;

	/**
	 * Construct an empty list
	 */
	public DList() {
		firstNode = null;
		lastNode = null;
	}

	/**
	 * Returns true if the list contains no elements
	 */
	public boolean isEmpty(){
		return (firstNode == null && lastNode == null);
	}

	/**
	 * Inserts the argument as the first element of this list.
	 */
	public void addFirst(Object o) {	
		if(isEmpty()){
			firstNode = new DListNode(o, lastNode, null);
			return;
		}
		
		DListNode toAdd = new DListNode(o, firstNode, null);
		
		if(lastNode == null)
			lastNode = firstNode;
		
		firstNode = toAdd;
		
	}
	
	/**
	 * Inserts the argument as the last element of this list.
	 */
	public void addLast(Object o) {
		if(isEmpty()){
			addFirst(o);
			return;
		}
		
		if(firstNode == null)
			firstNode = lastNode;
		
		DListNode toAdd = new DListNode(o, null, lastNode);
		lastNode = toAdd;
	}

	/**
	 * Removes and returns the first element of this list.
	 */
	public Object removeFirst(){
		Object toReturn = firstNode.getValue();
		firstNode = firstNode.getNext();
		firstNode.setPrevious(null);
		return toReturn;
	}

	/**
	 * Removes and returns the last element of this list.
	 */
	public Object removeLast(){
		Object toReturn = lastNode.getValue();
		lastNode = lastNode.getPrevious();
		lastNode.setNext(null);
		return toReturn;
	}

	/**
	 * Returns a String representation of the list.
	 */
	public String toString(){
		DListNode temp = firstNode;
		String toRet = "";
		
		while(temp.getNext() != null){
			toRet += (String) temp.getValue()+" ";
			
			temp = temp.getNext();
		}
		
		return toRet;
	}

	/**
	 * Returns the number of elements in the list as an int.
	 */
	public int size() {
		DListNode temp = firstNode;
		int counter = 0;
		
		while(temp.getNext() != null){
			counter++;
			temp = temp.getNext();
		}
		
		return counter;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	private void clear() {
		firstNode = null;
		lastNode = null;
	}
	
	/**
	 * Returns a DListIterator.
	 */
	public DListIterator iterator() {
		return new DListIterator(this);

	}

	public DListNode getFirst(){
		return firstNode;
	}
	
	public DListNode getLast(){
		return lastNode;
	}


}
