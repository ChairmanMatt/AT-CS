package eightQueens;
//Matt Lu and Justin Chao

import java.util.Arrays;

public class EightQueenChecker {

	public static int count = 0;

	public static void main(String[] args) {
		int a[][] = {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
		};

		prepareForQueen(0, a);
	}

	public static void printQueensOnChessBoard(int row, int a[][]) {
		if (row < 7) return;
		count +=1;
		System.out.println();
		System.out.println("-- Result " + count + " -----");
		System.out.println("   1 2 3 4 5 6 7 8");
		for (int i=0; i<8; i+=1) {
			System.out.print(" " + (i + 1));
			for (int j=0; j<8; j+=1) {
				if (a[i][j] == 1) {
					System.out.print(" Q");
				} else if (a[i][j] == -1) {
					System.out.print(" .");
				} else if (a[i][j] == 0) {
					System.out.print(" Q");
				}
			}
			System.out.println();
		}
	}


	/*
	 *  Not yet finalized
	 *  X <-- a[i][j] == -1
	 *  Q <-- a[i][j] == 1
	 *  blank elsewhere
	 */
	public static void printWorkingChessBoard(int a[][]) {
		System.out.println();
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (a[i][j] == 1) {
					System.out.print(" Q");
				} else if (a[i][j] == -1) {
					System.out.print(" x");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	public static int[][] deepCopy(int[][] a) {
		final int[][] b = new int[8][];
		for (int i=0; i < 8; i++) {
			b[i] = Arrays.copyOf(a[i], 8);
		}
		return b;
	}

	/*
	 *  given a matrix and row number, return
	 *     -1  if it is dead-end: i.e. all equals -1
	 *      1  if there is a queen there, elsewhere -1
	 *      n: number of 0s there
	 *    100: if row == 8, done
	 */
	public static int checkRowStatus(int i, int a[][]) {
		if (i == 8) return 100;
		int q = -1;        // queen's position on ith row
		int c = 0;         // count number of cells with value -1
		for (int j=0; j<8; j++) {
			if (a[i][j] == 1) {
				if (q == -1 && c == j-1) {
					q = j;
				} else {
					// already there is queen , BAD BAD <-- DEAD here
					return -1;
				}
			} else if (a[i][j] == -1) {
				c += 1;
			}
		}
		if (q == 1 && c == 7) {
			return 1;
		}
		if (q == 1 && c < 7) {
			// matrix not well prepared, BAD
			return -1;
		}
		return 8 - c;
	}



	/*
	 *  given row i, checked status with some 0s there (no queen)
	 *  try put queen in jth place that is blank, then cross conflict cells which is not already -1
	 */
	public static boolean prepareForQueen(int i,  int cb[][]) {
		int retVal = checkRowStatus(i, cb);
		if (retVal <= 0)
			return false;
		if (i == 7 ) { // we are done
			printQueensOnChessBoard(i, cb);
			return true;
		}

		for (int j=0; j < 8; j++) {
			if (cb[i][j] != 0) continue;

			int a[][] = deepCopy(cb);

			// first mark all cells -1 aside from jth cell in row i, if not already -1
			for (int k = 0; k < 8; k++) {
				if (k==j)
					a[i][k] = 1;  // spot for queen
				else if (a[i][k] == 0) 
					a[i][k] = -1;
				else if (a[i][k] == 1) {
					System.out.print("PROBLEM");
					return false; // conflict
				}
			}

			// mark all cells below this cell -1
			for (int k = i +1; k < 8; k++) {
				if (a[k][j] == 1) {
					System.out.print("PROBLEM");
					return false;  // conflict
				}
				if (a[k][j] == 0)
					a[k][j] = -1;
			}

			// mark left diagonal places -1
			if (j > 0 && i < 7) {
				for (int k = 1; i+k < 8 && j-k >=0; k++) {
					int row = i+k;
					int col = j-k;
					if (a[row][col] == 1) {
						System.out.print("PROBLEM");
						return false;
					}
					if (a[row][col] == -1)
						continue;
					if (a[row][col] == 0)
						a[row][col] = -1;
				}
			}

			// mark right diagonal places -1
			if (j < 7 && i < 7) {
				for (int k=1; k <= 7-i && k <= 7-j; k++) {
					int row = i + k;
					int col = j + k;
					if (a[row][col] == 1)
						return false;
					if (a[row][col] == -1)
						continue;
					if (a[row][col] == 0)
						a[row][col] = -1;
				}
			}   

			prepareForQueen(i+1, a);
		}

		return true;
	}

}