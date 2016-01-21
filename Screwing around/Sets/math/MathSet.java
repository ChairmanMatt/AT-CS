package math;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

import static java.lang.System.*;

public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	public MathSet()
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
	}

	public MathSet(String o, String t)
	{
		one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();

		String[] split = o.split(" ");
		for(int x = 0; x< split.length; x++)
			one.add(Integer.parseInt(split[x]));

		split = t.split(" ");
		for(int x = 0; x< split.length; x++)
			two.add(Integer.parseInt(split[x]));

	}

	public Set<Integer> union()
	{
		Set<Integer> temp = new TreeSet<Integer>(); 
		temp.addAll(one);
		temp.addAll(two);
		
		return temp;
	}

	public Set<Integer> intersection()
	{
		Set<Integer> overlap = new TreeSet<Integer>();
		Set<Integer> temp = new TreeSet<Integer>(); 
		temp.addAll(one);
		Iterator<Integer> it = two.iterator();
		int i;
		
		while(it.hasNext()){
			i = it.next();
			if(! temp.add(i))
				overlap.add(i);
		}
		
		return overlap;
	}

	public Set<Integer> differenceAMinusB()
	{
		Set<Integer> aNotB = new TreeSet<Integer>();
		Set<Integer> temp = new TreeSet<Integer>(); 
		temp.addAll(one);
		Iterator<Integer> it = two.iterator();
		int i;
		
		while(it.hasNext()){
			i = it.next();
			if(temp.add(i))
				aNotB.add(i);
		}
		
		return aNotB;
	}

	public Set<Integer> differenceBMinusA()
	{
		Set<Integer> bNotA = new TreeSet<Integer>();
		Set<Integer> temp = new TreeSet<Integer>(); 
		temp.addAll(two);
		Iterator<Integer> it = one.iterator();
		int i;
		
		while(it.hasNext()){
			i = it.next();
			if(temp.add(i))
				bNotA.add(i);
		}
		
		return bNotA;
	}

	public Set<Integer> symmetricDifference()
	{		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.addAll(differenceAMinusB());
		ts.addAll(differenceBMinusA());
		
		return ts;
	}	

	public String toString()
	{
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}
}