package simulation;

public interface MyQueue

{

	public boolean offer(Object item); //similar to push with Stacks 

	public Object poll();  //similar to pop with Stacks 

	public Object peek(); 

	public boolean isEmpty(); 

	public int size(); 

	public int search (Object a); 

	public String toString();

}