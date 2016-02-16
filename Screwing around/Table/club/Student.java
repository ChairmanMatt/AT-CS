package club;

public class Student {

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
	
}
