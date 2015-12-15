package simulation;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyQueueLinkedList implements MyQueue {

	LinkedList<Object> thingy;
	ListIterator<Object> iter;
	
	public MyQueueLinkedList(){
		thingy = new LinkedList<Object>();
		iter = thingy.listIterator();
	}
	
	public boolean offer(Object item) {
		thingy.addLast(item);
		
		return true;
	}

	public Object poll() {
		Object originalFirst = thingy.getFirst();
		thingy.removeFirst();
		
		return originalFirst;
	}

	public Object peek() {
		return thingy.getFirst();
	}

	public boolean isEmpty() {
		return thingy.size() == 0;
	}

	public int size() {
		return thingy.size();
	}

	public int search(Object a) {
		iter = thingy.listIterator();
		int counter = 0;
		
		while(iter.hasNext() && counter < thingy.size()){
			if(iter.next().equals(a)){
				return counter;
			}
			counter++;
		}
		return -1;
	}

	public String toString(){
		iter = thingy.listIterator();
		String retString = "";
		int counter = 0;
		
		while(iter.hasNext() && counter < thingy.size()){
			retString+=iter.next()+" ";
			counter++;
		}
		return retString;
	}
	
}
