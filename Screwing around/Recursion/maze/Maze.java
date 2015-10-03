package maze;

import java.util.ArrayList;

public class Maze {
	private int xExit, yExit,xpos,ypos;
	private char[][] maze;
	private ArrayList<String> steps = new ArrayList<String>();
	
	public Maze(char[][] maze, int xpos,int ypos){
		this.maze=maze;
		this.xpos=xpos;
		this.ypos=ypos;
	}
	
	public void display(){
		for(char[] i:maze){
			System.out.println();
			for(char c:i)
				System.out.print(c+" ");
		}
	}

	public boolean findExit() {
		return findExit(xpos,ypos);
	}
	
	private boolean findExit(int xpos,int ypos){
		if(xpos == 0 || ypos == 0 || xpos == maze.length-1 || ypos == maze[0].length-1)
		{
			xExit=xpos;
			yExit=ypos;
			return true;
		}
			
		if(maze[xpos][ypos+1]==' ')
		{
			maze[xpos][ypos+1]='0';
			System.out.println("\n");
			display();
			steps.add("("+xpos+","+(ypos+1)+")");
			findExit(xpos,ypos+1);
		}
		if(maze[xpos+1][ypos]==' ')
		{
			maze[xpos+1][ypos] = '0';
			System.out.println("\n");
			display();
			steps.add("("+(xpos+1)+","+ypos+")");
			findExit(xpos+1,ypos);
		}
		if(maze[xpos][ypos-1]==' ')
		{
			maze[xpos][ypos-1] = '0';
			System.out.println("\n");
			display();
			steps.add("("+(xpos)+","+(ypos-1)+")");
			findExit(xpos,ypos-1);
		}
		if(maze[xpos-1][ypos]==' ')
		{
			maze[xpos-1][ypos] = '0';
			System.out.println("\n");
			display();
			steps.add("("+(xpos-1)+","+(ypos)+")");
			findExit(xpos-1,ypos);
		}
		
		return false;

	}

	public int getXExit() {
		return xExit;
	}

	public int getYExit() {
		return yExit;
	}

	public void getSteps() {
		for(String i:steps)
			System.out.println(i);
	}

}