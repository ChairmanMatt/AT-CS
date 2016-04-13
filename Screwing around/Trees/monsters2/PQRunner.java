package monsters2;

public class PQRunner
{
	public static void main ( String[] args )
	{
		YourPQ test = new YourPQ();		
		test.add(new Monster(1,1,1));
		test.add(new Monster(2,2,2));
		test.add(new Monster(1,2,3));
		test.add(new Monster(3,2,1));
		test.add(new Monster(2,1,3));
		test.add(new Monster(2,3,1));
		test.add(new Monster(3,1,2));
		test.add(new Monster(3,3,3));
		

		System.out.println(test);
		
		System.out.println("getMin() - " + test.getMin());
		System.out.println(test);
		
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		
		System.out.println("getMin() - " + test.getMin());
		System.out.println(test);
		
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);

		//add more test cases


	}
}