package graph1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("C:/Users/CMS-1/Documents/graph1.dat"));
		int howManyTimes = Integer.parseInt(file.nextLine());
		
		Graph g;
		for(int x=0; x<howManyTimes; x++)
		{
			g = new Graph(file.nextLine());
			
			String s = file.nextLine();
			
			g.check(s.substring(0, 1), s.substring(1), "");
		}
	}
}