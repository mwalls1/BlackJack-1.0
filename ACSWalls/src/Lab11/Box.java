package Lab11;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Box
{
   private int size;

	public Box()
	{




	}

	public Box(int count)
	{

		size = count;


	}

	public void setSize(int count)
	{

		size = count;

	}

	public int getSize()
	{
		return size;
	}

	public String toString()
	{
		String output="";
		for(int i = 0;i<=size;i++)
		{
				for(int whatever = 0; whatever <= (size-i); whatever ++)
				{
					output+="*";
				}
				for(int whatever = 0; whatever <= (i); whatever ++)
				{
					output+="#";
				}
			output+= "\n";
	}
		return output;
	}
}