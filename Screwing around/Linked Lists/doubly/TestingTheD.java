package doubly;

public class TestingTheD {

	public static void main (String[] args){
		DList thingy = new DList();
		//issue where it does not print last item in list
		thingy.addFirst("THIRD");
		thingy.addFirst("SECOND");
		thingy.addFirst("FIRST");
		thingy.addLast("THIRD");
		thingy.addLast("THIRD");
		thingy.addLast("THIRD");
		
		System.out.println(thingy.toString());
	}
	
}
