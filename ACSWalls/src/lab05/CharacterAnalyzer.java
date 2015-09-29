package lab05;
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;
	private int asciii;

	public CharacterAnalyzer()
	{


	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;
		asciii = (int)theChar;

	}

	public void setChar(char c)
	{
		theChar = c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{

		if(asciii >=65&&asciii<=90)
			return true;

		return false;
	}

	public boolean isLower( )
	{
		if(asciii >=97&&asciii<=122)
			return true;


		return false;
	}
	
	public boolean isNumber( )
	{
		if(asciii >=48&&asciii<=57)
			return true;


		return false;
	}	

	public int getASCII( )
	{
		return asciii;
	}

	public String toString()
	{
		if (isNumber())
			return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
		else if(isUpper())
			return ""+getChar() + " is an upper case letter."
					+ " ASCII == " + getASCII() + "\n";
		else
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
				



	  
	}
}