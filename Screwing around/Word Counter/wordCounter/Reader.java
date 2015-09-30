package wordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	protected ArrayList<Word> words = new ArrayList<Word>();
	protected String[] strings;


	public ArrayList<Word> readFile(String FILENAME){
		String phrase = "";
		File file = new File(FILENAME);
		boolean found;

		try{
			Scanner inFile = new Scanner(file);

			while(inFile.hasNextLine()){
				phrase += inFile.nextLine().toLowerCase() +" ";
			}
			
			phrase = phrase.replaceAll("\\p{Punct}+","");
			phrase = phrase.replaceAll("  ", " ");
			
			strings = phrase.split(" ");
			
			System.out.println("Total word count "+strings.length);
			for(int x = 0; x<strings.length; x++){
				
				strings[x].trim();
				found = false;
				
				if(strings[x].length() == 1 && ((int)strings[x].charAt(0) > 122 || (int)strings[x].charAt(0) < 97)){
					found = true;
				}
				
				for(Word w : words){
					if(strings[x].equals(w.getWord())){
						w.incrementCount();
						found = true;
					}
				}

				if(!found){
					words.add(new Word(strings[x]));
				}

			}

			inFile.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Yo you got a runtime ");
			e.printStackTrace();

		}
		return words;
	}
}