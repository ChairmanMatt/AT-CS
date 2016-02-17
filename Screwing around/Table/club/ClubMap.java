package club;

import java.util.HashMap;
import java.util.TreeSet;

public class ClubMap {

	HashMap<String, TreeSet<Student>> map;
	
	public ClubMap(){
		map = new HashMap<String, TreeSet<Student>>();
	}
	
	public void add(Student stu, String club){
		if(! map.containsKey(club))
			map.put(club, new TreeSet<Student>());
		
		map.get(club).add(stu);
	}

	public String toString(){
		StringBuilder bob = new StringBuilder();
		
		for(String club : map.keySet()){
			bob.append(club + "\n");
			
			for(Student stu : map.get(club)){
				bob.append(stu.toString() + " | ");
			}
			
			bob.append("\n");
		}
			
			
		return bob.toString();
	}
}
