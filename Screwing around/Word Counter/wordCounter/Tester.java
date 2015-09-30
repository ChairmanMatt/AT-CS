package wordCounter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tester {

	private final static String FILENAME = "C:/Users/Matt Lu/Documents/dream.txt";
	
	public static void main(String[] args) {
		Reader r = new Reader();
		ArrayList<Word> wd = r.readFile(FILENAME);
		
		
		processWords(wd);
	}
	

	public static void processWords(ArrayList<Word> wd){
		selectionSort(wd, 0);
		
		for(int x = wd.size()-1; x>=wd.size()-30; x--){
			System.out.println(wd.get(x).getWord() + " " + wd.get(x).getNumOccurrences());
		}
		
		System.out.println("Unique word count: "+wd.size());
		
	}
	
	
	
	
	public static void selectionSort(ArrayList<Word> wd, int startIndex)
	{
	    if ( startIndex >= wd.size()-1 )
	        return;
	    int minIndex = startIndex;
	    for ( int index = startIndex + 1; index < wd.size(); index++ )
	    {
	        if (wd.get(index).getNumOccurrences() < wd.get(minIndex).getNumOccurrences() )
	            minIndex = index;
	    }
	    Word temp = wd.get(startIndex);
	    
	    wd.set(startIndex, wd.get(minIndex)); 
	    
	    wd.set(minIndex, temp);
	    selectionSort(wd, startIndex + 1);
	}
	
}

