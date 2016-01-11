package liver;

public class PatientHolder {

	Patient p;
	int order;
	
	public PatientHolder(Patient pat, int number){
		p = pat;
		order = number;
	}
	
	public Patient getPatient(){
		return p;
	}
	
	public int getOrder(){
		return order;
	}
	
	public int compareTo(PatientHolder n){
		if(p.compareTo(n.getPatient()) == 0){
			if(order < n.getOrder())
				return -1;
			if(order > n.getOrder())
				return 1;
			
			return 0;
		}
		
		return p.compareTo(n.getPatient());
	}
}
