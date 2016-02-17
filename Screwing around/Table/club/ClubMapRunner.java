package club;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClubMapRunner {

	public static void main(String[] args) throws FileNotFoundException{
		ClubMap clubs = new ClubMap();
		
		File file = new File("C:/Users/CMS-1/Documents/students.dat");
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNext()){
			String[] things = scan.nextLine().split("\t");
			
			clubs.add(new Student(things[1], things[0], things[2]), things[3]);
		}
			
		System.out.println(clubs);
	}
	
}
