package threads;

public class Tester {

	public static void main(String[] args){
		Hue h1 = new Hue();
		Hue h2 = new Hue();
		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		t1.start();
		t2.start();
	}
	
}
