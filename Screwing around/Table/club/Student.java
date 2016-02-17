package club;

public class Student implements Comparable {

	private String firstName;
	private String lastName;
	private String idNum;

	public Student(String first, String last, String id){
		firstName = first;
		lastName = last;
		idNum = id;	
	}

	public String getFirst(){
		return firstName;
	}

	public String getLast(){
		return lastName;
	}

	public String getID(){
		return idNum;
	}

	public int compareTo(Object arg0) {
		Student stu = (Student) arg0;

		if(getLast().compareTo(stu.getLast()) != 0){
			if(getLast().compareTo(stu.getLast()) < 0)
				return -1;
			if(getLast().compareTo(stu.getLast()) > 0)
				return 1;
		}
		
		if(getFirst().compareTo(stu.getFirst()) != 0){
			if(getFirst().compareTo(stu.getFirst()) < 0)
				return -1;
			if(getFirst().compareTo(stu.getFirst()) > 0)
				return 1;
		}

		if(getID().compareTo(stu.getID()) != 0){
			if(getID().compareTo(stu.getID()) < 0)
				return -1;
			if(getID().compareTo(stu.getID()) > 0)
				return 1;
		}
		
		return 0;
	}

	public String toString(){
		return getLast() + ", " + getFirst() + " " + getID();
		
	}
	
}
