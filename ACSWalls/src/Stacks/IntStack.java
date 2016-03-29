package Stacks;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

//ArrayList of ints
//or
//array of ints

import java.util.ArrayList;
import static java.lang.System.*;

public class IntStack
{
	//pick your storage for the stack
	//you can use the an array or an ArrayList

	//option 1
	private int[] rayOfInts;
	private int numInts;

	//option 2
	private ArrayList<Integer> listOfInts;

	public IntStack()
	{
		listOfInts = new ArrayList<Integer>();
	}

	public void push(int item)
	{
		listOfInts.add(item);
		numInts++;
	}

	public int pop()
	{
		int a = listOfInts.remove(numInts-1);
		numInts--;
		return a;
		
	}

	public boolean isEmpty()
	{
		for(Integer s: listOfInts)
		{
			if(s==null)
			{
				
			}
			else
				return false;
		}
		return true;
	}

	public int peek()
	{
		return listOfInts.get(numInts-1);
	}

	public String toString()
	{
		String res = "";
		for(Integer s: listOfInts)
		{
			res+=s;
		}
		return res;
	}
}