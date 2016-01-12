package liver;

public class Patient implements Comparable{
	private String name;
	private int condition;
	
	public Patient(String n, int c){
		name = n; 
		condition = c;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCondition(){
		return condition;
	}
	
	public int compareTo(Object p){
		if(condition > ((Patient) p).getCondition())
			return 1;
		if(condition < ((Patient) p).getCondition())
			return -1;
		
		return 0;
	}
	
	public String toString(){
		return name;
	}
}
