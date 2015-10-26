package linkedList;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {

	LinkedList<Term> expression; 
	ListIterator<Term> cursor;

	public Polynomial(){
		expression = new LinkedList<Term>();
		cursor = expression.listIterator();
	}

	public void sort(){
		cursor = expression.listIterator();

		Term prev=cursor.next();
		Term next;
		while(cursor.hasNext()){
			if(cursor.next().getY() > prev.getY()){
				next=cursor.previous();
				cursor.remove();
				cursor.previous();
				cursor.add(next);
				sort();
			}
			continue;
		}
	}

	public void add(Term thing){
		if(expression.size() >= 1)
			sort();


		boolean inserted = false;
		cursor = expression.listIterator();
		Term existing;
		while(cursor.hasNext()){
			existing = cursor.next();
			//if something with same exponent already exists, just add coefficient
			if(existing.getY() == thing.getY()){
				existing.setX(existing.getX()+thing.getX());
				cursor.remove();
				cursor.add(existing);
				inserted = true;
				return;
			}

			//if past that exponent value, backtrack and add before. (assumes in order of highest to lowest exponents from left to right)
			if(existing.getY() < thing.getY()){
				cursor.previous();
				cursor.add(thing);
				inserted = true;
				return;
			}
		}
		if(!inserted)
			cursor.add(thing);
	}

	public void add(Polynomial thing){
		cursor = thing.getList().listIterator();
		while(cursor.hasNext()){
			expression.add(cursor.next());
		}
		sort();
	}

	public void multiply(Term thing){
		cursor = expression.listIterator();
		Term current;
		while(cursor.hasNext()){
			current = cursor.next();
			current.setX(current.getX() * thing.getX());
			current.setY(current.getY() + thing.getY());
			cursor.previous();
			cursor.remove();
			cursor.add(current);
		}
	}

	public LinkedList<Term> multiplyTerm(Term thing, LinkedList<Term> newThing){
		ListIterator<Term> newC = newThing.listIterator();
		Term current;
		while(newC.hasNext()){
			current = newC.next();
			current.setX(current.getX() * thing.getX());
			current.setY(current.getY() + thing.getY());
			newC.previous();
			newC.remove();
			newC.add(current);
		}
		return newThing;
	}

	public void multiply(Polynomial p){
		cursor = expression.listIterator();

		LinkedList<Term> expCopy = new LinkedList<Term>();

		while(cursor.hasNext()){
			expCopy.addLast(cursor.next());
		}

		LinkedList<Term> toAdd = new LinkedList<Term>();
		ListIterator<Term> pIter = p.getList().listIterator();

		while(pIter.hasNext()){
			LinkedList<Term> hue = multiplyTerm(pIter.next(), expCopy);
			ListIterator<Term> hueIter = hue.listIterator();
			while(hueIter.hasNext())
				toAdd.addLast(hueIter.next());

			expCopy = new LinkedList<Term>();
			cursor=expression.listIterator();
			while(cursor.hasNext()){
				expCopy.addLast(cursor.next());
			}
		}

		expression = toAdd;
		sort();

	}


	public LinkedList<Term> derivative(){
		LinkedList<Term> ret = new LinkedList<Term>();

		cursor = expression.listIterator();
		Term current;
		while(cursor.hasNext()){
			current = cursor.next();
			if(current.getY() != 0){
				ret.add(new Term(current.getY()*current.getX(), current.getY()-1));
			}

		}
		return ret;
	}

	public LinkedList<Term> getList(){
		return expression;
	}

	public String toString(){
		cursor = expression.listIterator();
		Term thing = cursor.next();
		String retString = thing.toString();

		while(cursor.hasNext()){
			thing = cursor.next();
			retString += " + "+thing.toString();
		}

		return retString;
	}

}
