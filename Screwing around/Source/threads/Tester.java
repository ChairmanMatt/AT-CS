package threads;

public class Tester {

	public static void main(String[] args){
		Hue h1 = new Hue("One");
		Hue h2 = new Hue("Two");
		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		t1.start();
		t2.start();
	}
	
}
