package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{


	}

	public StringChecker(String s)
	{

		word = s;
	}

   public void setString(String s)
   {
   		word=s;
   }

	public boolean findLetter(char c)
	{

		for(int i=0; i<word.length(); i++)
			if(word.charAt(i) == c)
				return true;

		return false;
	}

	public boolean findSubString(String s)
	{
		if(word.contains(s))
			return true;

		return false;
	}

 	public String toString()
 	{
 		return word+"\n\n";
	}
}