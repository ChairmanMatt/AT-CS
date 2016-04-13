package monsters2;

import java.util.ArrayList;
import java.util.List;

public class YourPQ
{
	private List<Monster> list;


	public YourPQ()
	{
		list = new ArrayList<Monster>();
		list.add(null);
		System.out.println(list);

	}

	public void add(Monster m){
		list.add(m);
		swapUp(list.size()-1);
	}

	public Object getMin()
	{
		return list.get(1);
	}

	//write a toString method

	public void swapUp(int bot)
	{
		if(bot <= 1)
			return;

		if(list.get(bot/2).compareTo(list.get(bot)) > 0){
			swap(bot, bot/2);
		}

		swapUp(bot/2);
	}

	public Object removeMin(){
		Monster temp = list.get(1);
		swap(1, list.size()-1);
		list.remove(1);
		swapDown(1);

		return temp;
	}

	public void swapDown(int top){
		//base
		if(top*2 >= list.size())
			return;

		if(list.get(top*2).compareTo(list.get(top)) < 0){
			swap(top*2, top);
			swapDown(top*2);
		}

		if(top*2+1 >= list.size())
			return;

		else if(list.get(top*2 + 1).compareTo(list.get(top)) < 0){
			swap(top*2 + 1, top);
			swapDown(top*2+1);
		}
	}

	private void swap(int start, int finish){
		Monster temp = list.get(finish);
		list.set(finish, list.get(start));
		list.set(start, temp);
	}

	public String toString()
	{
		return list.toString()+"\n";
	}

}