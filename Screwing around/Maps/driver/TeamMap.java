package driver;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TeamMap {

	Map<Integer, LinkedList<Wrestler>> m;

	public TeamMap(){
		m = new TreeMap<Integer, LinkedList<Wrestler>>();

		for(int x = 0; x <= 10; x++)
			m.put(x, new LinkedList<Wrestler>());

	}

	public int get(Wrestler w){
		for(int i : m.keySet()){
			if(m.get(i).contains(w))
				return i;
		}
		return -1;
	}

	public void add(Wrestler w){
		int hash = (w.getWeight() / 10) % 10;

		m.get(hash).add(w);
	}

	public void remove(Wrestler w){
		Set<Integer> vals = m.keySet();
		for(int i : vals){
			if(m.get(i).contains(w))
				m.get(i).remove(w);
		}

	}

	public void changeWeightGroup(Wrestler w, int i) {
		remove(w);

		m.get(i).add(w);

	}

	public String toString(){
		StringBuilder contents = new StringBuilder();

		for(int i: m.keySet()){
			if(! m.get(i).isEmpty()){
				contents.append("GROUP "+i+"\n");
				
				for(Wrestler w : m.get(i))
					contents.append(w.toString() + " | ");

				contents.append("\n\n");
			}
		}

		return contents.toString();
	}

}
