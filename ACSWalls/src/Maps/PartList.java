package Maps;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;
	
	public PartList()
	{
		partsMap = new TreeMap <Part,Integer>();

	}
	
	public PartList(String fileName)
	{
		this();
		try
		{
			Scanner file = new Scanner(new File("data/lab08d.dat"));
			//add code here to read from the file 
			//and add Parts to the map
			while(file.hasNext())
			{
				Part p = new Part(file.nextLine());
				if(partsMap.get(p)==null)
				{
					partsMap.put(p, 0);
				}
				partsMap.put(p, partsMap.get(p)+1);
			}




		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}
	
	public String toString()
	{
		String output="";
		for(Part p: partsMap.keySet())
		{
			output+=p+" "+partsMap.get(p)+"\n";
		}




		return output;
	}
}