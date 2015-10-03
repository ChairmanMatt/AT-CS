package eightQueens;

public class ChessBoard {

	char[][] board; 
	int down = 0;
	int right = 0;
	int moveNumber = 0;
	int numberOfQueens = 0;

	public ChessBoard(char[][] board){
		this.board = board;

	}

	public boolean fill(){
		return place(down, right, 0);
	}

	public boolean place(int d, int r, int moveNumber)
	{
		if(d > 7 && r <=7)
			d = 0;
			
		if (board[d][r] == 'x' || board[d][r] == 'Q')
		{
			board[d][r] = 'Q';
			place
		}

		if()




		



		//out of board
		if((d < 0 || d > 7) || (r < 0 || r > 7))
			return false;


		board[d][r]='Q';
		return place(d, r, moveNumber +1);
		return true;
	}

	public void drawLines(int d, int r){
		//vertical
		for(int y=0; y<8; y++){
			if(y!=d)
				board[y][r]='x';
		}

		//horizontal
		for(int x=0; x<8; x++){
			if(x!=r)
				board[d][x]='x';
		}
		
		int dtemp = d+1;
		int rtemp = r+1;
		while(dtemp < 7 && rtemp < 7)
		{
			board[dtemp][rtemp] = 'x';	
			dtemp++;
			rtemp++;
		}
		
		dtemp = d-1;
		rtemp = r-1;
		while(dtemp > 0 && rtemp > 0)
		{
			board[dtemp][rtemp] = 'x';
			dtemp --;
			rtemp --;
		}
		
		dtemp = d+1;
		rtemp = r+1;
		while(dtemp < 7 && rtemp < 7)
		{
			board[dtemp][rtemp] = 'x';	
		}
		
		dtemp = d+1;
		rtemp = r+1;
		while(dtemp < 7 && rtemp < 7)
		{
			board[dtemp][rtemp] = 'x';	
		}
		
		
		
	}

}
