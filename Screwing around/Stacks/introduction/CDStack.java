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

	public void printCDs2()
	{
		Iterator<String> i = myStack.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}

	public void printCDs3()
	{
		for(String s:myStack)
			System.out.println(s);
	}

	public void printCDRecursive()
	{
		if(myStack.isEmpty())
			return;
		System.out.println(myStack.pop());
		printCDRecursive();
	}

	public Stack<String> reverseStack(Stack<String> stack){
		Stack<String> temp = new Stack<String>();
		while(!stack.isEmpty()){
			temp.push((String) stack.pop());
		}

		return temp;
	}

	public void addOnTop(Stack<String> stack){
		stack = reverseStack(stack);
		while(!stack.isEmpty()){
			myStack.push((String) stack.pop());
		}
	}

	public void binaryThing(int num, boolean wasModded){
		if(num <= 1)
			return;
		
		if(wasModded = false){
			myStack.push((num % 2)+" ");
			num = num % 2;
			binaryThing(num, true);
		}
		else{
			num = num / 2;
			binaryThing(num, false);
		}
		
	}
	
	public static void main(String[] args){
		CDStack cds = new CDStack();
		cds.binaryThing(34, false);
		cds.printCD();
	}

}
