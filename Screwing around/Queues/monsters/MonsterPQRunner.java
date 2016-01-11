package monsters;

public class MonsterPQRunner
{
	public static void main ( String[] args )
	{
		MonsterPQ peekoo = new MonsterPQ();
		peekoo.add(new Monster(1,1,1));
		peekoo.add(new Monster(2,2,2));
		peekoo.add(new Monster(1,2,3));
		peekoo.add(new Monster(3,2,1));
		peekoo.add(new Monster(2,1,3));
		peekoo.add(new Monster(2,3,1));
		peekoo.add(new Monster(3,1,2));
		peekoo.add(new Monster(3,3,3));

		System.out.println("MIN GET "+peekoo.getMin());
		System.out.println("MIN REV "+peekoo.removeMin());
		System.out.println("\n\n");

		System.out.println(peekoo);

		System.out.println("MIN GET "+peekoo.getMin());
		System.out.println("MIN REV "+peekoo.removeMin());
		System.out.println("\n\n");

		System.out.println(peekoo.getNaturalOrder());
		System.out.println(peekoo.toString());

	}
}