package priority;

public class PQTestRunner
{
	public static void main ( String[] args )
	{
		PQTester pq;

		pq = new PQTester();

		pq.add("67");

		pq.add("34");

		pq.add("12");

		System.out.println(pq.remove()); //outs 12

		System.out.println(pq.remove()); //outs 34

		System.out.println(pq.remove()); //outs 67

	}
}