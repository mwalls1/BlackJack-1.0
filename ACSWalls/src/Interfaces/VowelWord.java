package Interfaces;

//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class VowelWord implements Comparable<VowelWord>
{
	//add a string instance variable
	private String myWord = "";
	//add a constructor
	public VowelWord(String a)
	{
		myWord = a;
	}
	public int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		for(int i = 0; i < myWord.length()-1; i ++)
		{
			if(vowels.contains(myWord.substring(i, i+1)))
					{
					vowelCount++;
					}
		}
		return vowelCount;
	}

	public int compareTo(VowelWord other)
	{
		if (this.myWord.numVowels() > other.VowelWord.numVowels()) {
			return 1;
		} else if (this.myWord.length() < other.myWord.length()) {
			return -1;
		} else
			return this.myWord.compareTo(other.myWord);
	}

	public String toString()
	{
		return "";
	}
}