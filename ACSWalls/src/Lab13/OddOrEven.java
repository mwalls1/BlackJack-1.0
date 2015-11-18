package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class OddOrEven
{
	private int number;

	public OddOrEven()
	{


	}

	public OddOrEven(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}

	public boolean isOdd( )
	{
		if(number%2==1)
			return true;


		return false;
	}

	public String toString()
	{

		if(isOdd())
				return number+" is odd.\n\n";
		return number+" is even.\n\n";
	}
}