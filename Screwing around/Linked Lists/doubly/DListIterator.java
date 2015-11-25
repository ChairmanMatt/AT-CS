package doubly;

public class DListIterator  {

	private DListNode next;
	private DListNode previous;
	private DList myList;
	private boolean canRemove; // for remove() method. true if OK to call remove()

	public DListIterator(DList list) {
		myList = list;
		next = list.getFirst();
		previous = null;

		canRemove = true;
		if(list.isEmpty() || previous == null)
			canRemove = false;
	}

	public void canRemove(){
		canRemove = true;
		if(myList.isEmpty() || previous == null)
			canRemove = false;
	}

	public String toString(){
		return (String) previous.getValue();
	}

	public boolean hasPrevious(){
		return !(next.getPrevious() == null);
	}

	public boolean hasNext(){
		return !(next == null);
	}

	public Object next(){
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
		if(previous != null){
			previous = previous.getPrevious();

			if(previous == null)
				return;

			previous.setNext(next);
			next.setPrevious(previous.getPrevious());
		}
	}

	public void add(Object element){
		DListNode temp = new DListNode(element, next, previous);
		next.setPrevious(temp);
		if(previous==null){
			previous = temp;
			return;
		}
		previous.setNext(temp);
		previous = previous.getNext();

	}

	public void set(Object element){
		next.setValue(element);
	}
}
