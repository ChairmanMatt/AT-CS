package worksheet_5_2;

public class HistoNode
{
	private Comparable obj;
	private int count;
	private HistoNode next;

	public HistoNode(Comparable obj, int cnt, HistoNode n)
	{
		this.obj = obj;
		this.count = cnt;
		next = n;
	}

	public Comparable getObject()
	{
		return obj;
	}

	public int getCount()
	{
		return count;
	}

	public HistoNode getNext()
	{
	   return next;
	}

	public void setValue(Comparable let)
	{
		obj = let;
	}

	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setNext(HistoNode n)
	{
		next = n;
	}
}


