package HashMaps;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.LinkedList;
import java.util.Scanner;
import static java.lang.System.*;

public class HashTable
{
	private LinkedList[] table;

	public HashTable( )
	{
		table = new LinkedList[10];
		for(int i =0; i < table.length; i ++)
		{
			table[i]=new LinkedList<Word>();
		}
	}

	public void add(Object obj)
	{
		int i = obj.hashCode();
		System.out.print(obj+" ");
		System.out.print(i+"\n");
		if(!(table[i].contains(obj))){
			table[i].add(obj);
		}
	}

	public String toString()
	{
		String output="HASHTABLE\n";
		for(int i = 0; i < table.length; i ++)
		{
			output+="bucket "+i+": "+table[i]+"\n";
		}
		return output;
	}
}