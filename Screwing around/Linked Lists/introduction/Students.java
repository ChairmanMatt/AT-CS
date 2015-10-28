package introduction;

import java.util.LinkedList;
import java.util.ListIterator;

public class Students {

	public static void main(String[] args) {
		LinkedList<String> roster = new LinkedList<String>();
		roster.addLast("Priya");
		roster.addLast("Dan");
		roster.addFirst("Jason");
		roster.addFirst("Vishal");
		roster.addLast("Teja");
		System.out.println(roster);

		roster.add("Ashay");

		System.out.println(roster);

//		System.out.println(roster.remove());
//		System.out.println(roster);

//		roster.removeFirst();
		
		roster.removeLast();

		System.out.println(roster);
		
		
		ListIterator<String> iter = roster.listIterator();
		
		iter.add("Koushik");
		System.out.println(roster);
		iter.add("Viren");
		System.out.println(roster);
		iter.add("Aditya");
		
		
		
		System.out.println(roster);
		System.out.println(iter.next());
		System.out.println(iter.previous());
		
		
		System.out.println("TESTING REMOVE");
		iter.next();
		iter.next();
		iter.previous();
		iter.next();

		iter.remove();
	}

}
