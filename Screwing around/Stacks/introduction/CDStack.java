package introduction;

import java.util.Iterator;
import java.util.Stack;

public class CDStack {
	
	private Stack<String> myStack;
	
	public CDStack()
	{
		myStack = new Stack<String>();
		
		myStack.push("Journey");
		myStack.push("Iagy Pop");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreigner");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Cheap Trick");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}

	/**
	 * Returns contents of second element of myStack without removing first element
	 */
	public String nextCD()
	{
		return myStack.peek();
	}
	
	/**
	 * Returns contents of second element of myStack without removing first element
	 */
	public String playNextCD()
	{
		return myStack.pop();
	}
	
	public Stack<String> getStack(){
		return myStack;
	}
	
	public void printCD()
	{
		while(! myStack.isEmpty())
			System.out.println(myStack.pop()+"");
	}
	
	public static void main(String[] args){
		CDStack cds = new CDStack();
		cds.printCD();
	}
	
}
