package wordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	protected ArrayList<Word> words = new ArrayList<Word>();
	private final String FILENAME = "H:/dreams.txt";

	public ArrayList<Word> readFile(){
		String phrase;
		File file = new File(FILENAME);
		boolean found;
		try{
			Scanner inFile = new Scanner(file);

			while(inFile.hasNextLine()){
				found = false;
				phrase = inFile.nextLine();

				for(Word w : words){
					if(phrase.equals(w.getWord())){
						w.incrementCount();
						found = true;
					}
				}
				if(! found){
					words.add(new Word(phrase));
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Yo you got a runtime ");
			e.printStackTrace();
		}
		return words;
	}
}
