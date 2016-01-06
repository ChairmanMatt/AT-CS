package palindrome;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;
	private String QSstr;


	public PalinList()
	{
		setList("");
	}

	public PalinList(String list)
	{
		setList(list);

	}

	public void setList(String list)
	{
		QSstr = list;
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		
		
		String[] str = QSstr.split(" ");
		
		for(int ind = 0; ind < str.length; ind++){

			queue.offer(str[ind]);
			stack.push(str[ind]);
			list = list.substring(list.indexOf(" "));
		}

	}

	public boolean isPalin()
	{
		while(queue.peek() != null && stack.peek() != null){
			if(stack.peek().compareTo(queue.peek()) != 0)
				return false;
			stack.pop();
			queue.poll();
		}

		return true;
	}


	public String toString(){
		System.out.println("S Size "+stack.size());
		System.out.println("Q Size "+queue.size());

		return QSstr;
	}
}