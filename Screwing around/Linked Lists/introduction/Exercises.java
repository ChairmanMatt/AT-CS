package introduction;

import java.util.LinkedList;
import java.util.ListIterator;

public class Exercises {

	public static void main(String[] args){
		LinkedList<String> staff = new LinkedList<String>();
		staff.addLast("a");
		staff.addLast("b");
		staff.addLast("c");
		staff.addLast("e");

		//		reverse(staff);
		//		duplicate(staff);
		//		repeat(staff);
		//		delete(staff, "a");
		//		insert(staff, "be");
	}

	public static void reverse(LinkedList<String> staff){
		LinkedList<String> thing = new LinkedList<String>();
		ListIterator<String> iter = staff.listIterator();
		while(iter.hasNext()){
			thing.addFirst(iter.next());
		}
		System.out.println(thing);
	}

	public static void duplicate(LinkedList<String> staff){
		LinkedList<String> thing = new LinkedList<String>();
		ListIterator<String> iter = staff.listIterator();

		while(iter.hasNext()){
			String s = iter.next();
			for(int x = 1; x<=2; x++){
				thing.addLast(s);
			}
		}

		System.out.println(thing);
	}

	public static void repeat(LinkedList<String> staff){
		LinkedList<String> thing = new LinkedList<String>();
		ListIterator<String> iter;

		for(int x = 1; x<=2; x++){
			iter = staff.listIterator();
			while(iter.hasNext()){
				thing.addLast(iter.next());
			}
		}

		System.out.println(thing);
	}

	public static void delete(LinkedList<String> staff, String searchFor){
		ListIterator<String> iter = staff.listIterator();

		while(iter.hasNext()){
			if(iter.next().equals(searchFor))
				iter.remove();
		}

		System.out.println(staff);
	}

	public static void insert(LinkedList<String> staff, String toAdd){
		ListIterator<String> iter = staff.listIterator();
		boolean wasAdded = false;

		while(iter.hasNext()){
			if(iter.next().compareTo(toAdd) >= 0){
				iter.previous();
				iter.add(toAdd);
				wasAdded = true;
				break;
			}
		}

		if(! wasAdded)
			iter.add(toAdd);

		System.out.println(staff);

	}

}
