package phone;

public class PhoneEntry implements Comparable {

	private String name;
	private String number;
	
	public PhoneEntry(String info){
		String[] parts = info.split("\t");
		
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
		return Integer.parseInt(number);
	}
	
	public String toString(){
		return name + ", " + number;
	}
	
	public int compareTo(Object o){
		PhoneEntry p = (PhoneEntry) o;

		if(! number.equals(p.getNumber())){
			return number.compareTo(p.getNumber());
		}
		
		if(! name.equals(p.getName())){
			return name.compareTo(p.getName());
		}
		
		return 0;
	}
}
