package circularArrayQueue;

public class ArrayQueueExtendable {

	private int head; 
	private int tail; 
	private int theSize;
	private Object[] elements;

	public ArrayQueueExtendable(int capacity) {
		elements = new Object[capacity];
		theSize = 0;
		head = 0;
		tail = 1;

	} 

	public void add(Object x) {
		theSize++;
		
		//within bounds
		if(theSize < elements.length){
			elements[tail] = x;
			tail++;
			
			if(head==tail-1)
				head = tail;
			
			if(tail == elements.length){
				tail = 0;
			}
		}
		
		//not within bounds
		else{
			Object[] bigger = new Object[elements.length + 5];
			
			int bigCounter = 0;
			int elementCounter = head;
			
			if(head < tail){
				//copy existing stuff first
				while(elementCounter < elements.length && elementCounter <= tail){
					bigger[bigCounter] = elements[elementCounter];
					elementCounter++;
					bigCounter++;
				}
				head = 0;
				tail = bigCounter;
				elements = bigger;
				
				//now add
				elements[tail] = x;
				tail++;
			}
			
			else if(head > tail){
				//copy first
				//head to the end
				while(elementCounter < elements.length){
					bigger[bigCounter] = elements[elementCounter];
					elementCounter++;
					bigCounter++;
				}
				
				//index 0 to tail
				elementCounter = 0;
				while(elementCounter <= tail && elementCounter < elements.length){
					bigger[bigCounter] = elements[elementCounter];
					elementCounter++;
					bigCounter++;
				}
				
				head = 0;
				tail = bigCounter;
				elements = bigger;
				
				//now add
				elements[tail] = x;
				tail++;
			}
			
			else{
				//copy first
				//head to the end
				while(elementCounter < elements.length){
					bigger[bigCounter] = elements[elementCounter];
					elementCounter++;
					bigCounter++;
				}
				
				//index 0 to tail
				elementCounter = 0;
				while(elementCounter < tail && elementCounter < elements.length){
					bigger[bigCounter] = elements[elementCounter];
					elementCounter++;
					bigCounter++;
				}
				
				head = 0;
				tail = bigCounter;
				elements = bigger;
				
				//now add
				elements[tail] = x;
				tail++;
			}
		}
		
	} 

	public Object remove() {
		Object toRet = elements[head];

		elements[head] = null;
		head++;
		theSize--;

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