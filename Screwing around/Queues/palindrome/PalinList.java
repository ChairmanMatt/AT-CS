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
		Queue<String> queue = new LinkedList<String>();
		Stack<String> stack = new Stack<String>();
		
		while(list.length() > 0){
			queue.offer(list.substring(0,1));
			stack.push(list.substring(0,1));
			list = list.substring(1);
		}
	}

	public boolean isPalin()
	{
		while(stack.peek() != null){
			if(stack.pop().equals(queue.poll()))
				return false;
		}
		return true;
	}


	public String toString(){
		
		String toRet = "";
		while(queue != null){
			toRet += queue.poll()+" ";
		}
		return toRet;
	}
}