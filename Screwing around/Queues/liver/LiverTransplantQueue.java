package liver;

import java.util.ArrayList;


public class LiverTransplantQueue implements PriorityQueue{

	ArrayList<Patient> thingy = new ArrayList<Patient>();
	int timeAdded = 0;

	public void add(Object o){
		Patient p = (Patient) o;
		
		thingy.add(p);
	}

	public Object peek(){
		Patient min = thingy.get(0);

		for(int x = 1; x<thingy.size(); x++){
			if()
		}
		
	}

	public Object poll(){
		return thingy.remove(0);
	}

	public int size(){
		return thingy.size();
	}

	public boolean isEmpty() {
		return thingy.size() == 0;
	}

}
