package circularArrayQueue;

public class ArrayQueue { 

	private int head; 
	private int tail; 
	private int theSize;
	private Object[] elements;

	public ArrayQueue(int capacity) {
		elements = new Object[capacity];
		theSize = 0;
		head = 0;
		tail = 1;

	} 

	public void add(Object x) {
//		if(head == tail){
//			System.out.println("CAN'T OVERWRITE");
//			return;
//		}
		elements[tail] = x;
		tail++;
		theSize++;
		
		if(head==tail-1)
			head = tail;
		
		if(tail == elements.length){
			tail = 0;
		}
		
		
	} 

	public Object remove() {
		System.out.println("HEAD: "+head);
		System.out.println("TAIL: "+tail);
		
		Object toRet = elements[head];

		elements[head] = null;
		head++;
		theSize--;

		if(head == elements.length){
			head = 0;
		}
		
		return toRet;
	} 

	public int size() {
		return theSize;

	} 

	public String toString(){
		String toRet = "";

		for(Object a: elements){
			if(a != null)
				toRet += a.toString() + " ";
		}
		return toRet;
	}

}