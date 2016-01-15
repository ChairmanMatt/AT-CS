package dup;

import static java.lang.System.*;
import java.util.*;

public class DupRunner
{
	public static void main( String args[] )
	{
		UniquesDupes ud = new UniquesDupes();
		System.out.println(ud.getUniques("a b c d e f g h a b c d e f g h i j k"));
		System.out.println(ud.getDupes("a b c d e f g h a b c d e f g h i j k"));
		
		
	}
}