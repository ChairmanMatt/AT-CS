package wordCounter;

public class Word {
	
	private String word;
	private int numOccurrences;
	
	public Word(String word){
		this.word = word;
		numOccurrences = 1;
	}
	
	public void incrementCount(){
		numOccurrences++;
	}
	
	public int getNumOccurences(){
		return numOccurrences;
	}
	
	public String getWord(){
		return word;
	}
	
}
