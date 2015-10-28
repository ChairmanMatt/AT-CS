package introduction;

import java.util.LinkedList;
import java.util.ListIterator;


public class StudentsGoingBackwards {


	public static void main(String[] args) {
		LinkedList<String> roster = new LinkedList<String>();
		roster.addLast("Vishal");
		roster.addLast("Jason");
		roster.addLast("Priya");
		roster.addLast("Dan");
		roster.addLast("Teja");


		ListIterator<String> iter = roster.listIterator();

		while(iter.hasNext())
			iter.next();
		
		while(iter.hasPrevious())
			System.out.print(iter.previous()+" ");
	}

}
