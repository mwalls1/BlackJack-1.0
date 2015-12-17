package Iterator;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

import static java.lang.System.*;

public class ListIteratorTest
{
	private ArrayList<String> list;
	private String toRemove, replaceWith;

	public ListIteratorTest(String line, String rem, String rep)
	{
		toRemove = rem;
		String[] words = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(words));
		replaceWith = rep;
	}

	public void setTest(String line, String rem, String rep)
	{
		toRemove = rem;
		String[] words = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(words));
		replaceWith = rep;
	}

	public void replace()
	{
		ListIterator<String> it = list.listIterator();
		while(it.hasNext())
		{
			if(it.next().equals(toRemove))
			{
				it.remove();
				it.set(replaceWith);
			}
		}
	}

	public String toString()
	{
		return list.toString()+"\n\n";
	}
}