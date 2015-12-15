package stackmethods;

import java.util.Stack;

public class Tester {

	public static void main(String[] args){
		Stack<Integer> a = new Stack<Integer>();

		a.push(5);

		a.push(2);

		a.push(7);

		Stack<String> b = new Stack<String>(); 

		b.push("one");

		b.push("two");

		Stack<String> c = new Stack<String>();

		c.push("three");

		c.push("four");

		c.push("five");

		display(alternateStack(b,c));

		System.out.println();

		Stack<String> d = new Stack<String>();

		d.push("six"); 

		d.push("seven"); 

		d.push("eight"); 

		d.push("nine"); 

		d.push("ten"); 

		display(removeEveryOther(d));
	}

}
