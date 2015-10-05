package eightQueens;

public class Queen {

	/*
	 * trigger warning
	 * shit code
	 */
	public static void main(String[] args) {
		int[][] board = new int[8][8];

		placeQueen(0,0,board);

		printMatrix(board);

	}

	public static void printMatrix(int[][] board){
		for (int[] row : board)
		{
			for (int cell : row)
			{
				System.out.print(cell);
			}
			System.out.println();
		}
	}

	public static int numQueens(int[][] arr){
		int numQ = 0;
		for (int[] row : arr)
		{
			for (int cell : row)
			{
				if(cell == 2)
					numQ++;
			}
			System.out.println();
		}
		return numQ;
	}

	public static boolean placeQueen(int x, int y, int[][] arr)
	{

		if(numQueens(arr) == 8)
			return true;

		if(y >= arr.length) // off board
			return false;
		if(x >= arr[0].length) // off to right
			return placeQueen(y+1, 0, arr);
		if(arr[y][x] == 1 || arr[y][x] == 2) // on legitimate spot
			return placeQueen(x+1, y, arr);


		arr[y][x] = 2;
		drawLines(arr);



		if(placeQueen(x+1, y, arr)){
			printMatrix(arr);
			arr[y][x]=0;
			clearLines(arr);
			return placeQueen(x+1, y, arr);

		}

		else{
			arr[y][x] = 0;
			clearLines(arr);
			return placeQueen(x+1, y, arr);
		}
	}

	public static void drawLines(int[][] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[0].length; j++)
			{
				if(arr[i][j] == 2)
					drawLine(j, i, arr);
			}

		}
	}

	public static void drawLine(int x, int y, int[][] arr)
	{
		//going right
		for(int right = x; right < arr[0].length; right++)
			if(arr[y][right] == 0)
				arr[y][right] = 1;
		//going down
		for(int down = y; down < arr.length; down++)
			if(arr[down][x] == 0)
				arr[down][x] = 1;
		//diagonally down and left
		int dx = x;
		int dy = y;
		while(dx >= 0 && dy < 8){
			arr[dy][dy] = 1;
			dy++;
			dx--;
		}
		//diagonally down and right
		dx = x;
		dy = y;
		while(dx < 8 && dy < 8){
			arr[dy][dy] = 1;
			dy++;
			dx++;
		}
	}

	public static void clearLines(int[][] arr){
		for(int y = 0; y<8; y++){
			for(int x = 0; x<8; x++)
				if(arr[y][x] == 1)
					arr[y][x]=0;
		}

	}


}

