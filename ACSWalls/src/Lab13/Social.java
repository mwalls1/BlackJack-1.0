package Lab13;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

import java.util.Scanner;

public class Social
{
   private String socialNum;

	public Social()
	{


	}

	public Social(String soc)
	{

		socialNum = soc;
	}

	public void setSocial(String soc)
	{
		socialNum = soc;

	}

	public int getSum()
	{
		int sum = 0;
		
		Scanner scan = new Scanner(socialNum);
		scan.useDelimiter("-");
		while(scan.hasNextInt())
			sum+=scan.nextInt();
		
		return sum;


	}

	public String toString()
	{
		return "Social #: "+socialNum+" has a sum of: "+getSum();
	}
}