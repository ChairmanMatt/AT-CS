package simulation;
public class MyQueueTester {

	public static void main(String[] args) {
		MyQueueLinkedList tc = new MyQueueLinkedList ();

		System.out.println(tc.offer("quarter"));

		System.out.println(tc.offer("dime"));

		System.out.println(tc.offer("nickel"));

		System.out.println(tc.offer("penny"));

		System.out.println( "toString() " + tc);

		System.out.println( "peek() " + tc.peek());

		System.out.println( "search for dime " + tc.search("dime"));

		System.out.println( "search for euro " + tc.search("euro"));

		System.out.println( "Size " + tc.size());

		System.out.println("poll() and isEmpty()");

		while (!tc.isEmpty())

			System.out.println(tc.poll());
	}
}