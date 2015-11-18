package doubly;

public class DListIterator  {

	private DListNode current;
	private DListNode previous;
	private DList myList;
	private boolean canRemove; // for remove() method. true if OK to call remove()

	public DListIterator(DList list) {
		myList = list;
		current = null;
		previous = null;
		canRemove = false;
	}

	public String toString(){
		return (String) current.getValue();
	}

	public boolean hasPrevious(){
		return previous != null;
	}

	public boolean hasNext(){
		
	}

	public Object next(){
		if(current == null)
			return myList.
	}

	public Object previous(){

	}

	public void remove(){

	}

	public void add(Object element){

	}

	public void set(Object element){

	}
}
