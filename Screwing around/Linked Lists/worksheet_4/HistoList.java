package worksheet_4;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.*;
import static java.lang.System.*;

public class HistoList
{
	private HistoNode front;

	public HistoList()
	{
		front = null;
	}

	//addLetter will add a new node to the front for let if let does not exist
	//addLetter will bump up the count if let already exists
	public void addLetter(char let)
	{
		if(front == null){
			front = new HistoNode(let, 0, null);
			return;
		}

		int count = 0;

		if(indexOf(let) == -1){
			front = new HistoNode(let, 1, front);
			return;
		}

		nodeAt(indexOf(let)).setLetterCount(nodeAt(indexOf(let)).getLetterCount()+1);

		front.setNext(new HistoNode(let, count, null));
	}

	//returns the index pos of let in the list if let exists
	public int indexOf(char let)
	{
		if(front == null)
			return -1;

		HistoNode temp = new HistoNode(front.getLetter(), front.getLetterCount(), front.getNext());
		
		//for one-element lists
		if(temp.getLetter() == let)
			return 1;

		int count = 1;

		while(temp.getNext() != null){
			if(temp.getLetter() == let)
				return count;
			count++;
			temp = temp.getNext();
		}

		return -1;
	}

	//returns a reference to the node at spot
	private HistoNode nodeAt(int spot)
	{
		HistoNode current = front;
		
		for(int x = 1; x < spot; x++){
			if(front.getNext() == null)
				return null;

			current = front.getNext();
			front = front.getNext();
		}

		return current;
	}

	//returns a string will all values from list
	public String toString()
	{
		String output = "";

		while(front.getNext() != null){
			output+=front.getLetter() + "";
			front = front.getNext();
		}

		return output;
	}
}