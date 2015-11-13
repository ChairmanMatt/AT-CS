package worksheet_5_1;

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
	}
	
	public ThingCount(Object thang, int cnt)
	{
		thing = thang;
		count = cnt;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		ThingCount other = (ThingCount) obj;
		
		if(other.getThing().equals(thing)){
			if(other.getCount() == (count))
				return true;
		}
		
		return false;
	}
	
	public int compareTo(Object obj)
	{
		ThingCount other = (ThingCount)obj;
		
		if(! other.getThing().equals(thing)){
			return ((Comparable) thing).compareTo(((Comparable)other.getThing()));
		}
		
		
		if(other.getThing().equals(thing)){
			return count-other.getCount();
		}
		
		return -1;		
	}
	
	public String toString()
	{
		return getThing() + " - " + getCount();
	}
}