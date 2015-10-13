package sudoku;

public class Solver {

	public static void main(String[] args) {
		Solver s = new Solver();
		char[][] board = {{'.', '2', '6', '5', '.', '.', '.', '9', '.'},
				{'5', '.', '.', '.', '7', '9', '.', '.', '4'},
				{'3', '.', '.', '.', '1', '.', '.', '.', '.'},
				{'6', '.', '.', '.', '.', '.', '8', '.', '7'},
				{'.', '7', '5', '.', '2', '.', '.', '1', '.'},
				{'.', '1', '.', '.', '.', '.', '4', '.', '.'},
				{'.', '.', '.', '3', '.', '8', '9', '.', '2'},
				{'7', '.', '.', '.', '6', '.', '.', '4', '.'},
				{'.', '3', '.', '2', '.', '.', '1', '.', '.'}};

		s.solver(board);
		
		for(char[] c : board){
			for(char d : c){
				System.out.print(d + " ");
				
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 
	 * @param board represents the sudoku board as a 2D array of chars
	 * @return true if and only if all spots on the board are filled with correct numbers. 
	 */
	
	/**
	 * Goes through every single cell and checks if there is already a number in there.
	 * if there isn�t, it tries all the number starting from 1 and end at 9.
	 * It places the number in there and checks if it is valid. And then calls
	 * @param boardrepresents the sudoku board as a 2D array of chars
	 * @return true if and only if all spots on the board are filled with correct numbers
	 * 		   false if and only if there are no possible solutions for the entire board. 
	 */
	public boolean solver(char[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] == '.') {
					for (int k = 1; k <= 9; k++) {
						board[r][c] = (char) ('0' + k);
						if (isValid(board, r, c) && solver(board)) {
							return true;
						} else {
							board[r][c] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValid(char[][] board, int r, int c) {
		//check row
		boolean[] row = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[r][i] >= '1' && board[r][i] <= '9') {
				if (row[board[r][i] - '1'] == false) {
					row[board[r][i] - '1'] = true;
				} else {
					return false;
				}
			}
		}

		//check column
		boolean[] col = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][c] >= '1' && board[i][c] <= '9') {
				if (col[board[i][c] - '1'] == false) {
					col[board[i][c] - '1'] = true;
				} else {
					return false;
				}
			}
		}

		//check the 3*3 grid
		boolean[] grid = new boolean[9];
		for (int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
			for (int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
				if (board[i][j] >= '1' && board[i][j] <= '9') {
					if (grid[board[i][j] - '1'] == false) {
						grid[board[i][j] - '1'] = true;
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}
}