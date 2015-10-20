package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class AlgebraCalc {

	public static void main(String[] args) {
		Term s = new Term();
		s.add(new IntSet(3, 5));
		s.add(new IntSet(3, 5));
		s.add(new IntSet(3, 5));
		
		Term q = new Term();
		q.add(new IntSet(3,3));

		System.out.println(s.toString());
		
	}

}
