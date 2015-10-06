package asterisksAndIntegers;

public class MatrixFiller {

	private static String[][] matrix = new String[10][10];
	private static int sumOfAllInts = 0;

	public static void main(String[] args) {

		//fill the array
		fillArray(0,0);
		//print the array
		printArr();
		System.out.println();
		System.out.println(sumOfAllInts);
	}

	/**
	 * Fills the array recursively
	 * @param down re
	 * .presenting how many rows down
	 * @param right representing how many columns right
	 */
	public static void fillArray(int down, int right){
		//base case
		if(down == matrix.length)
			return;

		//fill current spot in array
		matrix[down][right] = getThing();

		//moves to start of next line if at end of current line
		if(right == matrix[0].length-1){
			down++;
			right = 0;
		}
		//otherwise moves right another index
		else right++;

		//recursive call
		fillArray(down, right);
	}

	/**
	 * Semi-random generation of things to put in each spot in the array. 
	 * @return either "*" or integer from 1-9
	 */
	private static String getThing(){
		//30% chance for asterisk
		if(Math.random() < 0.3){
			return "*";
		}
		else{
			//numbers from 1-9 inclusive
			int num = (int)(Math.random()*9)+1;
			sumOfAllInts +=num;
			return num+"";
		}
	}

	/**
	 * Prints out contents of array to console. 
	 */
	private static void printArr(){
		for(int x = 0; x<matrix.length; x++){
			for(int y = 0; y<matrix[0].length; y++){
				System.out.print(matrix[x][y]+" ");
			}
			System.out.println();
		}
	}

}
