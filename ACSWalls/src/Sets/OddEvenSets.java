package Sets;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;

	public OddEvenSets()
	{
		odds = new TreeSet<Integer>();
		evens = new TreeSet<Integer>();
	}

	public OddEvenSets(String line)
	{
		this();
		String[] num = line.split(" ");
		int[] nums = new int[num.length];
		for(int i = 0; i < num.length; i ++)
		{
			nums[i] = Integer.parseInt(num[i]);
		}
		for(int i = 0; i < nums.length; i ++)
		{
			if(nums[i]%2==0)
				evens.add(nums[i]);
			else
				odds.add(nums[i]);
		}
	}

	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}