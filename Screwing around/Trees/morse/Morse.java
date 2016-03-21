package morse;

public class Morse implements Comparable{

	private int index;
	private char letter;
	
	public Morse(int ind, char let){
		index = ind;
		letter = let;
	}

	public char getLetter(){
		return letter;
	}
	
	public int getIndex(){
		return index;
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return index - ((Morse)o).getIndex();
	}
	
	
	public String toString(){
		return letter + "";
	}
}
