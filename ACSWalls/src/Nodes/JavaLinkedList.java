package Nodes;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import static java.lang.System.*;

public class JavaLinkedList
{
	private LinkedList<Integer> list;

	public JavaLinkedList()
	{
		list = new LinkedList<Integer>();
	}

	public JavaLinkedList(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
		for(int num: list)
		{
			total+=num;
		}

		return total;
	}

	public double getAvg(  )
	{
		return getSum()/list.size();
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
		for(int num: list)
		{
			if(num>largest)
			{
				largest = num;
			}
		}
		return largest;
	}

	public int getSmallest()
	{
		int smallest = smallest=Integer.MAX_VALUE;
		for(int num: list)
		{
			if(num<smallest)
			{
				smallest = num;
			}
		}
		return smallest;
	}

	public String toString()
	{
		String output= "Sum: "+getSum()+"\nAverage: "+getAvg()+"\nSmallest: "+getSmallest()+"\nLargest: "+getLargest()+"\n";
		return output;
	}
}