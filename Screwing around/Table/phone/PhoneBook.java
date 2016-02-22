package phone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

	private Hashtable<Integer, LinkedList<PhoneEntry>> map;
	private int numSlots;

	public PhoneBook(int numSlots) throws FileNotFoundException{
		this.numSlots = numSlots;

		map = new Hashtable<Integer, LinkedList<PhoneEntry>>();

		for(int x = 0; x < numSlots; x++){
			map.put(x, new LinkedList<PhoneEntry>());
		}
		
		load();
		sort();
	}

	public PhoneBook() throws FileNotFoundException{
		this(10);
	}

	public void load() throws FileNotFoundException{
		
		File f = new File("C:/Users/CMS-1/Documents/phone.dat");
		Scanner s = new Scanner(f);
		
		while(s.hasNext()){
			add(new PhoneEntry(s.nextLine()));
		}
	}
	
	public void add(Object o){
		PhoneEntry p = (PhoneEntry) o;
		
		map.get(p.hashCode() % numSlots).add(p);
	}

	public String lookup(String name){
		for(int s : map.keySet()){	
			for(PhoneEntry p : map.get(s))
				if(p.getName().equals(name))
					return p.getNumber();
		}
		return "number not found";
	}

	public boolean changeNumber(String lookfor, String newNumb){
		for(int s : map.keySet()){	
			for(PhoneEntry p : map.get(s))
				if(p.getName().equals(lookfor)){
					p.setNumber(newNumb);
					return true;
				}
		}
		return false;
	}
	
	public int getCapacity(){
		return numSlots;
	}

	public int getSize(){
		int numEntries = 0; 

		for(int s : map.keySet()){	
			for(PhoneEntry p : map.get(s))
				numEntries++;
		}

		return numEntries;
	}

	public int getNumberOfNulls(){
		int numNull = 0;

		for(int s : map.keySet()){	
			if(map.get(s) == null)
				numNull++;
		}
		return numNull;
	}

	public int getLongestList(){
		int longest = 0;
		for(int s : map.keySet()){	
			if(map.get(s).size() > longest)
				longest = map.get(s).size();
		}
		return longest;
	}

	public void sort(){
		for(int s : map.keySet())
			Collections.sort(map.get(s));
			
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();

		for(int s : map.keySet()){
			str.append("BUCKET "+s+"\n");

			for(PhoneEntry p : map.get(s))
				str.append(p.toString() + " | ");
			str.append("\n");
		}

		return str.toString();
	}

	public void display(){
		System.out.println(toString());
	}

	public static void main(String[] args) throws FileNotFoundException{
		PhoneBook p = new PhoneBook();
		p.display();
		
		System.out.println("LOOK UP GUILLEN: ");
		System.out.println(p.lookup("Guillen"));
		
		System.out.println("GET CAPACITY: ");
		System.out.println(p.getCapacity());
		
		System.out.println("GET SIZE");
		System.out.println(p.getSize());
		
		System.out.println("GET NUMBER NULL");
		System.out.println(p.getNumberOfNulls());
		
		System.out.println("GET LONGEST LIST: ");
		System.out.println(p.getLongestList());
		
		System.out.println("CHANGE NUMBER GUILLEN TO 6095020");
		p.changeNumber("Guillen", "6095020");
		System.out.println(p.lookup("Guillen"));
	}

}
