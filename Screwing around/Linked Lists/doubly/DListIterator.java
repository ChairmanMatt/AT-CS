package doubly;

public class DListIterator  {

	private DListNode next;
	private DListNode previous;
	private DList myList;
	private boolean forward;
	private boolean canRemove; // for remove() method. true if OK to call remove()

	public DListIterator(DList list) {
		myList = list;
		next = list.getFirst();
		previous = null;
		if(list.isEmpty() || previous == null || next == null)
			canRemove = false;
		else
			canRemove = true;
	}
	
	public void canRemove(){
		if(myList.isEmpty() || previous == null || next == null)
			canRemove = false;
		else
			canRemove = true;
	}

	public String toString(){
		return (String) next.getValue();
	}

	public boolean hasPrevious(){
		return !(next.getPrevious() == null);
	}

	public boolean hasNext(){
		return !(next.getNext() == null);
	}

	public Object next(){
		forward=true;
		if(next == null){
			return null;
		}
			
		else { 
			Object temp = next.getValue();
			previous = next;
			next = next.getNext();
			return temp;
		}
	}

	public Object previous(){
		forward=false;
		if(previous == null)
			return null;
		
		else { 
			Object temp = previous.getValue();
			next = previous;
			previous = previous.getPrevious();
			canRemove();
			return temp;
		}
	}

	public void remove(){
		if(!canRemove)
			return;
		canRemove();
		if(forward)
			previous=previous.getPrevious();
		else
			next=next.getNext();
	}

	public void add(Object element){
		DListNode temp = new DListNode(element, next, previous);
		next.setPrevious(temp);
		previous.setNext(temp);
		previous = previous.getNext();
	}

	public void set(Object element){
		next.setValue(element);
	}
}
