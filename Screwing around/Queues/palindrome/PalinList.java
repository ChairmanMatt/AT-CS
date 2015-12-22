package palindrome;
//PalinLins.java

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;

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
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		
		while(list.length() > 0){
			queue.offer(list.substring(0,1));
			stack.push(list.substring(0,1));
			list = list.substring(1);
			System.out.println(list);
		}
	}

	public boolean isPalin()
	{
		while(stack.peek() != null && queue.peek() != null){
			if(stack.peek().compareTo(queue.peek()) != 0)
				return false;
			
			stack.pop();
			queue.poll();
		}
		return true;
	}


	public String toString(){
		
		String toRet = "";
		while(queue.peek() != null){
			toRet += queue.poll()+"";
		}
		return toRet;
	}
}