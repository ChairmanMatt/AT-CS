package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class AlgebraCalc {

	public static void main(String[] args) {
		Polynomial s = new Polynomial();
		s.add(new Term(3, 5));
		System.out.println("s: " + s);
		
		Polynomial q = new Polynomial();
		q.add(new Term(2,5));
		System.out.println("q: " + q);
		
		Polynomial r = new Polynomial();
		r.add(new Term(4,6));
		System.out.println("r: " + r);
		
		s.add(new Term(2,5));
		System.out.println("s + q: " + s.toString());
		
		q.multiply(new Term(4, 6));
		System.out.println("q * r: " + q.toString());
		
	}

}
