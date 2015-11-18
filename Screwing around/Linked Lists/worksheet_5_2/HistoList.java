package worksheet_5_2;

import worksheet_5_2.HistoNode;

public class HistoList
{
	private HistoNode front;
	private int count;
	
	public HistoList()
	{
	}

	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
		if(front == null){
			front = new HistoNode((Comparable) obj, 1, null);
			return;
		}
		HistoNode temp = front;
		while(temp.getNext() != null){
			if(temp.getObject().equals(obj)){
				temp.setCount(temp.getCount() + 1);
				return;
			}
			else
				temp = temp.getNext();
		}
		if(temp.getObject() == obj)
			temp.setCount(temp.getCount() + 1);
		else
		temp.setNext(new HistoNode((Comparable) obj, 1, null));
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		HistoNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(temp.getObject().equals(obj))
				return count;
			temp = temp.getNext();
			count++;
		}
		return -1;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private HistoNode nodeAt(int spot)
	{
		HistoNode temp = front;
		int count = 0;
		while(temp.getNext() != null){
			if(count == spot)
				return temp;
			temp = temp.getNext();
			count++;
		}
		return null;
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		HistoNode temp = front;
		String ret = "";
		while(temp.getNext() != null){
			ret += "(" + temp.getObject().toString() + "/" + temp.getCount() + "), ";
			temp = temp.getNext();
		}
		ret += "(" + temp.getObject().toString() + "/" + temp.getCount() + ")";
		
		return ret;
	}
}