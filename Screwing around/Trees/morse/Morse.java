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
		return (letter-((Morse)o).getLetter());
		
//		if(index-((Morse)o).getIndex() > 0)
//			return 1;
//		if(index-((Morse)o).getIndex() < 0)
//			return -1;
//		
//		return 0;
	}


	public String toString(){
		return letter + "";
	}
}
