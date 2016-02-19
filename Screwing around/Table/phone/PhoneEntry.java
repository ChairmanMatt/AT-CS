package phone;

public class PhoneEntry {

	private String name;
	private String number;
	
	public PhoneEntry(String info){
		String[] parts = info.split("/t");
		
		name = parts[0];
		number = parts[1];
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setNumber(String newNumber){
		number = newNumber;
	}
	
	public int hashCode(){
		return name.charAt(0);
	}
	
	public String toString(){
		return name + ", " + number;
	}
	
}
