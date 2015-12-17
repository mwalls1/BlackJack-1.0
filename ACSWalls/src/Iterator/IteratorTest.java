package Iterator;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.System.*;

public class IteratorTest
{
	private ArrayList<String> list;
	private String toRemove;
	private String reg;

	public IteratorTest(String line, String rem)
	{
		reg = line;
		toRemove = rem;
		String[] words = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(words));
	}

	public void setTest(String line, String rem)
	{
		toRemove = rem;
		String[] words = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(words));

	}

	public void remove()
	{
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			if(it.next().equals(toRemove))
			{
				it.remove();
			}
		}
	}

	public String toString()
	{
		return "Original String: "+reg+"\nNew String: "+list;
	}
}