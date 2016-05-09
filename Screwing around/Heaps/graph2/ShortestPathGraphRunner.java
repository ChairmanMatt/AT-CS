package graph2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ShortestPathGraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		Scanner file = new Scanner(new File("C:/Users/CMS-1/Documents/graph1.dat"));
		int howManyTimes = Integer.parseInt(file.nextLine());

		ShortestPathGraph g;
		for(int x=0; x<howManyTimes; x++)
		{
			String line = file.nextLine();
			String rte = file.nextLine();

			g = new ShortestPathGraph(line, rte);
		}

	}
}