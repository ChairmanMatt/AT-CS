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

	public void sort(){
		cursor = expression.listIterator();
		
		while(cursor.hasNext()){
			
		}
	}
	
	public void add(IntSet thing){
		expression.sort();
		cursor = expression.listIterator();
		while(cursor.hasNext()){
			//if something with same exponent already exists, just add coefficient
			IntSet existing = cursor.next();
			if(existing.getY() == thing.getY()){
				cursor.previous().setX(existing.getX()+thing.getX());
				return;
			}
			
			//if past that exponent value, backtrack and add before. (assumes in order of highest to lowest exponents from left to right)
			if(existing.getY() < thing.getY()){
				cursor.previous();
				cursor.add(thing);
				return;
			}
		}
	}

	public void add(Term thing){
		thing.sort();
		cursor = thing.getList().listIterator();
		while(cursor.hasNext()){
			expression.add(cursor.next());
		}
	}

	public LinkedList<IntSet> getList(){
		return expression;
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
