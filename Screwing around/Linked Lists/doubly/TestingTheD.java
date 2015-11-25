package doubly;

public class TestingTheD {

	public static void main (String[] args){
		
		DList thingy = new DList();
		thingy.addLast("FIFTH");
		thingy.addFirst("FOURTH");
		thingy.addFirst("THIRD");
		thingy.addFirst("SECOND");
		thingy.addFirst("FIRST");
		System.out.println("Original");
		System.out.println(thingy);
		
		System.out.println("\nadd");
		DListIterator iter = thingy.iterator();
		iter.add("BEGINNING");
		while(iter.hasNext()){
			System.out.print(iter+" ");
			iter.next();
		}
		System.out.println(iter);
		
		System.out.println("\nremove beginning");
		iter.remove();
		iter = thingy.iterator();
		System.out.println(thingy);
//		
//		System.out.println("\nOriginal");
//		System.out.println(thingy);
//		
//		System.out.println("\nAdd Last");
//		thingy.addLast("FIFTH");
//		System.out.println(thingy);
//		
//		System.out.println("\nRemove First");
//		thingy.removeFirst();
//		System.out.println(thingy);
//		
//		System.out.println("\nRemove Last");
//		thingy.removeLast();
//		System.out.println(thingy);
//		
//		System.out.println("\nSize");
//		System.out.println(thingy.size());
		
	}
	
}
