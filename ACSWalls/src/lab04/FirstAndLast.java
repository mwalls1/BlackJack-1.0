package lab04;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class FirstAndLast
{
	private String word;
	private char firstLetter;
	private char lastLetter;

	public FirstAndLast()
	{


	}

	public FirstAndLast(String s)
	{
		word = s;
		firstLetter = s.charAt(0);
		lastLetter = s.charAt(s.length()-1);

	}

	public void setString(String s)
	{
		word = s;

	}

	public void findFirstLastLetters()
	{

		firstLetter = word.charAt(0);
		lastLetter = word.charAt(word.length()-1);

	}

 	public String toString()
 	{
 		String output="word : : "+word;
 		output+="\nfirst letter : : "+firstLetter;
 		output+="\nlast letter : : "+lastLetter;
 		output+="\n\n";




 		return output;
	}
}