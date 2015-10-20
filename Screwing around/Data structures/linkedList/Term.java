package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Term {

	LinkedList<IntSet> expression; 
	ListIterator<IntSet> cursor;

	public Term(){
		expression = new LinkedList<IntSet>();
		cursor = expression.listIterator();
	}

	public int sameExponent(int y){
		
	}
	
	
	public void add(IntSet thing){
		cursor = expression.listIterator();
		while(cursor.hasNext()){
			if(cursor.next().getY() == y)
		}
		
		
		
		if(thing.getY())
		expression.addLast(thing);
	}

	public void add(Term thing){
		thing.toString();



	}

	public String toString(){
		cursor = expression.listIterator();
		IntSet thing = cursor.next();
		String retString = thing.toString();
		
		while(cursor.hasNext()){
			thing = cursor.next();
			retString += " + "+thing.toString();
		}
		
		return retString;
	}

}
