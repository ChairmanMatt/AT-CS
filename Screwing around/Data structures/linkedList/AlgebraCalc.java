package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class AlgebraCalc {

	public static void main(String[] args) {
		Polynomial s = new Polynomial();
		s.add(new Term(3, 5));
		System.out.println("s: " + s);
		
		Polynomial q = new Polynomial();
		q.add(new Term(2, 2));
		q.add(new Term(1, 1));
		System.out.println("q: " + q);
		
		s.multiply(q);
		
		System.out.println(s.toString());
	}

}
