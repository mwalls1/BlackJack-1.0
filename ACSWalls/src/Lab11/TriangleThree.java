package Lab11;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;
   private int numLetters;
	public TriangleThree()
	{
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public 
	void setTriangle( String let, int sz )
	{
		letter = let;
		size = sz;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String output="";
		for(int i = 0;i<=size;i++)
		{
			for(int j = 0;j<i;j++)
			{
				output+=letter;
			}
			output+= "\n";
		}
		return output;
	}
}