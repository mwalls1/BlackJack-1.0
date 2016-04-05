package Qs;

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

public class IntQueue
{
	//pick your storage for the queue
	//you can use the an array or an ArrayList

	//option 1
	private int[] rayOfInts;
	private int numInts=0;

	//option 2
	private ArrayList<Integer> nums;

	public IntQueue()
	{
		nums = new ArrayList<Integer>();
	}

	public void add(int item)
	{
		nums.add(item);
		numInts++;
	}

	public int remove()
	{
		if(nums.size()>0)
		{
			numInts--;
			return nums.remove(0);
		}
		else
			return 0;
	}

	public boolean isEmpty()
	{
		return nums.size()==0;
	}

	public int peek()
	{
		return nums.get(0);
	}

	public String toString()
	{	
		String out = "";
		for(int i = 0; i < numInts; i ++)
		{
			out+=nums.get(i);
		}
		return out;
	}
}