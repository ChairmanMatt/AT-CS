package simulation;

public interface MyStack <Object> { 

	public Object push(Object item); 

	public Object pop(); 

	public Object peek();

	public boolean isEmpty();

	public int size(); 

	public int search (Object a); 

	public String toString();

}