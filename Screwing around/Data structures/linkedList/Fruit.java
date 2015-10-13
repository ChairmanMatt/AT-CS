package linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Fruit {

	static LinkedList<String> bowl;

	public static void main(String[] args){


		bowl = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("banana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("lime");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
//		bowl.addLast("watermelon");

		ListIterator<String> iter = bowl.listIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
			if(iter.hasNext())
				iter.next();
		}

	}

}
