package monsters2;


public class Monster implements Comparable<Monster> {

	private int height;
	private int weight;
	private int age;

	public Monster(){
		height = 1;
		weight = 1;
		age = 1;
	}

	public Monster(int ht, int wt, int ag)  {
		height = ht;
		weight = wt;
		age = ag;
	}

	public void setWeight(int wt) {
		weight = wt;
	}

	public void setHeight( int ht) {
		height = ht;
	}

	public void setAge( int ag) {
		age = ag;
	}

	public Object clone() {
		return new Monster(height, weight, age);
	}

	public int getHeight() {
		return height;
	}
	
	public int getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public boolean equals(Object o) {
		if(height != ((Monster) o).getHeight())
			return false;

		if(weight != ((Monster) o).getWeight())
			return false;

		if(age != ((Monster) o).getAge())
			return false;

		return true;
	}

	public int compareTo(Monster rhs) {
		if(height != ((Monster) rhs).getHeight())
			return height-((Monster) rhs).getHeight();

		if(weight != ((Monster) rhs).getWeight())
			return weight-((Monster) rhs).getWeight();

		if(age != ((Monster) rhs).getAge())
			return age-((Monster) rhs).getAge();

		return 0;
	}



	public String toString( ) {
		return "H "+height + ", W " + weight + ", A " + age + " | ";
	}

}