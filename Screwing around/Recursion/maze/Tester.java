package maze;

public class Tester {
	public static void main(String args[])
	{
	   char[][] m = {
	      {'*', ' ', '*', '*', '*', '*', '*', '*', '*'}, 
	      {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
	      {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'}, 
	      {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'}, 
	      {'*', ' ', '*', '0', '*', '*', '*', ' ', '*'}, 
	      {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'}, 
	      {'*', '*', '*', ' ', '*', ' ', '*', ' ', '*'}, 
	      {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'}, 
	      {'*', '*', '*', '*', '*', '*', '*', '*', '*'}};
	      
	 
	   Maze maze = new Maze(m, 4, 3); //(m, xStart, yStart)
	   maze.display();
	   maze.findExit();
	   System.out.println("\n");
	   System.out.println("There is an exit at (" + maze.getXExit() + ", " + maze.getYExit() + ")");
	   System.out.println();
	   maze.getSteps();
	   
	}
	



}