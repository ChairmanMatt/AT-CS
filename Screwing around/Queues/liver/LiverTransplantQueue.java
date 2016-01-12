package liver;

import java.util.ArrayList;


public class LiverTransplantQueue implements PriorityQueue{

	ArrayList<PatientHolder> thingy = new ArrayList<PatientHolder>();
	int timeAdded = 0;

	public void add(Object o){
		Patient p = (Patient) o;
		
		thingy.add(new PatientHolder(p, timeAdded));
		timeAdded++;
	}

	public Object peek(){
		PatientHolder ph = thingy.get(0);

		for(int x = 0; x<thingy.size(); x++){
			if(thingy.get(x).compareTo(ph) < 0)
				ph = thingy.get(x);
		}
		
		return ph.getPatient();
	}

	public Object poll(){
		PatientHolder ph = thingy.get(0);
		int leastIndex = 0;
		
		for(int x = 0; x<thingy.size(); x++){
			if(thingy.get(x).compareTo(ph) < 0){
				ph = thingy.get(x);
				leastIndex = x;
			}
		}
		
		return thingy.remove(leastIndex).getPatient();
	}

	public int size(){
		return thingy.size();
	}

	public boolean isEmpty() {
		return thingy.size() == 0;
	}

	public String toString(){
		String toRet = "";
		
		Patient pat = (Patient) poll();
		
		toRet = pat.toString()+" ";
		
		for(int x = 0; x<thingy.size(); x++){
			toRet+=thingy.get(x).getPatient().toString()+" ";
		}
		
		add(pat);
		
		return toRet;
	}
	
}
